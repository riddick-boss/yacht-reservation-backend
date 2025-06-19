package com.example.services.bookings

import com.example.dto.BookingsResponse
import com.example.dto.YachtBookingRequest

interface BookingsService {
    fun book(email: String, request: YachtBookingRequest)
    fun delete(email: String, id: String?)
    fun getUpcomingBookings(email: String): BookingsResponse
    fun getPastBookings(email: String): BookingsResponse
}