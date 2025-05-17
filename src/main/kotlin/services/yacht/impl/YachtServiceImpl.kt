package com.example.services.yacht.impl

import com.example.dto.AllYachtsResponse
import com.example.repository.YachtRepository
import com.example.services.yacht.YachtService

class YachtServiceImpl(
    private val yachtRepository: YachtRepository,
    private val mapper: YachtMapper
) : YachtService {
    override fun getAllYachts(): AllYachtsResponse {
        val list = yachtRepository.getAll()
        return mapper.toAllYachtsResponse(list)
    }
}