package com.example.services.profile.impl

import com.example.dto.ProfileResponse
import com.example.dto.UpdateProfileRequest
import com.example.repository.UserRepository
import com.example.services.profile.ProfileService

class ProfileServiceImpl(
    private val userRepository: UserRepository,
    private val mapper: ProfileMapper
) : ProfileService {
    override fun updateProfile(
        email: String,
        request: UpdateProfileRequest
    ): ProfileResponse {
        val user = userRepository.getByEmail(email) ?: throw IllegalArgumentException("User not found!")
        val updatedUser = userRepository.update(
            id = user.id,
            name = request.name
        )
        return ProfileResponse(
            profile = mapper.toProfile(updatedUser)
        )
    }

    override fun getProfile(email: String): ProfileResponse {
        val user = userRepository.getByEmail(email) ?: throw IllegalArgumentException("User not found!")
        return ProfileResponse(
            profile = mapper.toProfile(user)
        )
    }
}