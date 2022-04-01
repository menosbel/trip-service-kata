package org.proyecto404.tripservice.trip

import org.proyecto404.tripservice.user.Session
import org.proyecto404.tripservice.user.User

class FakeSession(user: User? = null) : Session {
    override val loggedUser: User? = user
}
