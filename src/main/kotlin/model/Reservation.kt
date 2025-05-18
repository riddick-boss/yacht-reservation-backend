package com.example.model

data class Reservation(
    val id: Int,
    val userId: Int,
    val yachtId: Int,
    val startTime: Int,
    val endTime: Int
)
