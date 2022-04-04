package org.proyecto404.tripservice.trip

import org.proyecto404.tripservice.exception.UserNotLoggedInException
import org.proyecto404.tripservice.user.Session
import org.proyecto404.tripservice.user.User

class TripService(private val session: Session, private val trips: Trips) {
    fun getTripsByUser(user: User): List<Trip> {
        var tripList: List<Trip> = ArrayList<Trip>()
        val loggedUser: User? = session.loggedUser
        var isFriend = false
        if (loggedUser != null) {
            for (friend in user.friends) {
                if (friend == loggedUser) {
                    isFriend = true
                    break
                }
            }
            if (isFriend) {
                tripList = trips.findByUser(user)
            }
            return tripList
        } else {
            throw UserNotLoggedInException()
        }
    }
}
