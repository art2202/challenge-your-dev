package com.example.challengeyourdev.data.database.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.challengeyourdev.data.database.entity.LinkEntity


//criado por arthur rodrigues

interface LinkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(linkDao : LinkEntity)
    
    @Query("SELECT * FROM link WHERE critic_url = :url")
    fun getOneLink(url : String) : LinkEntity
}