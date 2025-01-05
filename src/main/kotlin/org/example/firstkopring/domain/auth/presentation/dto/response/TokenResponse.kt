package org.example.firstkopring.domain.auth.presentation.dto.response

import java.util.Date

data class TokenResponse(
    private val accessToken: String,
    private val refreshToken: String,
    private val accessExp: Date,
    private val refreshExp: Date
)
