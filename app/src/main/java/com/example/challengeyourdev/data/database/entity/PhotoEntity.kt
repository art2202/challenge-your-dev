package com.example.challengeyourdev.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


//criado por arthur rodrigues

@Entity(
    tableName = "photo"
)
data class PhotoEntity(

    @PrimaryKey(autoGenerate = true)
    val id : Int?,

    val type : String,

    @ColumnInfo(name = "photo_url")
    val photoUrl : String,

    val width : Int,

    val height : Int
)