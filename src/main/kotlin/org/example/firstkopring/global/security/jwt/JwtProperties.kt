package org.example.firstkopring.global.security.jwt

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
data class JwtProperties(
    val header: String,

    val prefix: String,

    val secretKey: String,

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val accessExpiration: Long,

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val refreshExpiration: Long
)
