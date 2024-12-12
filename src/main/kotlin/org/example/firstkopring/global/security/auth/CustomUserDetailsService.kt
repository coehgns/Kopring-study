package org.example.firstkopring.global.security.auth

import org.example.firstkopring.domain.user.domain.User
import org.example.firstkopring.domain.user.domain.repository.UserRepository
import org.example.firstkopring.domain.user.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
): UserDetailsService {

    override fun loadUserByUsername(username: String): CustomUserDetails {
        val user: User = userRepository.findByUsername(username)
            ?: throw UserNotFoundException
        return CustomUserDetails(user)
    }
}