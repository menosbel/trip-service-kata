package org.proyecto404.tripservice.trip

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.proyecto404.tripservice.exception.CollaboratorCallException
import org.proyecto404.tripservice.user.User

class TripServiceTest {
    @Test
    fun `fail if user is not logged in`() {
        assertThrows<CollaboratorCallException> { TripService().getTripsByUser(User()) }
    }
}
