package org.example.firstkopring.domain.auth.service

import org.example.firstkopring.domain.auth.presentation.dto.request.LoginRequest
import org.example.firstkopring.domain.auth.presentation.dto.response.TokenResponse
import org.example.firstkopring.domain.user.facade.UserFacade
import org.example.firstkopring.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LoginService(
    private val userFacade: UserFacade,
    private val jwtTokenProvider: JwtTokenProvider,
) {
    @Transactional
    fun execute(request: LoginRequest): TokenResponse {
        val user = userFacade.findByUsername(request.username)

        userFacade.checkPassword(user, request.password)

        return jwtTokenProvider.generateToken(request.username)
    }
}