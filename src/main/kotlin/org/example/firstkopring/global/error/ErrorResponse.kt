package org.example.firstkopring.global.error


data class ErrorResponse(
    val message: String,
    val statusCode: Int,
    val description: String,
)
