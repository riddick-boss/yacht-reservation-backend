package com.example.routes

import com.example.config.JWT_AUTH
import com.example.dto.YachtBookingRequest
import com.example.services.auth.JwtClaims
import com.example.services.bookings.BookingsService
import com.example.utils.getPrincipalStringClaim
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.auth.authenticate
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject

fun Application.bookingRoutes() {
    val bookingService by inject<BookingsService>()
    routing {
        route("/bookings") {
            authenticate(JWT_AUTH) {
                post("/book") {
                    val userEmail = call.getPrincipalStringClaim(JwtClaims.EMAIL)
                    val requestBody = call.receive<YachtBookingRequest>()
                    bookingService.book(userEmail, requestBody)
                    call.respond(HttpStatusCode.OK)
                }
                delete("/{id}") {
                    val userEmail = call.getPrincipalStringClaim(JwtClaims.EMAIL)
                    val bookingId = call.parameters["id"]
                    bookingService.delete(userEmail, bookingId)
                    call.respond(HttpStatusCode.Accepted)
                }
                get("/upcoming") {
                    val userEmail = call.getPrincipalStringClaim(JwtClaims.EMAIL)
                    val response =  bookingService.getUpcomingBookings(userEmail)
                    call.respond(response)
                }
                get("/past") {
                    val userEmail = call.getPrincipalStringClaim(JwtClaims.EMAIL)
                    val response =  bookingService.getPastBookings(userEmail)
                    call.respond(response)
                }
            }
        }
    }
}