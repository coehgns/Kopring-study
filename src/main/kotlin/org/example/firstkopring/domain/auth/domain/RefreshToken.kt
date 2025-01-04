package org.example.firstkopring.domain.auth.domain

import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "refresh_token")
class RefreshToken(
    @Id
    val accountId: String,

    val token: String,

    val expiration: Long
)