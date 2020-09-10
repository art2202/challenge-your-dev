package com.example.challengeyourdev.data.data_sources

import com.example.challengeyourdev.data.api.ApiService
import com.example.challengeyourdev.data.models.MovieDataResponse


//criado por arthur rodrigues

class MovieDataSourceImpl(private val movieApi : ApiService) : MovieRemoteDataSource {
    override suspend fun getAllMovies(): List<MovieDataResponse> {
        TODO("fazer o api service")
    }
}