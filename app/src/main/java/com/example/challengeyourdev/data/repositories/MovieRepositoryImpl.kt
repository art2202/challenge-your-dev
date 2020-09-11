package com.example.challengeyourdev.data.repositories

import com.example.challengeyourdev.data.data_sources.MovieRemoteDataSource
import com.example.challengeyourdev.domain.entities.Movie
import com.example.challengeyourdev.domain.repositories.MovieRepository


//criado por arthur rodrigues

class MovieRepositoryImpl(private val remoteDataSource: MovieRemoteDataSource) : MovieRepository {

    override suspend fun getAllMovies(page: Int): List<Movie> {
        val movieList = remoteDataSource.getAllMovies(page).results.map { it.toEntity() }

        return movieList

    }
}