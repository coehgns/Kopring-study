package org.example.firstkopring.global.security.jwt

import org.example.firstkopring.domain.auth.domain.repository.RefreshTokenRepository
import org.example.firstkopring.global.security.auth.CustomUserDetailsService
import org.springframework.stereotype.Component

@Component
class JwtProvider(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val customUserDetailsService: CustomUserDetailsService,
    private val jwtProperties: JwtProperties
) {

    fun createToken(username: String, authority: Authority)
}