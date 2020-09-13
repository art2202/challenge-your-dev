package com.example.challengeyourdev.data.data_sources

import com.example.challengeyourdev.data.database.entity.MovieEntity


//criado por arthur rodrigues

interface MovieLocalDataSource {

    suspend fun addAllMovies(movies : List<MovieEntity>)
    suspend fun addMovieFavorite(movie: MovieEntity)
    suspend fun getAllMovies(title: String) : List<MovieEntity>
    suspend fun getFavoriteMovies() : List<MovieEntity>?
    suspend fun getSearchMovies(title : String) : List<MovieEntity>?
}