package org.example.firstkopring.domain.domain.repository

import org.example.firstkopring.domain.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
}