package org.example.firstkopring.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
class JwtProperties(
    val header: String,
    val prefix: String,
    val secretKey: String,
    val accessExpiration: Long,
    val refreshExpiration: Long
)
