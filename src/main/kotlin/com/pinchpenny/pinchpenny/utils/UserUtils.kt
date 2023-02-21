package com.pinchpenny.pinchpenny.utils

import com.pinchpenny.pinchpenny.modals.User
import com.pinchpenny.pinchpenny.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class UserUtils {
    @Autowired private lateinit var userRepository: UserRepository
    fun getCurrentLoggedInUser(): User {
        val principal: UserDetails = SecurityContextHolder.getContext().authentication.principal as UserDetails
        val email: String = principal.username;
        val user: User = userRepository.findByEmail(email).get()
        return user
    }

}