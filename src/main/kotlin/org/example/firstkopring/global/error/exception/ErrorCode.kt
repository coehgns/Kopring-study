package org.example.firstkopring.global.error.exception

enum class ErrorCode(
    val statusCode: Int,
    val message: String,
) {
    BOARD_NOT_FOUND(404, "board not found."),
    USER_NOT_FOUND(404, "user not found")
}