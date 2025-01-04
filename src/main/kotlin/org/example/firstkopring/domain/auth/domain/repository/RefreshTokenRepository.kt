package org.example.firstkopring.domain.auth.domain.repository

import org.example.firstkopring.domain.auth.domain.RefreshToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository: CrudRepository<RefreshToken, Long> {
    fun findByToken(token: String): RefreshToken
}