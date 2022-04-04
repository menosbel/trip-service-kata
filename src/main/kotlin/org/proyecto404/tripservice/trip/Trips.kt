package org.proyecto404.tripservice.trip

import org.proyecto404.tripservice.user.User

interface Trips {
    fun findByUser(user: User): List<Trip>
}
