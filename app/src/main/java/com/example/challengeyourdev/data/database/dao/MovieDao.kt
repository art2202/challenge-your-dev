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

    @Query("SELECT * FROM movie WHERE favorite = 1")
    fun getFavoriteMovies() : List<MovieEntity>?

    @Query("SELECT * FROM movie WHERE movie_title LIKE '%' || :title || '%'")
    suspend  fun getSearchMovies(title : String) : List<MovieEntity>
}