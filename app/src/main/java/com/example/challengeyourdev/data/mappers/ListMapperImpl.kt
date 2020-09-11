package com.example.challengeyourdev.data.mappers


//criado por arthur rodrigues

class ListMapperImpl<I, O>(private val mapper : Mapper<I, O>) : ListMapper<I, O> {
    override fun map(input: List<I>): List<O> {
        return input.map { mapper.map(it) }
    }
}