package org.example.firstkopring.domain.auth.domain

import jakarta.persistence.Column
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive

@RedisHash
@Table(name = "refresh_token")
class RefreshToken(
    @Id
    @Column(name = "id", nullable = false, unique = true)
    val accountId: String,

    @Column(name = "refresh_token", nullable = false)
    val token: String,

    @TimeToLive
    @Column(name = "token_expiration", nullable = false)
    val expiration: Long
)