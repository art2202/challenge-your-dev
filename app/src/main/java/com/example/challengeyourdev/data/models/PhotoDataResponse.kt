package com.example.challengeyourdev.data.models

import com.example.challengeyourdev.domain.entities.Photo


//criado por arthur rodrigues

class PhotoDataResponse(
    val type : String?,
    val src : String?,
    val width : Int?,
    val height : Int?
){

    fun toEntity(): Photo {
        return Photo(
            type ?: "",
            src ?: "",
            width ?: 0,
            height ?: 0
            )
    }
}