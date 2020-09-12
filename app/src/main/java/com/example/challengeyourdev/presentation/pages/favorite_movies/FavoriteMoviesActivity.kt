package com.example.challengeyourdev.presentation.pages.favorite_movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengeyourdev.R
import com.example.challengeyourdev.core.utils.Response
import com.example.challengeyourdev.core.utils.Status
import com.example.challengeyourdev.domain.entities.Movie
import com.example.challengeyourdev.presentation.pages.movies.MoviesAdapter
import com.example.challengeyourdev.presentation.widgets.InfiniteScrollListener
import kotlinx.android.synthetic.main.activity_movies.*
import org.koin.androidx.viewmodel.ext.android.viewModel

@Suppress("UNCHECKED_CAST")
class FavoriteMoviesActivity : AppCompatActivity() {

    private val viewModel : FavoriteMoviesViewModel by viewModel()
    private var moviesAdapter: FavoriteMoviesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_movies)

        viewModel.response().observe(this, Observer { response -> processResponse(response) })
        viewModel.getFavoriteMovies()
    }

    private fun processResponse(response : Response){
        when (response.status) {
            Status.LOADING -> showLoading()
            Status.SUCCESS -> showMovies(response.data)
            Status.ERROR -> showError(response.error)
        }
    }
    private fun showMovies(data : Any?) {

        pg_loading.visibility = View.GONE
        rv_movies.visibility = View.VISIBLE

        if(data is List<*>){
            data.size
            val listOrder = arrayListOf<Movie>()
            listOrder.addAll((data as ArrayList<Movie>).sortedByDescending { it.isFavorite })
            if(moviesAdapter == null){
                moviesAdapter = FavoriteMoviesAdapter(listOrder, ::onFavoriteClick)
                val layoutManager = LinearLayoutManager(this)
                rv_movies.layoutManager = layoutManager
                rv_movies.adapter = moviesAdapter
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

    private fun onFavoriteClick(movie: Movie) {
        viewModel.favoriteOrDisfavorMovie(movie)
    }
}