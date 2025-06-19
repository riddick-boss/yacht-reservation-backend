package com.example.services.bookings.impl

import com.example.dto.BookingsResponse
import com.example.dto.YachtBookingRequest
import com.example.model.Booking
import com.example.repository.BookingRepository
import com.example.repository.LocationRepository
import com.example.repository.UserRepository
import com.example.repository.YachtRepository
import com.example.services.bookings.BookingsService
import java.time.LocalDate
import kotlin.random.Random

class BookingsServiceImpl(
    private val userRepository: UserRepository,
    private val bookingRepository: BookingRepository,
    private val locationRepository: LocationRepository,
    private val yachtRepository: YachtRepository,
    private val mapper: BookingsMapper
) : BookingsService {
    override fun book(email: String, request: YachtBookingRequest) {
        val user = userRepository.getByEmail(email) ?: throw IllegalArgumentException("User not found!")
        val yacht = yachtRepository.get(request.yachtId) ?: throw IllegalArgumentException("Yacht not found!")
        val day = LocalDate.parse(request.day)
        val booking = Booking(
            id = Random.nextInt(Int.MAX_VALUE),
            userId = user.id,
            yachtId = yacht.id,
            day = day,
            locationId = Random.nextInt(locationRepository.size())
        )
        bookingRepository.add(booking)
    }

    override fun delete(email: String, id: String?) {
        val user = userRepository.getByEmail(email) ?: throw IllegalArgumentException("User not found!")
        val intId = id?.toIntOrNull() ?: throw IllegalArgumentException("Invalid booking id!")
        bookingRepository.delete(user.id, intId)
    }

    override fun getUpcomingBookings(email: String): BookingsResponse {
        val user = userRepository.getByEmail(email) ?: throw IllegalArgumentException("User not found!")
        val list = bookingRepository.getUpcomingReservations(user.id).map {
            val yacht = yachtRepository.get(it.yachtId)!!
            val location = locationRepository.get(it.locationId)!!
            mapper.toBookingDto(it, yacht, location)
        }
        return mapper.toBookingsResponse(list)
    }

    override fun getPastBookings(email: String): BookingsResponse {
        val user = userRepository.getByEmail(email) ?: throw IllegalArgumentException("User not found!")
        val list = bookingRepository.getPastReservations(user.id).map {
            val yacht = yachtRepository.get(it.yachtId)!!
            val location = locationRepository.get(it.locationId)!!
            mapper.toBookingDto(it, yacht, location)
        }
        return mapper.toBookingsResponse(list)
    }
}