package org.example.firstkopring.global.security.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import jakarta.servlet.http.HttpServletRequest
import org.example.firstkopring.domain.auth.domain.RefreshToken
import org.example.firstkopring.domain.auth.domain.repository.RefreshTokenRepository
import org.example.firstkopring.domain.auth.presentation.dto.response.TokenResponse
import org.example.firstkopring.domain.user.domain.repository.UserRepository
import org.example.firstkopring.global.error.exception.BusinessException
import org.example.firstkopring.global.error.exception.ErrorCode
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import java.util.Date

@Component
class JwtProvider(
    private val jwtProperties: JwtProperties,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val userRepository: UserRepository
) {
    fun generateToken(accountId: String): TokenResponse {
        val now = Date()

        val accessToken = createAccessToken(accountId)
        val refreshToken = createRefreshToken(accountId)

        refreshTokenRepository.save(
            RefreshToken(
                accountId = accountId,
                token = refreshToken
            )
        )

        return TokenResponse(
            accessToken = accessToken,
            refreshToken = refreshToken,
            accessTokenExpiredAt = Date(now.time + jwtProperties.accessExpiration),
            refreshTokenExpiredAt = Date(now.time + jwtProperties.refreshExpiration)
        )
    }

    fun createAccessToken(accountId: String): String {
        val now = Date()

        val accessToken = Jwts.builder()
            .setSubject(accountId)
            .claim("type", "access")
            .setIssuedAt(now)
            .setExpiration(Date(now.time + jwtProperties.accessExpiration * 1000))
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .compact()!!

        return accessToken
    }

    fun createRefreshToken(accountId: String): String {
        val now = Date()

        val refreshToken = Jwts.builder()
            .setSubject(accountId)
            .claim("type", "refresh")
            .setIssuedAt(now)
            .setExpiration(Date(now.time + jwtProperties.refreshExpiration * 1000))
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .compact()!!

        return refreshToken
    }

    fun receiveToken(accountId: String): TokenResponse {
        return generateToken(accountId)
    }

    fun reissue(rfToken: String): TokenResponse {
        val token: RefreshToken = refreshTokenRepository.findByToken(rfToken)
            ?: throw BusinessException(ErrorCode.INVALID_TOKEN)

        val accountId: String = (userRepository.findByUsername(token.accountId)
            ?: throw BusinessException(ErrorCode.USER_NOT_FOUND)).username

        refreshTokenRepository.delete(token)

        val accessToken = createAccessToken(accountId)
        val refreshToken = createRefreshToken(accountId)

        val now = Date()

        return TokenResponse(
            accessToken = accessToken,
            refreshToken = refreshToken,
            accessTokenExpiredAt = Date(now.time + jwtProperties.accessExpiration),
            refreshTokenExpiredAt = Date(now.time + jwtProperties.refreshExpiration)
        )
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearerToken: String = request.getHeader(jwtProperties.header)
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtProperties.prefix)) {
            return bearerToken.substring(7)
        }

        return bearerToken
    }
}