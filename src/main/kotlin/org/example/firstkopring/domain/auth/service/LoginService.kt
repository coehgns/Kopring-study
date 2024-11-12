package org.example.firstkopring.domain.auth.service

import org.example.firstkopring.domain.auth.presentation.dto.request.LoginRequest
import org.example.firstkopring.domain.auth.presentation.dto.response.TokenResponse
import org.example.firstkopring.domain.user.domain.User
import org.example.firstkopring.domain.user.domain.repository.UserRepository
import org.example.firstkopring.global.error.exception.BusinessException
import org.example.firstkopring.global.error.exception.ErrorCode
import org.example.firstkopring.global.security.jwt.JwtProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class LoginService(
    val passwordEncoder: PasswordEncoder,
    val jwtProvider: JwtProvider,
    val userRepository: UserRepository
) {
    fun execute(request: LoginRequest): TokenResponse {
        val user: User = userRepository.findByUsername(request.username)
            ?: throw BusinessException(ErrorCode.USER_NOT_FOUND)

        if (!passwordEncoder.matches(user.password, request.password)) {
            throw BusinessException(ErrorCode.PASSWORD_MISMATCH)
        }

        return jwtProvider.receiveToken(request.username)
    }
}