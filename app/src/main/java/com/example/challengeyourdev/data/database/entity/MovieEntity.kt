package com.example.challengeyourdev.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


//criado por arthur rodrigues

@Entity(
    tableName = "movie",
    foreignKeys = [
    ForeignKey(
        entity = PhotoEntity::class,
        parentColumns = arrayOf("photo_url"),
        childColumns = arrayOf("photo_link")
    ),
    ForeignKey(
        entity = LinkEntity::class,
        parentColumns = arrayOf("critic_url"),
        childColumns = arrayOf("critic_link")
    )]
)
data class MovieEntity(

    @PrimaryKey(autoGenerate = true)
    val id : Int?,

    @ColumnInfo(name = "critic_author")
    val criticAuthor : String,

    @ColumnInfo(name = "critic_title")
    val criticTitle : String,

    @ColumnInfo(name = "summary_short")
    val summaryShort : String,

    @ColumnInfo(name = "publication_date")
    val publicationDate : String,

    @ColumnInfo(name = "photo_link", index = true)
    val photoUrl : String,

    @ColumnInfo(name = "critic_link", index = true)
    val criticLink : String

)