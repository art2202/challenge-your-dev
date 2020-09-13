package com.example.challengeyourdev.domain.repositories

import com.example.challengeyourdev.domain.entities.Movie


//criado por arthur rodrigues

interface MovieRepository {

    suspend fun getAllMovies(title: String,page: Int): List<Movie>
    suspend fun saveInDataBase(movies : List<Movie>)
    suspend fun getFavoriteMovies() : List<Movie>
    suspend fun favoriteOrDisfavorMovie(movie: Movie)
    suspend fun getSearchMovies(title : String, page: Int) : List<Movie>

}