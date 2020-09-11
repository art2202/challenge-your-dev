package com.example.challengeyourdev.data.mappers


//criado por arthur rodrigues

interface Mapper<I, O> {

    fun map(input : I) : O
}