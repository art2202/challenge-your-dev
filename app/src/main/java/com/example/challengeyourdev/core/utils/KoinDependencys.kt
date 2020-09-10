package com.example.challengeyourdev.core.utils

import com.example.challengeyourdev.data.api.RestApi
import com.example.challengeyourdev.data.repositories.MovieRepositoryImpl
import com.example.challengeyourdev.domain.repositories.MovieRepository
import com.example.challengeyourdev.domain.usecases.GetAllMovies
import org.koin.dsl.module

//criado por arthur rodrigues

val modules = module {
    single { RestApi() }
    single { MovieRepositoryImpl() }
    single { GetAllMovies(get()) }

    single<MovieRepository> { MovieRepositoryImpl() }
}

val viewModelModule = module {


}
