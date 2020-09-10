package com.example.challengeyourdev.data.api

import com.example.challengeyourdev.data.models.MovieDataResponse
import com.example.challengeyourdev.data.models.ResultApiDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url


//criado por arthur rodrigues

interface ApiService {

    @GET
    suspend fun getAllMovies(@Url url : String) : Response<ResultApiDataResponse>
}