package com.pinchpenny.pinchpenny.services

import com.pinchpenny.pinchpenny.services.base.UserService
import com.pinchpenny.pinchpenny.dtos.AuthRequestDTO
import com.pinchpenny.pinchpenny.dtos.AuthResponseDTO
import com.pinchpenny.pinchpenny.dtos.RegisterRequestDTO
import com.pinchpenny.pinchpenny.exceptions.NotFoundException
import com.pinchpenny.pinchpenny.modals.User
import com.pinchpenny.pinchpenny.repository.UserRepository
import com.pinchpenny.pinchpenny.utils.JwtUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired private lateinit var userRepository: UserRepository
    @Autowired private lateinit var passwordEncoder: PasswordEncoder
    @Autowired lateinit var jwtUtil: JwtUtil
    @Autowired lateinit var authenticationManager: AuthenticationManager

    fun register(request: RegisterRequestDTO): String {
        val user: User = User(
            firstName = request.firstName,
            lastName = request.lastName,
            email = request.email,
            password = passwordEncoder.encode(request.password),
            role = request.role
        )
        userRepository.save(user)
        return "User Created"
    }

    fun authenticate(request: AuthRequestDTO): AuthResponseDTO {
        val auth: Authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(request.email, request.password)
        )
        if (auth.isAuthenticated) {
            val token: String = jwtUtil.generateToken(request.email)
            return AuthResponseDTO(token)
        } else {
            throw NotFoundException("Invalid email or password")
        }
    }

}