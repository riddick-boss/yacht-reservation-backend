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
        length = 85.0,
        crewNum = 6,
        price = 2500000
    ),
    Yacht(
        id = 2,
        name = "Ocean Majesty",
        manufacturer = "Azimut",
        length = 95.0,
        crewNum = 8,
        price = 3200000
    ),
    Yacht(
        id = 3,
        name = "Royal Escape",
        manufacturer = "Princess",
        length = 78.0,
        crewNum = 5,
        price = 1800000
    ),
    Yacht(
        id = 4,
        name = "Pacific Dream",
        manufacturer = "Ferretti",
        length = 88.0,
        crewNum = 7,
        price = 2800000
    ),
    Yacht(
        id = 5,
        name = "Mediterranean Star",
        manufacturer = "Sanlorenzo",
        length = 92.0,
        crewNum = 7,
        price = 3500000
    ),
    Yacht(
        id = 6,
        name = "Caribbean Breeze",
        manufacturer = "Beneteau",
        length = 82.0,
        crewNum = 5,
        price = 2200000
    ),
    Yacht(
        id = 7,
        name = "Nordic Explorer",
        manufacturer = "Lürssen",
        length = 85.0,
        crewNum = 6,
        price = 4200000
    ),
    Yacht(
        id = 8,
        name = "Aegean Spirit",
        manufacturer = "Riva",
        length = 90.0,
        crewNum = 7,
        price = 3800000
    ),
    Yacht(
        id = 9,
        name = "Atlantic Voyager",
        manufacturer = "Heesen",
        length = 95.0,
        crewNum = 8,
        price = 4500000
    ),
    Yacht(
        id = 10,
        name = "Pacific Pearl",
        manufacturer = "Amels",
        length = 88.0,
        crewNum = 7,
        price = 4000000
    ),
    Yacht(
        id = 11,
        name = "Mediterranean Queen",
        manufacturer = "CRN",
        length = 92.0,
        crewNum = 8,
        price = 4800000
    ),
    Yacht(
        id = 12,
        name = "Caribbean Jewel",
        manufacturer = "Feadship",
        length = 85.0,
        crewNum = 6,
        price = 4200000
    )
)