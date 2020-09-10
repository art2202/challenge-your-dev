package com.example.challengeyourdev.core.utils

import com.example.challengeyourdev.data.api.ApiService
import com.example.challengeyourdev.data.api.RestApi
import com.example.challengeyourdev.data.data_sources.MovieRemoteDataSourceImpl
import com.example.challengeyourdev.data.data_sources.MovieRemoteDataSource
import com.example.challengeyourdev.data.repositories.MovieRepositoryImpl
import com.example.challengeyourdev.domain.repositories.MovieRepository
import com.example.challengeyourdev.domain.usecases.GetAllMovies
import com.example.challengeyourdev.presentation.pages.movies.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

//criado por arthur rodrigues

val modules = module {


    single<ApiService> {  RestApi.getRetrofit().create(ApiService::class.java) }

    single { MovieRepositoryImpl(get()) }
    single { GetAllMovies(get()) }
    single<MovieRemoteDataSource> { MovieRemoteDataSourceImpl(get()) }
    single<MovieRepository> { MovieRepositoryImpl(get()) }
}

val viewModelModule = module {

    viewModel { MoviesViewModel(get()) }

}
