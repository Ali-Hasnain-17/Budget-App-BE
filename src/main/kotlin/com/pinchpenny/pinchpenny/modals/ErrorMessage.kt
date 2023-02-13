package com.pinchpenny.pinchpenny.modals

import org.springframework.http.HttpStatus

data class ErrorMessage(
    val status: HttpStatus,
    val message: String
)