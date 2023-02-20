package com.pinchpenny.pinchpenny.dtos

import org.springframework.http.HttpStatus

data class Response<T>(
    val status: HttpStatus,
    val error: String?,
    val data: T?
)