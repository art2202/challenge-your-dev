package com.example.challengeyourdev.data.data_sources

import com.example.challengeyourdev.BuildConfig
import com.example.challengeyourdev.core.exceptions.InvalidApiKeyThrowable
import com.example.challengeyourdev.core.exceptions.ResourceNotFoundThrowable
import com.example.challengeyourdev.data.api.ApiService
import com.example.challengeyourdev.data.models.ResultApiDataResponse


//criado por arthur rodrigues

class MovieRemoteDataSourceImpl(private val movieApi : ApiService) : MovieRemoteDataSource {
    override suspend fun getAllMovies(page: Int): ResultApiDataResponse {
        val response = movieApi.getAllMovies("reviews/search.json?offset=${page}&api-key=${BuildConfig.API_KEY}")
        when {
            response.isSuccessful -> {
                return response.body()!!
            }
            response.code() == 401 -> {
                throw InvalidApiKeyThrowable()
            }
            response.code() == 404 -> {
                throw ResourceNotFoundThrowable()
            }
            else -> throw Throwable()
        }
    }
}