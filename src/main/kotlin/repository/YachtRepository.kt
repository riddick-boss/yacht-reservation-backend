package com.example.repository

import com.example.model.Yacht

interface YachtRepository {
    fun getAll(): List<Yacht>
    fun get(yachtId: Int): Yacht?
}

class InMemoryYachtRepository : YachtRepository {
    private val yachtsList = mutableListOf<Yacht>()

    override fun getAll(): List<Yacht> {
        return yachtsList
    }

    override fun get(yachtId: Int): Yacht? = yachtsList.firstOrNull { it.id == yachtId }

    init {
        yachtsList.addAll(sampleYachts)
    }
}

private val sampleYachts = listOf(
    Yacht(
        id = 1,
        name = "Azure Horizon",
        manufacturer = "Sunseeker",
        length = 15.4,
        crewNum = 6,
        pricePerDay = 250,
        imageUrl = "https://images.unsplash.com/photo-1569263979104-865ab7cd8d13??w=800&h=600&fit=crop",
        isAvailable = true
    ),
    Yacht(
        id = 2,
        name = "Ocean Majesty",
        manufacturer = "Azimut",
        length = 19.0,
        crewNum = 8,
        pricePerDay = 320,
        imageUrl = "https://plus.unsplash.com/premium_photo-1680831748191-d726a2f7b201?w=800&h=600&fit=crop",
        isAvailable = true
    ),
    Yacht(
        id = 3,
        name = "Royal Escape",
        manufacturer = "Princess",
        length = 17.3,
        crewNum = 5,
        pricePerDay = 1800,
        imageUrl = "https://images.unsplash.com/photo-1717168689326-36fa63a3b177?w=800&h=600&fit=crop",
        isAvailable = true
    ),
    Yacht(
        id = 4,
        name = "Pacific Dream",
        manufacturer = "Ferretti",
        length = 8.0,
        crewNum = 7,
        pricePerDay = 2800,
        imageUrl = "https://images.unsplash.com/photo-1562281302-809108fd533c?w=800&h=600&fit=crop",
        isAvailable = true
    ),
    Yacht(
        id = 5,
        name = "Mediterranean Star",
        manufacturer = "Sanlorenzo",
        length = 9.0,
        crewNum = 7,
        pricePerDay = 35000,
        imageUrl = "https://images.unsplash.com/photo-1567899378494-47b22a2ae96a?w=800&h=600&fit=crop",
        isAvailable = true
    ),
    Yacht(
        id = 6,
        name = "Caribbean Breeze",
        manufacturer = "Beneteau",
        length = 25.2,
        crewNum = 5,
        pricePerDay = 220,
        imageUrl = "https://images.unsplash.com/photo-1597154200389-d7ac4c75e180?w=800&h=600&fit=crop",
        isAvailable = true
    ),
    Yacht(
        id = 7,
        name = "Nordic Explorer",
        manufacturer = "Lürssen",
        length = 16.0,
        crewNum = 6,
        pricePerDay = 420,
        imageUrl = "https://images.unsplash.com/photo-1567197399185-baf2309074fb?w=800&h=600&fit=crop",
        isAvailable = true
    ),
    Yacht(
        id = 8,
        name = "Aegean Spirit",
        manufacturer = "Riva",
        length = 21.0,
        crewNum = 7,
        pricePerDay = 3800,
        imageUrl = "https://plus.unsplash.com/premium_photo-1680831748248-47616728ee9f?w=800&h=600&fit=crop",
        isAvailable = true
    ),
    Yacht(
        id = 9,
        name = "Atlantic Voyager",
        manufacturer = "Heesen",
        length = 13.7,
        crewNum = 8,
        pricePerDay = 450,
        imageUrl = "https://images.unsplash.com/photo-1730196589663-950396d022b4?w=800&h=600&fit=crop",
        isAvailable = true
    ),
    Yacht(
        id = 10,
        name = "Pacific Pearl",
        manufacturer = "Amels",
        length = 8.7,
        crewNum = 7,
        pricePerDay = 400,
        imageUrl = "https://images.unsplash.com/photo-1695921418603-dad249201682?w=800&h=600&fit=crop",
        isAvailable = true
    ),
    Yacht(
        id = 11,
        name = "Mediterranean Queen",
        manufacturer = "CRN",
        length = 5.5,
        crewNum = 8,
        pricePerDay = 4800,
        imageUrl = "https://images.unsplash.com/photo-1501771924607-209f42a6e7e4?w=800&h=600&fit=crop",
        isAvailable = true
    ),
    Yacht(
        id = 12,
        name = "Caribbean Jewel",
        manufacturer = "Feadship",
        length = 18.5,
        crewNum = 6,
        pricePerDay = 4200,
        imageUrl = "https://images.unsplash.com/photo-1696585805237-45df9bcd3d61?w=800&h=600&fit=crop",
        isAvailable = true
    )
)