package com.example.services.yacht

import com.example.dto.AllYachtsResponse
import com.example.dto.ReservationsResponse
import com.example.dto.YachtReservationRequest

interface YachtService {
    fun getAllYachts(): AllYachtsResponse
    fun makeReservation(userEmail: String, request: YachtReservationRequest)
    fun getAllReservations(userEmail: String): ReservationsResponse
}