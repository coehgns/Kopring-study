package org.example.firstkopring.global.security.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.example.firstkopring.domain.auth.domain.RefreshToken
import org.example.firstkopring.domain.auth.domain.repository.RefreshTokenRepository
import org.example.firstkopring.global.security.auth.CustomUserDetailsService
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtProvider(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val customUserDetailsService: CustomUserDetailsService,
    private val jwtProperties: JwtProperties
) {
    fun createAccessToken(username: String): String {
        return createToken(username, "access", jwtProperties.accessExpiration)
    }

    fun createRefreshToken(username: String): String {
        val rfToken = createAccessToken(username)
        refreshTokenRepository.save(
            RefreshToken(
                username = username,
                token = rfToken,
                expiration = jwtProperties.refreshExpiration * 1000
            )
        )

        return rfToken
    }

    private fun createToken(username: String, jwtType: String, exp: Long): String {
        return Jwts.builder()
            .signWith(Keys.hmacShaKeyFor(jwtProperties.secretKey.toByteArray()), SignatureAlgorithm.HS256)
            .setSubject(username)
            .setId(username)
            .claim("type", jwtType)
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .compact()
    }
}