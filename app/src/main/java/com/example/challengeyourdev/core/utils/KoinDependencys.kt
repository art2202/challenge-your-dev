package com.example.challengeyourdev.core.utils

import com.example.challengeyourdev.data.api.RestApi
import com.example.challengeyourdev.data.data_sources.MovieRepositoryImpl
import org.koin.dsl.module

//criado por arthur rodrigues

val modules = module {
    single { RestApi() }
    single { MovieRepositoryImpl() }
}

val viewModelModule = module {


}
