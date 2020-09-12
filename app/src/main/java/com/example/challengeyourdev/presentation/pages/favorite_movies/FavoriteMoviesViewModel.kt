package com.example.challengeyourdev.presentation.pages.favorite_movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challengeyourdev.core.utils.Response
import com.example.challengeyourdev.domain.entities.Movie
import com.example.challengeyourdev.domain.usecases.FavoriteOrDisfavorMovie
import com.example.challengeyourdev.domain.usecases.GetFavoriteMovies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//criado por arthur rodrigues

class FavoriteMoviesViewModel(
    val getFavoriteMoviesUseCase: GetFavoriteMovies,
    val favoriteOrDisfavorMovieUseCase: FavoriteOrDisfavorMovie) : ViewModel() {

    private val response = MutableLiveData<Response>()

    fun getFavoriteMovies(){
        response.postValue(Response.loading())
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val result = getFavoriteMoviesUseCase()
                response.postValue(Response.success(result))
            }
        }
        catch (t : Throwable){
            response.postValue(Response.error(t))
        }
    }

    fun favoriteOrDisfavorMovie(movie : Movie){
        CoroutineScope(Dispatchers.IO).launch {
            favoriteOrDisfavorMovieUseCase(movie)
        }
    }

    fun response(): MutableLiveData<Response> {
        return response
    }
}