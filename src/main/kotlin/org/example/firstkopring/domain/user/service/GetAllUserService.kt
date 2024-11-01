package org.example.firstkopring.domain.user.service

import org.example.firstkopring.domain.user.domain.User
import org.example.firstkopring.domain.user.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class GetAllUserService(
    private val userRepository: UserRepository
) {
    fun execute() : List<User> = userRepository.findAll()
}