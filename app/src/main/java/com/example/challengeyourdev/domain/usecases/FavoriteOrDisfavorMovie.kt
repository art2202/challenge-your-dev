package com.example.challengeyourdev.domain.usecases

import com.example.challengeyourdev.domain.entities.Movie
import com.example.challengeyourdev.domain.repositories.MovieRepository


//criado por arthur rodrigues

class FavoriteOrDisfavorMovie(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(movie : Movie){
        movieRepository.favoriteOrDisfavorMovie(movie)
    }
}