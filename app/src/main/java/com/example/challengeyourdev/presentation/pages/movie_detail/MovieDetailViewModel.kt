package com.example.challengeyourdev.presentation.pages.movie_detail

import androidx.lifecycle.ViewModel
import com.example.challengeyourdev.domain.entities.Movie
import com.example.challengeyourdev.domain.usecases.FavoriteOrDisfavorMovie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//criado por arthur rodrigues

class MovieDetailViewModel(val favoriteOrDisfavorMovieUseCase: FavoriteOrDisfavorMovie) : ViewModel(){


    fun favoriteOrDisfavorMovie(movie : Movie){
        CoroutineScope(Dispatchers.IO).launch {
            favoriteOrDisfavorMovieUseCase(movie)
        }
    }
}