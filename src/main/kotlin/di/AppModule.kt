package com.example.di

import com.example.services.auth.JwtService
import com.example.services.auth.impl.JwtServiceImpl
import org.koin.dsl.module

val appModule = module {
    single<JwtService> { JwtServiceImpl() }
}