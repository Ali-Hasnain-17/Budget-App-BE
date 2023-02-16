package com.pinchpenny.pinchpenny.repository

import com.pinchpenny.pinchpenny.modals.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository: JpaRepository<User, Long> {
    fun findByEmail(email: String): Optional<User>

}