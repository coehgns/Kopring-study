package org.example.firstkopring.domain.auth.domain

import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive

@RedisHash
@Table(name = "refresh_token")
class RefreshToken(
    @Id
    val accountId: String,

    val token: String,

    @TimeToLive
    val expiration: Long
)