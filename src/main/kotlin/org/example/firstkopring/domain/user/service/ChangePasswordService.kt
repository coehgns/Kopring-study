package org.example.firstkopring.domain.user.service

import org.example.firstkopring.domain.user.domain.repository.UserRepository
import org.example.firstkopring.domain.user.facade.UserFacade
import org.example.firstkopring.domain.user.presentation.dto.request.ChangePasswordRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ChangePasswordService(
    private val userFacade: UserFacade,
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository
) {
    @Transactional
    fun execute(request: ChangePasswordRequest) {
        val user = userFacade.currentUser()
        userFacade.checkPassword(user, request.oldPassword)

        user.changePassword(passwordEncoder.encode(request.newPassword))
        userRepository.save(user)
    }
}