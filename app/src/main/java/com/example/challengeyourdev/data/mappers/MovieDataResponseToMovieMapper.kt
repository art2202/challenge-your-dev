package com.example.challengeyourdev.data.mappers

import com.example.challengeyourdev.data.models.MovieDataResponse
import com.example.challengeyourdev.data.models.PhotoDataResponse
import com.example.challengeyourdev.domain.entities.Movie


//criado por arthur rodrigues

class MovieDataResponseToMovieMapper : Mapper<MovieDataResponse, Movie>{
    override fun map(input: MovieDataResponse): Movie = with(input) {
        Movie(
            display_title ?: "",
            byline ?: "",
            headline ?: "",
            summary_short ?: "",
            publication_date ?: "",
            link?.toEntity()!!,
            multimedia?.toEntity() ?: PhotoDataResponse(null, null, null, null).toEntity()
        )
    }
}