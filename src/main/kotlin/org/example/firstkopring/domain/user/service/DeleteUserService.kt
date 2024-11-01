package org.example.firstkopring.domain.user.service

import org.example.firstkopring.domain.user.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class DeleteUserService(
    private val userRepository: UserRepository
) {
    fun execute(id: Long) = userRepository.deleteById(id)
}