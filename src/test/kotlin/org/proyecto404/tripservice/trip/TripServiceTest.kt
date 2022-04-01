package org.proyecto404.tripservice.trip

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.proyecto404.tripservice.exception.CollaboratorCallException
import org.proyecto404.tripservice.exception.UserNotLoggedInException
import org.proyecto404.tripservice.user.User
import org.proyecto404.tripservice.user.UserSession

class TripServiceTest {
    @Test
    fun `fail if collaborator is called`() {
        assertThrows<CollaboratorCallException> { TripService(UserSession.instance).getTripsByUser(User()) }
    }

    @Test
    fun `fail if user is not logged in`() {
        assertThrows<UserNotLoggedInException> { TripService(FakeSession()).getTripsByUser(User()) }
    }

    @Test
    fun `return empty trip list if user has no friends`() {
        user.addFriend(friend)

        val list = TripService(session).getTripsByUser(user)

        assertThat(list).isEmpty()
    }

    @Test
    fun `fails if user has a logged in friend`() {
        user.addFriend(friend)

        assertThrows<CollaboratorCallException> {
            TripService(friendSession).getTripsByUser(user)
        }
    }


    private val user = User()
    private val friend = User()
    private val session = FakeSession(user)
    private val friendSession = FakeSession(friend)
}
