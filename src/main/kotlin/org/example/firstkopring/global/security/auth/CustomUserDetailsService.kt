package org.example.firstkopring.global.security.auth

import org.example.firstkopring.domain.user.domain.User
import org.example.firstkopring.domain.user.domain.repository.UserRepository
import org.example.firstkopring.global.error.exception.BusinessException
import org.example.firstkopring.global.error.exception.ErrorCode
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user: User = userRepository.findByUsername(username)
            ?: throw BusinessException(ErrorCode.USER_NOT_FOUND)

        return CustomUserDetails(user)
    }
}