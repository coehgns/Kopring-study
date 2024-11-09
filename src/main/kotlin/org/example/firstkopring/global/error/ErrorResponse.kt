package org.example.firstkopring.global.error

import org.example.firstkopring.global.error.exception.ErrorCode


data class ErrorResponse(
    val message: String,
    val statusCode: Int,
    val description: String,
) {

    companion object{
        fun of(errorCode: ErrorCode, message: String): ErrorResponse {
            return ErrorResponse(
                statusCode = errorCode.statusCode,
                message = errorCode.message,
                description = errorCode.message,
            )
        }
    }
}
