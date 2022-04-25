package com.sieunee.springbootkotlinrest.common

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException
import javax.security.auth.message.AuthException

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(AuthException::class)
    fun exceptionHandler(e: AuthException) = ResponseEntity(
        Response(e.message),
        HttpStatus.UNAUTHORIZED
    )

    @ExceptionHandler(RuntimeException::class)
    fun exceptionHandler(e: RuntimeException) = ResponseEntity(
        Response(e.message),
        HttpStatus.INTERNAL_SERVER_ERROR
    )

    @ExceptionHandler(NoHandlerFoundException::class)
    fun exceptionHandler(e: NoHandlerFoundException) = ResponseEntity(
        Response(e.message),
        HttpStatus.NOT_FOUND
    )

    @ExceptionHandler
    fun exceptionHandler(e: HttpRequestMethodNotSupportedException) = ResponseEntity(
        Response(e.message),
        HttpStatus.METHOD_NOT_ALLOWED
    )

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun exceptionHandler(e: MethodArgumentNotValidException) = ResponseEntity(
        Response(e.message),
        HttpStatus.BAD_REQUEST
    )

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun exceptionHandler(e: HttpMessageNotReadableException) = ResponseEntity(
        Response(e.message),
        HttpStatus.BAD_REQUEST
    )
}