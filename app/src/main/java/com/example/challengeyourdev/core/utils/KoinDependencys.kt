package com.example.challengeyourdev.core.utils

import com.example.challengeyourdev.data.api.RestApi
import org.koin.dsl.module

//criado por arthur rodrigues

val modules = module {
    single { RestApi() }
}

val viewModelModule = module {


}
