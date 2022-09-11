package com.example.repository

import org.jetbrains.exposed.sql.Table

object Places: Table("\"public\".\"Places\"") {
    val id = integer("id").autoIncrement()
    val title = text("title")
    val description = text("description")

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}