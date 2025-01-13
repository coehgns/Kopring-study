package org.example.firstkopring.domain.user.facade

import org.example.firstkopring.domain.auth.exception.PasswordMissmatchException
import org.example.firstkopring.domain.user.domain.User
import org.example.firstkopring.domain.user.domain.repository.UserRepository
import org.example.firstkopring.domain.user.exception.UserAlreadyExistException
import org.example.firstkopring.domain.user.exception.UserNotFoundException
import org.example.firstkopring.global.error.exception.BusinessException
import org.example.firstkopring.global.error.exception.ErrorCode
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun currentUser(): User {
        val username: String = SecurityContextHolder.getContext().authentication.name
        return userRepository.findByUsername(username)
            ?: throw BusinessException(ErrorCode.USER_NOT_FOUND)
    }

    fun checkUserExist(username: String) {
        userRepository.findByUsername(username)
            ?: throw UserAlreadyExistException
    }

    fun checkPassword(
        user: User,
        password: String
    ) {
        if (passwordEncoder.matches(user.password, password)) {
            throw PasswordMissmatchException
        }
    }

    fun findByUsername(username: String): User {
        return userRepository.findByUsername(username)
            ?: throw UserNotFoundException
    }

    fun findByUserId(userid: Long): User {
        return userRepository.findByIdOrNull(userid)
            ?: throw UserNotFoundException
    }
}