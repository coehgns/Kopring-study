package org.example.firstkopring.global.error

import org.example.firstkopring.global.error.exception.BusinessException
import org.example.firstkopring.global.error.exception.ErrorCode
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException::class)
    fun handlerBusinessException(e: BusinessException): ResponseEntity<ErrorResponse> {
        val errorCode: ErrorCode = e.errorCode
        val errorResponse: ErrorResponse = ErrorResponse.of(errorCode, e.errorCode.message)
        return ResponseEntity(errorResponse, HttpStatus.valueOf(errorCode.statusCode))
    }

    @ExceptionHandler(Exception::class)
    fun handlerException(e: Exception): ResponseEntity<ErrorResponse> {
        val errorCode: ErrorCode = ErrorCode.INTERNAL_SERVER_ERROR
        val errorResponse: ErrorResponse = ErrorResponse.of(errorCode, e.message.toString())
        return ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}