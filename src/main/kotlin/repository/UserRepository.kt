package com.example.repository

import com.example.model.User

interface UserRepository {
    fun save(user: User)
    fun getByEmail(email: String): User?
}

class InMemoryUserRepository : UserRepository {
    private val usersList = mutableListOf<User>()

    override fun save(user: User) {
        if (userAlreadyExists(user)) throw IllegalArgumentException("User already exists!")

        usersList.add(user)
    }

    override fun getByEmail(email: String): User? {
        return usersList.firstOrNull { it.email == email }
    }

    private fun userAlreadyExists(user: User): Boolean {
        return getByEmail(user.email) != null
    }
}