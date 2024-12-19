package org.example.firstkopring.domain.auth.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class RefreshToken(
    @Id
    val accountId: String,

    val token: String,

    val expiration: Long
)