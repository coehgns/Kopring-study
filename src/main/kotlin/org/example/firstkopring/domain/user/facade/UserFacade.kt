package org.example.firstkopring.domain.user.facade

import org.example.firstkopring.domain.user.domain.User
import org.example.firstkopring.domain.user.domain.repository.UserRepository
import org.example.firstkopring.global.error.exception.BusinessException
import org.example.firstkopring.global.error.exception.ErrorCode
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {
    fun currentUser(): User {
        val username: String = SecurityContextHolder.getContext().authentication.name
        return userRepository.findByUsername(username)
            ?: throw BusinessException(ErrorCode.USER_NOT_FOUND)
    }
}