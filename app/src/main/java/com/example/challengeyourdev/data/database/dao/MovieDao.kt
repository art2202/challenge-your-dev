package com.example.challengeyourdev.data.database.dao

import androidx.room.*
import com.example.challengeyourdev.data.database.entity.MovieEntity


//criado por arthur rodrigues

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(movies : List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addOneMovie(movie : MovieEntity)

    @Query("SELECT * FROM movie")
    fun getAllMovies() : List<MovieEntity>

    @Query("SELECT * FROM movie WHERE critic_title LIKE :substring")
    fun getMovies(substring : String) : List<MovieEntity>

    @Query("SELECT * FROM movie WHERE favorite = 1")
    fun getFavoriteMovies() : List<MovieEntity>?
}