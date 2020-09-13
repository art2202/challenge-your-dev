package com.example.challengeyourdev.data.data_sources

import com.example.challengeyourdev.data.database.AppDatabase
import com.example.challengeyourdev.data.database.entity.MovieEntity


//criado por arthur rodrigues

class MovieLocalDataSourceImpl() : MovieLocalDataSource {

    private val movieDao = AppDatabase.getDatabase()!!.movieDao()

    override suspend fun addAllMovies(movies: List<MovieEntity>) {
        movieDao.add(movies)
    }

    override suspend fun addMovieFavorite(movie: MovieEntity) {
        movieDao.addOneMovie(movie)
    }

    override suspend fun getAllMovies(title: String): List<MovieEntity> {
        if(title.isEmpty())
            return movieDao.getAllMovies()
        else
            return movieDao.getSearchMovies(title)
    }

    override suspend fun getFavoriteMovies(): List<MovieEntity>? {
        return movieDao.getFavoriteMovies()
    }

    override suspend fun getSearchMovies(title: String): List<MovieEntity>? {
        return movieDao.getSearchMovies(title)
    }

}