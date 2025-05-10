package com.example.services.auth.impl

import com.example.dto.RegisterRequest
import com.example.dto.RegisterResponse
import com.example.model.User
import com.example.repository.UserRepository
import com.example.services.auth.AuthService
import com.example.services.auth.JwtService

class AuthServiceImpl(
    private val userRepository: UserRepository,
    private val jwtService: JwtService
) : AuthService {
    override fun register(request: RegisterRequest): RegisterResponse {
        val user = User(
            email = request.email,
            password = request.password
        )
        userRepository.save(user)
        val jwt = jwtService.generateJwt(user.email)
        return RegisterResponse(jwtToken = jwt)
    }
}