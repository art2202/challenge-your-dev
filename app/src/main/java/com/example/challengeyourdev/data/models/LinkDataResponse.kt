package com.example.challengeyourdev.data.models

import com.example.challengeyourdev.domain.entities.Link


//criado por arthur rodrigues

class LinkDataResponse(
    val type : String?,
    val url : String?,
    val suggested_link_text : String?
){

    fun toEntity() : Link {
        return Link(
            type ?: "",
            url ?: "",
            suggested_link_text ?: ""
        )
    }
}