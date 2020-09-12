package com.example.challengeyourdev.presentation.pages.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challengeyourdev.core.utils.Response
import com.example.challengeyourdev.domain.entities.Movie
import com.example.challengeyourdev.domain.usecases.FavoriteOrDisfavorMovie
import com.example.challengeyourdev.domain.usecases.GetAllMovies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//criado por arthur rodrigues

class MoviesViewModel(
    val getAllMoviesUseCase: GetAllMovies,
    val favoriteOrDisfavorMovieUseCase: FavoriteOrDisfavorMovie
) : ViewModel() {

    private val response = MutableLiveData<Response>()
    private var currentPage = 0


    fun getMovies(){
        response.postValue(Response.loading())
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val result = getAllMoviesUseCase(currentPage)
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

    fun loadMoreMovies(){
        currentPage += 20
        getMovies()
    }

    fun response(): MutableLiveData<Response> {
        return response
    }
}