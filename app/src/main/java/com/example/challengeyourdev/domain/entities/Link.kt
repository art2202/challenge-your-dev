package com.example.challengeyourdev.domain.entities

import java.io.Serializable


//criado por arthur rodrigues

class Link(
    val type : String,
    val criticUrl : String,
    val suggestedText : String
) : Serializable