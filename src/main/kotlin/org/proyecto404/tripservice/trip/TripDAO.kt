package org.proyecto404.tripservice.trip

import org.proyecto404.tripservice.exception.CollaboratorCallException
import org.proyecto404.tripservice.user.User

class TripDAO : Trips {
    override fun findByUser(user: User): List<Trip> {
        throw CollaboratorCallException("TripDAO should not be invoked on an unit test.")
    }
}
