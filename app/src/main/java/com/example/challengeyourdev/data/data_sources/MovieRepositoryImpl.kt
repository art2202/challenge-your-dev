package com.example.challengeyourdev.data.data_sources

import com.example.challengeyourdev.domain.entities.Movie
import com.example.challengeyourdev.domain.repositories.MovieRepository


//criado por arthur rodrigues

class MovieRepositoryImpl : MovieRepository {
    override suspend fun getAllMovies(): List<Movie> {
        TODO("Not yet implemented")
    }
}