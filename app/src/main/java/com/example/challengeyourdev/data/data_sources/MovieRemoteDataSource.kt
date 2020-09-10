package com.example.challengeyourdev.data.data_sources

import com.example.challengeyourdev.data.models.MovieDataResponse


//criado por arthur rodrigues

interface MovieRemoteDataSource {

    suspend fun getAllMovies() : List<MovieDataResponse>
}