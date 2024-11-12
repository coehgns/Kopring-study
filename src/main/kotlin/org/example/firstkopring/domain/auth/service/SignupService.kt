package org.example.firstkopring.domain.auth.service

import org.example.firstkopring.domain.auth.presentation.dto.request.SignupRequest
import org.example.firstkopring.domain.user.domain.User
import org.example.firstkopring.domain.user.domain.repository.UserRepository
import org.example.firstkopring.global.error.exception.BusinessException
import org.example.firstkopring.global.error.exception.ErrorCode
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignupService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun execute(request: SignupRequest) {
        if (userRepository.existsByUsername(request.username)) {
            throw BusinessException(ErrorCode.USER_ALREADY_EXISTS)
        }

        userRepository.save(
            User(
                username = request.username,
                password = passwordEncoder.encode(request.password)
            )
        )
    }
}