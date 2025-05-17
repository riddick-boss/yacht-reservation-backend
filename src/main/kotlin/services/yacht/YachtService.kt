package com.example.services.yacht

import com.example.dto.AllYachtsResponse

interface YachtService {
    fun getAllYachts(): AllYachtsResponse
}