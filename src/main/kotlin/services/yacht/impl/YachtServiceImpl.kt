package com.example.services.yacht.impl

import com.example.dto.YachtsLocationsResponse
import com.example.dto.YachtsResponse
import com.example.repository.YachtRepository
import com.example.services.yacht.YachtService

class YachtServiceImpl(
    private val yachtRepository: YachtRepository,
    private val mapper: YachtMapper
) : YachtService {
    override fun getAllYachts(): YachtsResponse {
        val list = yachtRepository.getAll()
        return mapper.toYachtsResponse(list)
    }

    override fun getFeaturedYachts(): YachtsResponse {
        val list = yachtRepository.getAll().shuffled().take(3)
        return mapper.toYachtsResponse(list)
    }

    override fun getLocations(): YachtsLocationsResponse {
        val list = yachtRepository.getAll()
        return mapper.toYachtsLocationResponse(list)
    }
}