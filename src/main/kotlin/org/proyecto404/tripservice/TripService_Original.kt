package org.proyecto404.tripservice

import org.proyecto404.tripservice.exception.UserNotLoggedInException
import org.proyecto404.tripservice.trip.Trip
import org.proyecto404.tripservice.trip.TripDAO
import org.proyecto404.tripservice.user.User
import org.proyecto404.tripservice.user.UserSession
import java.util.*

class TripService_Original {

    fun getTripsByUser(user: User): List<Trip> {
        var tripList: List<Trip> = ArrayList<Trip>()
        val loggedUser: User? = UserSession.instance.loggedUser
        var isFriend: Boolean = false
        if (loggedUser != null) {
            for (friend in user.friends) {
                if (friend == loggedUser) {
                    isFriend = true
                    break
                }
            }
            if (isFriend) {
                tripList = TripDAO.findTripsByUser(user)
            }
            return tripList
        } else {
            throw UserNotLoggedInException()
        }
    }

}
