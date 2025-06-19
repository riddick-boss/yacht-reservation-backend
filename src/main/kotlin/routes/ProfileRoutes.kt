package com.example.routes

import com.example.config.JWT_AUTH
import com.example.dto.UpdateProfileRequest
import com.example.services.auth.JwtClaims
import com.example.services.profile.ProfileService
import com.example.utils.getPrincipalStringClaim
import io.ktor.server.application.Application
import io.ktor.server.auth.authenticate
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject

fun Application.profileRoutes() {
    val profileService by inject<ProfileService>()
    routing {
        route("/profile") {
            authenticate(JWT_AUTH) {
                post {
                    val email = call.getPrincipalStringClaim(JwtClaims.EMAIL)
                    val requestBody = call.receive<UpdateProfileRequest>()
                    val response = profileService.updateProfile(email, requestBody)
                    call.respond(response)
                }

                get {
                    val email = call.getPrincipalStringClaim(JwtClaims.EMAIL)
                    val response = profileService.getProfile(email)
                    call.respond(response)
                }
            }
        }
    }
}