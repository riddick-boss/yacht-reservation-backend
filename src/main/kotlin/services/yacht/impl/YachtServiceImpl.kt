package com.example.services.yacht.impl

import com.example.dto.YachtsResponse
import com.example.dto.ReservationsResponse
import com.example.dto.YachtReservationRequest
import com.example.model.Reservation
import com.example.repository.ReservationRepository
import com.example.repository.UserRepository
import com.example.repository.YachtRepository
import com.example.services.yacht.YachtService
import kotlin.random.Random

class YachtServiceImpl(
    private val yachtRepository: YachtRepository,
    private val reservationRepository: ReservationRepository,
    private val userRepository: UserRepository,
    private val mapper: YachtMapper
) : YachtService {
    override fun getAllYachts(): YachtsResponse {
        val list = yachtRepository.getAll()
        return mapper.toYachtsResponse(list)
    }

    override fun getFeaturedYachts(): YachtsResponse {
        val list = yachtRepository.getAll().shuffled().take(3)
        return mapper.toYachtsResponse(list)
    }


    override fun makeReservation(userEmail: String, request: YachtReservationRequest) {
        val user = userRepository.getByEmail(userEmail) ?: throw IllegalArgumentException("User not found!")
        val yacht = yachtRepository.get(request.yachtId) ?: throw IllegalArgumentException("Yacht not found!")
        val reservation = Reservation(
            id = Random.nextInt(),
            userId = user.id,
            yachtId = yacht.id,
            startTime = request.startTime,
            endTime = request.endTime
        )
        reservationRepository.makeReservation(reservation)
    }

    override fun getAllReservations(userEmail: String): ReservationsResponse {
        val user = userRepository.getByEmail(userEmail) ?: throw IllegalArgumentException("User not found!")
        val reservations = reservationRepository.getAllReservations(user.id)
        val list = reservations.map {
            val yacht = yachtRepository.get(it.yachtId) ?: throw IllegalArgumentException("Yacht id not found!")
            mapper.toReservationDto(reservation = it, yacht = yacht)
        }
        return mapper.toReservationsResponse(list = list)
    }
}