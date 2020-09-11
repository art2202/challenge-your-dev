package com.example.challengeyourdev.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


//criado por arthur rodrigues

@Entity(
    tableName = "link"
)
data class LinkEntity(

    @PrimaryKey(autoGenerate = true)
    val id : Int?,

    val type : String,

    @ColumnInfo(name = "critic_url")
    val criticUrl : String,

    @ColumnInfo(name = "suggested_text")
    val suggestedText : String
)