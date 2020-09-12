package com.example.challengeyourdev.domain.entities

import java.io.Serializable


//criado por arthur rodrigues

class Movie(
    val movieTitle : String,
    val criticAuthor : String,
    val criticTitle : String,
    val summaryShort : String,
    val publicationDate : String,
    val link : Link,
    val photo : Photo
) : Serializable{

    var isFavorite : Boolean = false
}