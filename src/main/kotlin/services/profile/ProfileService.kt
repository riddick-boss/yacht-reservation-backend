package com.example.services.profile

import com.example.dto.ProfileResponse
import com.example.dto.UpdateProfileRequest

interface ProfileService {
    fun updateProfile(email: String, request: UpdateProfileRequest): ProfileResponse
    fun getProfile(email: String): ProfileResponse
}