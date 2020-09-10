package com.example.challengeyourdev.data.models


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
) 