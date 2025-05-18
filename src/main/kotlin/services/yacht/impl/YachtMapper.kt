package com.example.services.yacht.impl

import com.example.dto.AllYachtsResponse
import com.example.dto.ReservationDto
import com.example.dto.ReservationsResponse
import com.example.dto.YachtDto
import com.example.model.Reservation
import com.example.model.Yacht

class YachtMapper {
    fun toAllYachtsResponse(yachts: List<Yacht>): AllYachtsResponse {
        val dtoList = yachts.map { it.toYachtDto() }
        return AllYachtsResponse(list = dtoList)
    }

    private fun Yacht.toYachtDto(): YachtDto = YachtDto(
        id = id,
        name = name,
        manufacturer = manufacturer,
        length = length,
        crewNum = crewNum,
        price = price
    )

    fun toReservationDto(reservation: Reservation, yacht: Yacht): ReservationDto {
        return ReservationDto(
            id = reservation.id,
            yacht = yacht.toYachtDto(),
            startTime = reservation.startTime,
            endTime = reservation.endTime
        )
    }

    fun toReservationsResponse(list: List<ReservationDto>): ReservationsResponse = ReservationsResponse(
        list = list
    )
}