package org.example.firstkopring.domain.auth.presentation

import org.example.firstkopring.domain.auth.presentation.dto.request.LoginRequest
import org.example.firstkopring.domain.auth.presentation.dto.request.SignupRequest
import org.example.firstkopring.domain.auth.presentation.dto.response.TokenResponse
import org.example.firstkopring.domain.auth.service.LoginService
import org.example.firstkopring.domain.auth.service.SignupService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val signupService: SignupService,
    private val loginService: LoginService
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signup(@RequestBody request: SignupRequest): TokenResponse {
        return signupService.execute(request)
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): TokenResponse {
        return loginService.execute(request)
    }
}