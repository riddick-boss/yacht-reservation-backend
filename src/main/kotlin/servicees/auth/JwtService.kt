package com.example.servicees.auth

import com.auth0.jwt.interfaces.JWTVerifier
import io.ktor.server.auth.jwt.JWTCredential
import io.ktor.server.auth.jwt.JWTPrincipal

interface JwtService {
    val jwtVerifier: JWTVerifier
    fun generateJwt(username: String): String
    fun validateJwt(jwtCredential: JWTCredential): JWTPrincipal?
}