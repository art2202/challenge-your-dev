package com.example.challengeyourdev.domain.entities


//criado por arthur rodrigues

class Movie(
    val movieTitle : String,
    val criticAuthor : String,
    val criticTitle : String,
    val summaryShort : String,
    val publicationDate : String,
    val link : Link,
    val photo : Photo
){

    var isFavorite : Boolean = false
}