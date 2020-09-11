package com.example.challengeyourdev.data.database.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.challengeyourdev.data.database.entity.PhotoEntity


//criado por arthur rodrigues

interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(photo : PhotoEntity)

    @Query("SELECT * FROM photo WHERE photo_url = :url")
    fun getOnePhoto(url : String) : PhotoEntity
}