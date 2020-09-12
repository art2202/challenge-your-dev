package com.example.challengeyourdev.data.data_sources

import com.example.challengeyourdev.data.database.entity.MovieEntity
import com.example.challengeyourdev.domain.entities.Movie


//criado por arthur rodrigues

interface MovieLocalDataSource {

    suspend fun addAllMovies(movies : List<MovieEntity>)
    suspend fun getAllMovies() : List<MovieEntity>
}