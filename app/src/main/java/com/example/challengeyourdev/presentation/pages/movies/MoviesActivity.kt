package com.example.challengeyourdev.presentation.pages.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.challengeyourdev.R
import com.example.challengeyourdev.core.utils.Response
import com.example.challengeyourdev.core.utils.Status
import com.example.challengeyourdev.domain.entities.Movie
import com.example.challengeyourdev.presentation.pages.favorite_movies.FavoriteMoviesActivity
import com.example.challengeyourdev.presentation.widgets.InfiniteScrollListener
import kotlinx.android.synthetic.main.activity_movies.*
import org.koin.androidx.viewmodel.ext.android.viewModel

//criado por arthur rodrigues

@Suppress("UNCHECKED_CAST")
class MoviesActivity : AppCompatActivity() {

    private val viewModel : MoviesViewModel by viewModel()
    private var moviesAdapter: MoviesAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        viewModel.response().observe(this, Observer { response -> processResponse(response) })
        viewModel.searchResponse().observe(this, Observer { response -> processSearchResponse(response) })

        viewModel.getMovies()

        ic_bookmark.setOnClickListener {
            intent = Intent(this, FavoriteMoviesActivity::class.java)
            startActivity(intent)
        }

        iv_search.setOnClickListener { getSearchMovies() }
    }

    private fun processResponse(response : Response){
        when (response.status) {
            Status.LOADING -> showLoading()
            Status.SUCCESS -> showMovies(response.data)
            Status.ERROR -> showError(response.error)
        }
    }

    private fun processSearchResponse(response : Response){
        val searchList = response.data as ArrayList<Movie>
        pg_loading.visibility = View.GONE
        rv_movies.adapter = MoviesAdapter(this, arrayListOf(), ::onFavoriteClick)
        rv_movies.adapter = MoviesAdapter(this, searchList, ::onFavoriteClick)

    }

    private fun showMovies(data : Any?) {

        pg_loading.visibility = View.GONE
        rv_movies.visibility = View.VISIBLE

        if(data is List<*>){
            data.size
            if(moviesAdapter == null){
                moviesAdapter = MoviesAdapter(this, data as ArrayList<Movie>, ::onFavoriteClick)
                val layoutManager = GridLayoutManager(this, 2)
                rv_movies.layoutManager = layoutManager
                rv_movies.addOnScrollListener(
                    InfiniteScrollListener({
                        viewModel.loadMoreMovies()
                    }, layoutManager)
                )
                rv_movies.adapter = moviesAdapter
            }
            else{
                moviesAdapter?.setList(data as ArrayList<Movie>)
            }
        }
    }

    private fun showError(error: Throwable?) {

        if(moviesAdapter == null) {
            pg_loading.visibility = View.GONE
            ll_error.findViewById<TextView>(R.id.tv_error).text = error?.message
            ll_error.visibility = View.VISIBLE
        }

    }

    private fun showLoading(){
        if (moviesAdapter == null) {
            pg_loading.visibility = View.VISIBLE
            rv_movies.visibility = View.GONE
            ll_error.visibility = View.GONE
        }
    }

    private fun getSearchMovies(){
        pg_loading.visibility = View.VISIBLE
        viewModel.getSearchMovies(et_input.text.toString())
    }
    private fun onFavoriteClick(movie: Movie) {
        viewModel.favoriteOrDisfavorMovie(movie)
    }
}