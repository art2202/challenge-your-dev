package com.example.challengeyourdev.data.mappers

import com.example.challengeyourdev.data.database.entity.MovieEntity
import com.example.challengeyourdev.domain.entities.Link
import com.example.challengeyourdev.domain.entities.Movie
import com.example.challengeyourdev.domain.entities.Photo


//criado por arthur rodrigues

class MovieEntityToMovieMapper : Mapper<MovieEntity, Movie> {
    override fun map(input: MovieEntity): Movie = with(input){
        Movie(
            movieTitle,
            criticAuthor,
            criticTitle,
            summaryShort,
            publicationDate,
            Link("", criticLink, suggestedText),
            Photo("", photoUrl, photoWidth, photoHeight)
        ).apply { isFavorite = input.isFavorite }
    }
}