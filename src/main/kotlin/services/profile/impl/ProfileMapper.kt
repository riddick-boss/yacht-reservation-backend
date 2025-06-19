package com.example.services.profile.impl

import com.example.dto.Profile
import com.example.model.User

class ProfileMapper {
    fun toProfile(user: User): Profile = Profile(
        email = user.email,
        name = user.name
    )
}