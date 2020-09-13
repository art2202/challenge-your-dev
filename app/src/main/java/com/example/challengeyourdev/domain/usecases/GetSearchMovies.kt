package com.example.challengeyourdev.domain.usecases

import com.example.challengeyourdev.domain.repositories.MovieRepository


//criado por arthur rodrigues

class GetSearchMovies(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(title : String, page : Int) = movieRepository.getSearchMovies(title, page)
}