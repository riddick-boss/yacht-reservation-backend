package com.example.routes

import com.example.config.JWT_AUTH
import com.example.dto.LoginRequest
import com.example.dto.LoginResponse
import com.example.dto.RegisterRequest
import com.example.services.auth.AuthService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.authRoutes() {
    val authService by inject<AuthService>()
    routing {
        route("/auth") {
//            PUBLIC ROUTES
            post("/register") {
                val requestBody = call.receive<RegisterRequest>()
                val response = authService.register(requestBody)
                call.respond(response)
            }

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