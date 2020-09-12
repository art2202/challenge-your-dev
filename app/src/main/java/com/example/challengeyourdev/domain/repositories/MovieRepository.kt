package com.example.challengeyourdev.domain.repositories

import com.example.challengeyourdev.domain.entities.Movie


//criado por arthur rodrigues

interface MovieRepository {

    suspend fun getAllMovies(page: Int): List<Movie>

    suspend fun saveInDataBase(movies : List<Movie>)

}