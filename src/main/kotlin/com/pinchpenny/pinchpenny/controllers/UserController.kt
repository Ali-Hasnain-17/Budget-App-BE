package com.pinchpenny.pinchpenny.controllers

import com.pinchpenny.pinchpenny.dtos.AuthRequestDTO
import com.pinchpenny.pinchpenny.dtos.AuthResponseDTO
import com.pinchpenny.pinchpenny.dtos.RegisterRequestDTO
import com.pinchpenny.pinchpenny.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController {
    @Autowired
    private lateinit var userService: UserService
    private var application:ApplicationEventPublisher
        get() {
            return application
        }
        set(value) {}

    @GetMapping("/users")
    fun getUsers(): String {
        return "Users"
    }

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequestDTO): String {
        return userService.register(request);
    }

    @PostMapping("/authenticate")
    fun authenticate(@RequestBody request: AuthRequestDTO): AuthResponseDTO {
        return userService.authenticate(request)
    }
}