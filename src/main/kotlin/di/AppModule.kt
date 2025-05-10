package com.example.di

import com.example.repository.InMemoryUserRepository
import com.example.repository.UserRepository
import com.example.services.auth.AuthService
import com.example.services.auth.JwtService
import com.example.services.auth.impl.AuthServiceImpl
import com.example.services.auth.impl.JwtServiceImpl
import org.koin.dsl.module

val appModule = module {
    single<JwtService> { JwtServiceImpl() }
    single<AuthService> { AuthServiceImpl(get(), get()) }

    single<UserRepository> { InMemoryUserRepository() }
}