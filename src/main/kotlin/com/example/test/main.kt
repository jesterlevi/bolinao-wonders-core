package com.example.test

import com.example.DatabaseFactory
import com.example.controller.PlaceController
import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.  ktor.server.routing.*

//fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)
fun main() {
    embeddedServer(Netty, port = 8080) {
        module()
    }.start(wait = true)
}

@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val placeController = PlaceController()
    fun initDB() {
       DatabaseFactory.connect()
    }
    install(ContentNegotiation) {
        gson {
          setPrettyPrinting()
        }
    }
    initDB()
    routing {
        get("/") {
            call.respondText("main base url!", contentType = ContentType.Text.Plain)
        }

        get("/places") {
            call.respond(placeController.getAll())
        }

    }
}