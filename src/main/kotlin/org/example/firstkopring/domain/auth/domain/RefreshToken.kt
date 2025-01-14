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
    val username: String,

    @Column(name = "refresh_token", nullable = false)
    var token: String,

    @TimeToLive
    @Column(name = "token_exp", nullable = false)
    var expiration: Long
) {
    fun updateToken(token: String, exp: Long) {
        this.token = token
        this.expiration = exp
    }
}