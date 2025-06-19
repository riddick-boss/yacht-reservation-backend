package com.example.dto

import kotlinx.serialization.Serializable

@Serializable
data class YachtsResponse(
    val list: List<YachtDto>
)

@Serializable
data class YachtDto(
    val id: Int,
    val name: String,
    val manufacturer: String,
    val length: Double,
    val crewNum: Int,
    val pricePerDay: Int,
    val imageUrl: String,
    val isAvailable: Boolean
)

@Serializable
data class YachtReservationRequest(
    val yachtId: Int,
    val startTime: Int,
    val endTime: Int
)

@Serializable
data class ReservationsResponse(
    val list: List<ReservationDto>
)

@Serializable
data class ReservationDto(
    val id: Int,
    val yacht: YachtDto,
    val startTime: Int,
    val endTime: Int
)