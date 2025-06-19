package com.example.dto

import kotlinx.serialization.Serializable

@Serializable
data class UpdateProfileRequest(
    val name: String
)

@Serializable
data class ProfileResponse(
    val profile: Profile
)

@Serializable
data class Profile(
    val email: String,
    val name: String?
)