package com.example.routes

import com.example.config.JWT_AUTH
import com.example.dto.LoginRequest
import com.example.dto.LoginResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.authRoutes() {
    routing {
        route("/auth") {
//            PUBLIC ROUTES
            post("/login") {
                val requestBody = call.receive<LoginRequest>()
                //TODO: login actually
                val response = LoginResponse("sampleJwt")
                call.respond(response)
            }


//            AUTHENTICATED ROUTES
            authenticate(JWT_AUTH) {
                get("/validate-token") {
                    //TODO: implement actual logic
                    call.respond(HttpStatusCode.OK)
                }
            }
        }
    }
}