package com.pinchpenny.pinchpenny.exceptions

import com.pinchpenny.pinchpenny.modals.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
@ResponseStatus
class ErrorHandler: ResponseEntityExceptionHandler() {
    @ExceptionHandler(NotFoundException::class)
    fun notFoundExceptionHandler(
        exception: NotFoundException,
        request: WebRequest
    ): ResponseEntity<ErrorMessage> {
        val errorMessage = ErrorMessage(HttpStatus.NOT_FOUND, exception.message.toString())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage)
    }
}