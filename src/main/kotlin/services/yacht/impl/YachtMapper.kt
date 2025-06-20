package com.example.services.yacht.impl

import com.example.dto.YachtDto
import com.example.dto.YachtLocationDto
import com.example.dto.YachtsLocationsResponse
import com.example.dto.YachtsResponse
import com.example.model.Yacht

class YachtMapper {
    fun toYachtsResponse(yachts: List<Yacht>): YachtsResponse {
        val dtoList = yachts.map { it.toYachtDto() }
        return YachtsResponse(list = dtoList)
    }

    fun toYachtsLocationResponse(yachts: List<Yacht>): YachtsLocationsResponse {
        val dtoList = yachts.map { it.toYachtLocationDto() }
        return YachtsLocationsResponse(list = dtoList)
    }

    private fun Yacht.toYachtDto() = YachtDto(
        id = id,
        name = name,
        manufacturer = manufacturer,
        length = length,
        crewNum = crewNum,
        pricePerDay = pricePerDay,
        imageUrl = imageUrl,
        isAvailable = isAvailable
    )

    private fun Yacht.toYachtLocationDto() = YachtLocationDto(
        id = id,
        name = name,
        latitude = location.latitude,
        longitude = location.longitude
    )
}