package com.example.challengeyourdev.data.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//criado por arthur rodrigues

object RestApi {

    private val retrofit : Retrofit
    fun getRetrofit() = retrofit

    init {
      retrofit = Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/movies/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }


}