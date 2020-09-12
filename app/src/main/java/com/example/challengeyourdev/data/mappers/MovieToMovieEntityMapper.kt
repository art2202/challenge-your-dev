package com.example.challengeyourdev.data.mappers

import com.example.challengeyourdev.data.database.entity.MovieEntity
import com.example.challengeyourdev.domain.entities.Movie


//criado por arthur rodrigues

class MovieToMovieEntityMapper : Mapper<Movie, MovieEntity> {
    override fun map(input: Movie): MovieEntity = with(input){
        MovieEntity(
            null,
            movieTitle,
            criticAuthor,
            criticTitle,
            summaryShort,
            publicationDate,
            photo.photoUrl,
            photo.width,
            photo.height,
            link.criticUrl,
            link.suggestedText
        )
    }
}