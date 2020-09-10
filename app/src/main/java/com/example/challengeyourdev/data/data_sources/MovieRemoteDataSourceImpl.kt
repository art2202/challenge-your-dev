package com.example.challengeyourdev.data.data_sources

import com.example.challengeyourdev.BuildConfig
import com.example.challengeyourdev.data.api.ApiService
import com.example.challengeyourdev.data.models.MovieDataResponse
import com.example.challengeyourdev.data.models.ResultApiDataResponse


//criado por arthur rodrigues

class MovieRemoteDataSourceImpl(private val movieApi : ApiService) : MovieRemoteDataSource {
    override suspend fun getAllMovies(): ResultApiDataResponse {
        val response = movieApi.getAllMovies("reviews/search.json?api-key=${BuildConfig.API_KEY}")
        if (response.isSuccessful){
            return response.body()!!
        }
        else
            throw Exception("erro na requisição")
    }
}