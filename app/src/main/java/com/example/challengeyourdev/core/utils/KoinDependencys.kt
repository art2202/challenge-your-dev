package com.example.challengeyourdev.core.utils

import com.example.challengeyourdev.data.api.ApiService
import com.example.challengeyourdev.data.api.RestApi
import com.example.challengeyourdev.data.data_sources.MovieLocalDataSource
import com.example.challengeyourdev.data.data_sources.MovieLocalDataSourceImpl
import com.example.challengeyourdev.data.data_sources.MovieRemoteDataSourceImpl
import com.example.challengeyourdev.data.data_sources.MovieRemoteDataSource
import com.example.challengeyourdev.data.mappers.MovieDataResponseToMovieMapper
import com.example.challengeyourdev.data.mappers.MovieEntityToMovieMapper
import com.example.challengeyourdev.data.mappers.MovieToMovieEntityMapper
import com.example.challengeyourdev.data.repositories.MovieRepositoryImpl
import com.example.challengeyourdev.domain.repositories.MovieRepository
import com.example.challengeyourdev.domain.usecases.GetAllMovies
import com.example.challengeyourdev.presentation.pages.movies.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

//criado por arthur rodrigues

val modules = module {


    single<ApiService> {  RestApi.getRetrofit().create(ApiService::class.java) }

    single {MovieDataResponseToMovieMapper()}
    single {MovieEntityToMovieMapper()}
    single {MovieToMovieEntityMapper()}
//    single { MovieRepositoryImpl(get(), get(), get(), get(), get()) }
    single { GetAllMovies(get()) }
    single<MovieLocalDataSource> { MovieLocalDataSourceImpl()}
    single<MovieRemoteDataSource> { MovieRemoteDataSourceImpl(get()) }
    single<MovieRepository> { MovieRepositoryImpl(get(), get(), get(), get(), get()) }
}

val viewModelModule = module {

    viewModel { MoviesViewModel(get()) }

}
