package com.example.challengeyourdev.presentation.pages.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challengeyourdev.core.utils.Response
import com.example.challengeyourdev.domain.usecases.GetAllMovies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//criado por arthur rodrigues

class MoviesViewModel(
    val getAllMovies: GetAllMovies
) : ViewModel() {

    private val response = MutableLiveData<Response>()


    fun getMovies(){
        response.postValue(Response.loading())
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val result = getAllMovies()
                response.postValue(Response.success(result))
            }

        }
        catch (t : Throwable){
            response.postValue(Response.error(t))
        }

    }

    fun response(): MutableLiveData<Response> {
        return response
    }
}