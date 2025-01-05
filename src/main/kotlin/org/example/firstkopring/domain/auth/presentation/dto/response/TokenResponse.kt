package org.example.firstkopring.domain.auth.presentation.dto.response

import java.util.Date

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessExp: Date,
)
