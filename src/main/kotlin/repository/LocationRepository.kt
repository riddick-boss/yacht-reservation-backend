package com.example.repository

import com.example.model.Location

interface LocationRepository {
    fun size(): Int
    fun get(id: Int): Location?
}

class InMemoryLocationRepository : LocationRepository {
    private val locations = mutableListOf<Location>()

    override fun size(): Int = locations.size

    override fun get(id: Int): Location? = locations.firstOrNull { it.id == id }

    init {
        locations.addAll(sampleLocations)
    }
}

private val sampleLocations = listOf(
    Location(
        id = 1,
        name = "Marina di Portofino",
        imageUrl = "https://images.unsplash.com/photo-1577600867469-30cc013db252?w=800&h=600&fit=crop"
    ),
    Location(
        id = 2,
        name = "Monaco Yacht Club",
        imageUrl = "https://images.unsplash.com/photo-1594453987501-8ae427f3243b?w=800&h=600&fit=crop"
    ),
    Location(
        id = 3,
        name = "Ibiza Marina",
        imageUrl = "https://plus.unsplash.com/premium_photo-1733342595937-0237a53d922f?w=800&h=600&fit=crop"
    ),
    Location(
        id = 4,
        name = "Dubai Marina",
        imageUrl = "https://plus.unsplash.com/premium_photo-1661963885635-2b428cedce28?w=800&h=600&fit=crop"
    ),
    Location(
        id = 5,
        name = "Miami Beach Marina",
        imageUrl = "https://plus.unsplash.com/premium_photo-1697730215093-baeae8060bfe?w=800&h=600&fit=crop"
    ),
    Location(
        id = 6,
        name = "Saint-Tropez Marina",
        imageUrl = "https://images.unsplash.com/photo-1627669867775-fce0b561dad4?w=800&h=600&fit=crop"
    )
)