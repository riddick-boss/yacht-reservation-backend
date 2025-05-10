package com.example.repository

import com.example.model.User

interface UserRepository {
    fun save(user: User)
}

class InMemoryUerRepository : UserRepository {
    private val usersList = mutableListOf<User>()

    override fun save(user: User) {
        if (userAlreadyExists(user)) throw IllegalArgumentException("User already exists!")

        usersList.add(user)
    }

    private fun getByEmail(email: String): User? {
        return usersList.firstOrNull { it.email == email }
    }

    private fun userAlreadyExists(user: User): Boolean {
        return getByEmail(user.email) != null
    }
}