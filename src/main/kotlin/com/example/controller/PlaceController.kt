package com.example.controller

import com.example.model.Place
import com.example.repository.Places
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class PlaceController {
    fun getAll(): ArrayList<Place> {
        val places: ArrayList<Place> = arrayListOf()
        transaction {
            Places.selectAll().map {
                places.add(
                    Place(
                        id = it[Places.id],
                        title= it[Places.title],
                        description = it[Places.description],

                    )
                )
            }
        }
        return places
    }
}