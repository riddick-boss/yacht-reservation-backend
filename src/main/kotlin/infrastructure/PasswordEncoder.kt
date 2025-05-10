package com.example.infrastructure

import com.example.model.User

interface PasswordEncoder {
    fun isPasswordValid(user: User, password: String): Boolean
}