package com.example.challengeyourdev.data.repositories

import com.example.challengeyourdev.core.App
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

    override suspend fun getAllMovies(title: String,page: Int): List<Movie> {
        try {
            if (App.temInternet) {
                val movieList = remoteDataSource.getAllMovies(title, page).results.map {
                    movieDataResponseToMovieMapper.map(it)
                }
                saveInDataBase(movieList)
            }
        }
        catch (e : Exception){}
        return localDataSource.getAllMovies(title).map { movieEntityToMovieMapper.map(it) }
    }

    override suspend fun saveInDataBase(movies: List<Movie>) {
        localDataSource.addAllMovies(movies.map{movieToMovieEntityMapper.map(it)})
    }

    override suspend fun getFavoriteMovies(): List<Movie> {
        return localDataSource.getFavoriteMovies()?.map { movieEntityToMovieMapper.map(it) } ?: listOf()
    }

    override suspend fun favoriteOrDisfavorMovie(movie: Movie) {
        val favoriteMovies = (localDataSource.getFavoriteMovies()?.map{
            movieEntityToMovieMapper.map(it)} ?: arrayListOf()) as ArrayList<Movie>

        if(favoriteMovies.find { movie.movieTitle == it.movieTitle } == null){
            movie.isFavorite = true
            localDataSource.addMovieFavorite(movieToMovieEntityMapper.map(movie))
        }
        else {
            movie.isFavorite = false
            localDataSource.addMovieFavorite(movieToMovieEntityMapper.map(movie))
        }
    }

}