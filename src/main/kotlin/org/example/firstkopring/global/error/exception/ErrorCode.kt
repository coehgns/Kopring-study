package org.example.firstkopring.global.error.exception

enum class ErrorCode(
    val statusCode: Int,
    val message: String,
) {
    INVALID_TOKEN(401, "invalid token"),
    TOKEN_EXPIRED(401, "Token Expired"),
    PASSWORD_MISMATCH(401, "password mismatch"),
    BOARD_AUTHOR_MISMATCH(403, "Board author mismatch"),
    BOARD_NOT_FOUND(404, "board not found."),
    USER_NOT_FOUND(404, "user not found"),
    RefreshTokenNotFoundException(404, "refreshToken not found."),
    USER_ALREADY_EXISTS(409, "User Already Exists"),
    INTERNAL_SERVER_ERROR(500, "Internal server error")
}