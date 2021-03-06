package com.example.challengeyourdev.data.models

import com.example.challengeyourdev.domain.entities.Link
import com.example.challengeyourdev.domain.entities.Movie
import com.example.challengeyourdev.domain.entities.Photo


//criado por arthur rodrigues

class MovieDataResponse(
    val display_title : String?,
    val mpaa_rating : String?,
    val critics_pick : Int?,
    val byline : String?,
    val headline : String?,
    val summary_short : String?,
    val publication_date : String?,
    val date_update : String?,
    val link : LinkDataResponse?,
    val multimedia : PhotoDataResponse?
){
    fun toEntity() : Movie {
        return Movie(
            display_title ?: "",
            byline ?: "",
            headline ?: "",
            summary_short ?: "",
            publication_date ?: "",
            link?.toEntity() ?: Link("", "", "") ,
            multimedia?.toEntity() ?: Photo("", "", 0, 0)
        )
    }
}