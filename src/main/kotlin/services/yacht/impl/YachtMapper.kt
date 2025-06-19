package com.example.services.yacht.impl

import com.example.dto.YachtsResponse
import com.example.dto.ReservationDto
import com.example.dto.ReservationsResponse
import com.example.dto.YachtDto
import com.example.model.Reservation
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