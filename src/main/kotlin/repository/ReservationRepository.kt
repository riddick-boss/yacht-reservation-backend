package com.example.repository

import com.example.model.Reservation

interface ReservationRepository {
    fun makeReservation(reservation: Reservation)
    fun getAllReservations(userId: Int): List<Reservation>
}

class InMemoryReservationRepository : ReservationRepository {
    private val reservations = mutableListOf<Reservation>()

    override fun makeReservation(reservation: Reservation) {
        reservations.add(reservation)
    }

    override fun getAllReservations(userId: Int): List<Reservation> {
        return reservations.filter { it.userId == userId }
    }
}