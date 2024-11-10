package org.example.firstkopring.domain.user.service

import org.example.firstkopring.domain.user.domain.User
import org.example.firstkopring.domain.user.domain.repository.UserRepository
import org.example.firstkopring.global.error.exception.BusinessException
import org.example.firstkopring.global.error.exception.ErrorCode
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GetUserService(
    private val userRepository: UserRepository
) {
    fun execute(id: Long) : User =
        userRepository.findByIdOrNull(id)
            ?: throw BusinessException(ErrorCode.USER_NOT_FOUND)
}