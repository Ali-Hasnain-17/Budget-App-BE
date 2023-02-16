package com.pinchpenny.pinchpenny.services

import com.pinchpenny.pinchpenny.exceptions.NotFoundException
import com.pinchpenny.pinchpenny.modals.MyUserDetails
import com.pinchpenny.pinchpenny.modals.User
import com.pinchpenny.pinchpenny.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.Optional

@Service
@Transactional
class MyUserDetailsService : UserDetailsService {
    @Autowired
    private lateinit var userRepository: UserRepository
    override fun loadUserByUsername(email: String): UserDetails {
        val user: Optional<User> = userRepository.findByEmail(email)
        if (user.isPresent) {
            return MyUserDetails(
                user.get().email,
                user.get().password,
                mutableListOf(SimpleGrantedAuthority(user.get().role))
            )
        } else {
            throw NotFoundException("Invalid email or password")
        }
    }

}
