package com.example.challengeyourdev.domain.usecases

import com.example.challengeyourdev.domain.entities.Movie
import com.example.challengeyourdev.domain.repositories.MovieRepository


//criado por arthur rodrigues

class GetFavoriteMovies(private val movieRepository: MovieRepository) {
    
    suspend operator fun invoke() : List<Movie> = movieRepository.getFavoriteMovies()
}