package com.example.challengeyourdev.data.data_sources

import com.example.challengeyourdev.data.models.ResultApiDataResponse


//criado por arthur rodrigues

interface MovieRemoteDataSource {

    suspend fun getAllMovies(page: Int): ResultApiDataResponse
}