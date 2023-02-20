package com.pinchpenny.pinchpenny.exceptions

import com.pinchpenny.pinchpenny.dtos.Response
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
    @ExceptionHandler(com.pinchpenny.pinchpenny.exceptions.NotFoundException::class)
    fun notFoundExceptionHandler(
        exception: com.pinchpenny.pinchpenny.exceptions.NotFoundException,
        request: WebRequest
    ): ResponseEntity<Response<String>> {
        val errorMessage = ErrorMessage(HttpStatus.NOT_FOUND, exception.message.toString())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Response<String>(errorMessage.status, errorMessage.message, null))
    }
}