package com.example.challengeyourdev.presentation.pages.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challengeyourdev.core.utils.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//criado por balanike

class MoviesViewModel : ViewModel() {

    private val response = MutableLiveData<Response>()


    fun getMovies(){
        CoroutineScope(Dispatchers.IO).launch {

        }
    }

    fun response(): MutableLiveData<Response> {
        return response
    }
}