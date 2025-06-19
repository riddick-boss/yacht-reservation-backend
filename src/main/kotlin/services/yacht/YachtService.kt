package com.example.services.yacht

import com.example.dto.YachtsResponse
import com.example.dto.ReservationsResponse
import com.example.dto.YachtReservationRequest

interface YachtService {
    fun getAllYachts(): YachtsResponse
    fun getFeaturedYachts(): YachtsResponse
    fun makeReservation(userEmail: String, request: YachtReservationRequest)
    fun getAllReservations(userEmail: String): ReservationsResponse
}