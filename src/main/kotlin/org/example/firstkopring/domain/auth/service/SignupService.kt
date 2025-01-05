package org.example.firstkopring.domain.auth.service

import org.example.firstkopring.domain.auth.presentation.dto.request.SignupRequest
import org.example.firstkopring.domain.auth.presentation.dto.response.TokenResponse
import org.example.firstkopring.domain.user.domain.User
import org.example.firstkopring.domain.user.domain.repository.UserRepository
import org.example.firstkopring.domain.user.facade.UserFacade
import org.example.firstkopring.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignupService(
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository,
    private val jwtProvider: JwtTokenProvider,
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(request: SignupRequest): TokenResponse {
        userFacade.checkUserExist(request.username)

        val user = userRepository.save(
            User(
                username = request.username,
                password = passwordEncoder.encode(request.password)
            )
        )

        return jwtProvider.generateToken(request.username)
    }
}