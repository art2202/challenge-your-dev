package com.example.challengeyourdev.data.data_sources

import com.example.challengeyourdev.data.models.ResultApiDataResponse


//criado por arthur rodrigues

interface MovieRemoteDataSource {

    suspend fun getAllMovies(title: String, page: Int): ResultApiDataResponse
    suspend fun getSearchMovies(title : String, page : Int) : ResultApiDataResponse
}