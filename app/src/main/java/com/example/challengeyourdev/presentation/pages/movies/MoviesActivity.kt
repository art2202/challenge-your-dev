package com.example.challengeyourdev.presentation.pages.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.challengeyourdev.R
import com.example.challengeyourdev.core.utils.Response
import com.example.challengeyourdev.core.utils.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

//criado por arthur rodrigues

class MoviesActivity : AppCompatActivity() {

    private val viewModel : MoviesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        viewModel.response().observe(this, Observer { response -> processResponse(response) })
        viewModel.getMovies()
    }

    private fun processResponse(response : Response){
        when (response.status) {
            Status.LOADING -> println("carregando")
            Status.SUCCESS -> showMovies(response.data)
            Status.EMPTY_RESPONSE -> {
            }
            Status.ERROR -> showError(response.error)
        }
    }

    private fun showMovies(data : Any?) {

    }

    private fun showError(error: Throwable?) {

    }
}