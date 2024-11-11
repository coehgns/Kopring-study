package org.example.firstkopring.global.error.exception

enum class ErrorCode(
    val statusCode: Int,
    val message: String,
) {
    INVALID_TOKEN(401, "invalid token"),
    BOARD_NOT_FOUND(404, "board not found."),
    USER_NOT_FOUND(404, "user not found"),
    INTERNAL_SERVER_ERROR(500, "Internal server error")
}