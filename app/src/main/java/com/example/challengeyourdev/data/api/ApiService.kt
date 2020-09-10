package com.example.challengeyourdev.data.api

import com.example.challengeyourdev.data.models.MovieDataResponse
import retrofit2.Response
import retrofit2.http.GET


//criado por arthur rodrigues

interface ApiService {

    @GET
    suspend fun getAllMovies() : Response<List<MovieDataResponse>>
}