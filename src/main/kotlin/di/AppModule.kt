package com.example.di

import com.example.infrastructure.PasswordEncoder
import com.example.infrastructure.impl.PasswordEncoderImpl
import com.example.repository.InMemoryReservationRepository
import com.example.repository.InMemoryUserRepository
import com.example.repository.InMemoryYachtRepository
import com.example.repository.ReservationRepository
import com.example.repository.UserRepository
import com.example.repository.YachtRepository
import com.example.services.auth.AuthService
import com.example.services.auth.JwtService
import com.example.services.auth.impl.AuthServiceImpl
import com.example.services.auth.impl.JwtServiceImpl
import com.example.services.yacht.YachtService
import com.example.services.yacht.impl.YachtMapper
import com.example.services.yacht.impl.YachtServiceImpl
import org.koin.dsl.module

val appModule = module {
    single<JwtService> { JwtServiceImpl() }
    single<AuthService> { AuthServiceImpl(get(), get(), get()) }
    single<PasswordEncoder> { PasswordEncoderImpl() }
    single<YachtService> { YachtServiceImpl(get(), get(), get(), get()) }
    single<YachtMapper> { YachtMapper() }

    single<UserRepository> { InMemoryUserRepository() }
    single<YachtRepository> { InMemoryYachtRepository() }
    single<ReservationRepository> { InMemoryReservationRepository() }
}