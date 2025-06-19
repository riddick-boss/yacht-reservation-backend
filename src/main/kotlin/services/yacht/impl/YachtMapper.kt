package com.example.services.yacht.impl

import com.example.dto.YachtDto
import com.example.dto.YachtsResponse
import com.example.model.Yacht

class YachtMapper {
    fun toYachtsResponse(yachts: List<Yacht>): YachtsResponse {
        val dtoList = yachts.map { it.toYachtDto() }
        return YachtsResponse(list = dtoList)
    }

    private fun Yacht.toYachtDto(): YachtDto = YachtDto(
        id = id,
        name = name,
        manufacturer = manufacturer,
        length = length,
        crewNum = crewNum,
        pricePerDay = pricePerDay,
        imageUrl = imageUrl,
        isAvailable = isAvailable
    )
}