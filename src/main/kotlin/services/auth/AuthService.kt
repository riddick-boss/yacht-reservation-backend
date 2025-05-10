package com.example.services.auth

import com.example.dto.RegisterRequest
import com.example.dto.RegisterResponse

interface AuthService {
    fun register(request: RegisterRequest): RegisterResponse
}