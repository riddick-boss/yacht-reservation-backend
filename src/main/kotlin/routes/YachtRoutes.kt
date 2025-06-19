package com.example.routes

import com.example.config.JWT_AUTH
import com.example.dto.YachtReservationRequest
import com.example.services.auth.JwtClaims
import com.example.services.yacht.YachtService
import com.example.utils.getPrincipalStringClaim
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.auth.authenticate
import io.ktor.server.request.receive
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

            authenticate(JWT_AUTH) {
                post("/reserve") {
                    val userEmail = call.getPrincipalStringClaim(JwtClaims.EMAIL)
                    val requestBody = call.receive<YachtReservationRequest>()
                    yachtService.makeReservation(userEmail, requestBody)
                    call.respond(HttpStatusCode.OK)
                }
                get("/reservations") {
                    val userEmail = call.getPrincipalStringClaim(JwtClaims.EMAIL)
                    val response =  yachtService.getAllReservations(userEmail)
                    call.respond(response)
                }
            }
        }
    }
}