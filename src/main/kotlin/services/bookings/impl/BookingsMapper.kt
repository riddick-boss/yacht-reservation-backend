package com.example.services.bookings.impl

import com.example.dto.BookingDto
import com.example.dto.BookingLocationDto
import com.example.dto.BookingsResponse
import com.example.dto.YachtBookingDto
import com.example.model.Booking
import com.example.model.Location
import com.example.model.Yacht

class BookingsMapper {
    fun toBookingDto(booking: Booking, yacht: Yacht, location: Location) = BookingDto(
        id = booking.id,
        yacht = YachtBookingDto(
            name = yacht.name
        ),
        day = booking.day.toString(),
        location = BookingLocationDto(
            name = location.name,
            imageUrl = location.imageUrl
        )
    )

    fun toBookingsResponse(list: List<BookingDto>) = BookingsResponse(list = list)
}