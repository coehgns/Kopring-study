package org.example.firstkopring.domain.auth.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "refresh_token")
class RefreshToken(
    @Id
    val accountId: String,

    val token: String,

    val expiration: Long
)