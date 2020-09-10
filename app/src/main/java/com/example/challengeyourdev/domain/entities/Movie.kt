package com.example.challengeyourdev.domain.entities


//criado por arthur rodrigues

class Movie(
    val movieTitle : String,
    val criticAuthor : String,
    val criticTitle : String,
    val summaryShort : String,
    val publicationDate : String,
    val criticUrl : String,
    val photoUrl : String
){

    var isFavorite : Boolean = false
}