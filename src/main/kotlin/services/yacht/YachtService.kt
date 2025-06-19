package com.example.services.yacht

import com.example.dto.YachtsResponse

interface YachtService {
    fun getAllYachts(): YachtsResponse
    fun getFeaturedYachts(): YachtsResponse
}