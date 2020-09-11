package com.example.challengeyourdev.data.data_sources

import com.example.challengeyourdev.data.database.AppDatabase
import com.example.challengeyourdev.data.database.entity.MovieEntity
import com.example.challengeyourdev.domain.entities.Movie


//criado por arthur rodrigues

class MovieLocalDataSourceImpl : MovieLocalDataSource {

    private val movieDao = AppDatabase.getDatabase()!!.MovieDao()
    private val photoDao = AppDatabase.getDatabase()!!.photoDao()
    private val linkDao = AppDatabase.getDatabase()!!.linkDao()

    override suspend fun addAllMovies(movies: List<Movie>) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllMovies(): List<MovieEntity> {
        TODO("Not yet implemented")
    }
}