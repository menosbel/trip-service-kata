package org.proyecto404.tripservice.user

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.proyecto404.tripservice.trip.Trip
import org.proyecto404.tripservice.user.User

class UserTest {
    @Test
    fun `add friend`() {
        someUser.addFriend(friend)

        assertThat(someUser.friends).contains(friend)
    }

    @Test
    fun `add trip`() {
        someUser.addTrip(trip)

        assertThat(someUser.trips).contains(trip)
    }

    private val trip = Trip()
    private val someUser = User()
    private val friend = User()
}
