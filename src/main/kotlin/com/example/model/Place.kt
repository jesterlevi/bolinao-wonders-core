package com.example.model

data class Place(
    val id: Int,
    val title: String,
    val description: String,

)

data class PlaceDTO(
    val title: String,
    val description: String
)