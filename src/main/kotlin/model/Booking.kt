package com.example.model

import java.time.LocalDate

data class Booking(
    val id: Int,
    val userId: Int,
    val yachtId: Int,
    val day: LocalDate,
    val locationId: Int
)
