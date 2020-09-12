package com.example.challengeyourdev.domain.entities

import java.io.Serializable


//criado por arthur rodrigues

class Photo(
    val type : String,
    val photoUrl : String,
    val width : Int,
    val height : Int
) : Serializable