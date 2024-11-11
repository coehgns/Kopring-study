package org.example.firstkopring.domain.auth.presentation.dto.response

import java.util.*

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpiredAt: Date,
    val refreshTokenExpiredAt: Date
)
