package com.example.challengeyourdev.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


//criado por arthur rodrigues

@Entity(
    tableName = "movie"
)
data class MovieEntity(

    val id : Int?,

    @PrimaryKey
    @ColumnInfo(name = "movie_title")
    val movieTitle : String,

    @ColumnInfo(name = "critic_author")
    val criticAuthor : String,

    @ColumnInfo(name = "critic_title")
    val criticTitle : String,

    @ColumnInfo(name = "summary_short")
    val summaryShort : String,

    @ColumnInfo(name = "publication_date")
    val publicationDate : String,

    @ColumnInfo(name = "photo_link")
    val photoUrl : String,

    @ColumnInfo(name = "photo_width")
    val photoWidth : Int,

    @ColumnInfo(name = "photo_height")
    val photoHeight : Int,

    @ColumnInfo(name = "critic_link")
    val criticLink : String,

    @ColumnInfo(name = "suggested_text")
    val suggestedText : String,

    @ColumnInfo(name = "favorite")
    val isFavorite : Boolean
)