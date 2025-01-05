package org.example.firstkopring.domain.auth.service

import org.example.firstkopring.domain.auth.domain.RefreshToken
import org.example.firstkopring.domain.auth.domain.repository.RefreshTokenRepository
import org.example.firstkopring.domain.auth.exception.RefreshTokenNotFoundException
import org.example.firstkopring.domain.auth.presentation.dto.request.ReissueRequest
import org.example.firstkopring.domain.auth.presentation.dto.response.TokenResponse
import org.example.firstkopring.global.security.jwt.JwtProperties
import org.example.firstkopring.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Service

@Service
class TokenRefreshService(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtTokenProvider: JwtTokenProvider,
    private val jwtProperties: JwtProperties
) {
    fun execute(request: ReissueRequest): TokenResponse {
        val refreshToken: RefreshToken = refreshTokenRepository.findByToken(request.refreshToken)
            ?: throw RefreshTokenNotFoundException

        val tokens = jwtTokenProvider.generateToken(refreshToken.username)

        refreshToken.updateToken(tokens.refreshToken, jwtProperties.refreshExpiration)

        return tokens
    }
}