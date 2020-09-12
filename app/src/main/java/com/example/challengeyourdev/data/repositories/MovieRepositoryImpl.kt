package com.example.challengeyourdev.data.repositories

import com.example.challengeyourdev.data.data_sources.MovieLocalDataSource
import com.example.challengeyourdev.data.data_sources.MovieRemoteDataSource
import com.example.challengeyourdev.data.mappers.MovieDataResponseToMovieMapper
import com.example.challengeyourdev.data.mappers.MovieEntityToMovieMapper
import com.example.challengeyourdev.data.mappers.MovieToMovieEntityMapper
import com.example.challengeyourdev.domain.entities.Movie
import com.example.challengeyourdev.domain.repositories.MovieRepository


//criado por arthur rodrigues

class MovieRepositoryImpl(
    private val remoteDataSource: MovieRemoteDataSource,
    private val localDataSource: MovieLocalDataSource,
    private val movieToMovieEntityMapper: MovieToMovieEntityMapper,
    private val movieEntityToMovieMapper: MovieEntityToMovieMapper,
    private val movieDataResponseToMovieMapper: MovieDataResponseToMovieMapper
) : MovieRepository {

    override suspend fun getAllMovies(page: Int): List<Movie> {
        val movieList = remoteDataSource.getAllMovies(page).results.map { movieDataResponseToMovieMapper.map(it) }
        movieList.size
        saveInDataBase(movieList)
        val a = localDataSource.getAllMovies().map { movieEntityToMovieMapper.map(it) }
        a.size
        return a
    }

    override suspend fun saveInDataBase(movies: List<Movie>) {
        localDataSource.addAllMovies(movies.map{movieToMovieEntityMapper.map(it)})
    }
}