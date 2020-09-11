package com.example.challengeyourdev.data.database.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.challengeyourdev.data.database.entity.MovieEntity


//criado por arthur rodrigues

interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(movies : List<MovieEntity>)

    @Query("SELECT * FROM movie")
    fun getAllMovies() : List<MovieEntity>
}