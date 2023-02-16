package com.pinchpenny.pinchpenny.dtos

data class RegisterRequestDTO(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val role: String,
)
