package com.example.routes

import com.example.services.yacht.YachtService
import io.ktor.server.application.*
import io.ktor.server.response.respond
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.yachtRoutes() {
    val yachtService by inject<YachtService>()
    routing {
        route("/yachts") {
            get("/all") {
                val response = yachtService.getAllYachts()
                call.respond(response)
            }
        }
    }
}