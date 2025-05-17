package com.example.services.yacht.impl

import com.example.dto.AllYachtsResponse
import com.example.model.Yacht

class YachtMapper {
    fun toAllYachtsResponse(yachts: List<Yacht>): AllYachtsResponse {
        val dtoList = yachts.map { it.toDtoYacht() }
        return AllYachtsResponse(list = dtoList)
    }

    private fun Yacht.toDtoYacht(): AllYachtsResponse.Yacht = AllYachtsResponse.Yacht(
        id = id,
        name = name,
        manufacturer = manufacturer,
        length = length,
        crewNum = crewNum,
        price = price
    )
}