package com.example.servicees.auth.impl

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.JWTVerifier
import com.example.servicees.auth.JwtClaims
import com.example.servicees.auth.JwtService
import io.ktor.server.auth.jwt.JWTCredential
import io.ktor.server.auth.jwt.JWTPrincipal
import java.util.Date

class JwtServiceImpl(
    private val expirationMillis: Long = ONE_WEEK,
    private val secret: String = System.getenv("JWT_SECRET")
) : JwtService {
    override val jwtVerifier: JWTVerifier by lazy {
        JWT
            .require(Algorithm.HMAC256(secret))
            .build()
    }

    override fun generateJwt(username: String): String {
        return JWT.create()
            .withClaim(JwtClaims.USERNAME, username)
            .withExpiresAt(Date(System.currentTimeMillis() + expirationMillis))
            .sign(Algorithm.HMAC256(secret))
    }

    override fun validateJwt(jwtCredential: JWTCredential): JWTPrincipal? {
        val now = Date(System.currentTimeMillis())
        val expiryDate = jwtCredential.expiresAt ?: return null
        val isBeforeExpiry = now.before(expiryDate)
        val username = jwtCredential.payload.getClaim(JwtClaims.USERNAME).asString()
        val isUsernameValid = !username.isNullOrBlank()
        return if (isBeforeExpiry && isUsernameValid) {
            JWTPrincipal(jwtCredential.payload)
        } else {
            null
        }
    }
}

private const val ONE_WEEK = 7 * 24 * 60 * 60 * 1000L