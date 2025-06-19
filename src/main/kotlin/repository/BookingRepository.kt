package com.example.repository

import com.example.model.Booking
import java.time.LocalDate

interface BookingRepository {
    fun add(booking: Booking)
    fun delete(userId: Int, id: Int)
    fun getUpcomingReservations(userId: Int): List<Booking>
    fun getPastReservations(userId: Int): List<Booking>
}

class InMemoryReservationRepository : BookingRepository {
    private val bookings = mutableListOf<Booking>()

    override fun add(booking: Booking) {
        bookings.add(booking)
    }

    override fun delete(userId: Int, id: Int) {
        bookings.removeIf { it.id == id && it.userId == userId }
    }

    override fun getUpcomingReservations(userId: Int): List<Booking> {
        return userBookings(userId).filter { it.day.isAfter(LocalDate.now()) || it.day == LocalDate.now() }
    }

    override fun getPastReservations(userId: Int): List<Booking> {
        return userBookings(userId).filter { it.day.isBefore(LocalDate.now()) }
    }

    private fun userBookings(userId: Int) = bookings.filter { it.userId == userId }
}