package com.example.infrastructure.impl

import com.example.infrastructure.PasswordEncoder
import com.example.model.User

class PasswordEncoderImpl : PasswordEncoder {
    // WARNING: in real-world production app password should be hashed
    override fun isPasswordValid(user: User, password: String): Boolean {
        return user.password == password
    }
}