package org.proyecto404.tripservice.trip

import org.proyecto404.tripservice.user.User

class InMemoryTrips: Trips {
    private val trips = mutableListOf<Trip>()

    override fun findByUser(user: User): List<Trip> {
        TODO()
    }
}
