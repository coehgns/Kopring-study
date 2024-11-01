package org.example.firstkopring.domain.user.service

import org.example.firstkopring.domain.user.domain.User
import org.example.firstkopring.domain.user.domain.repository.UserRepository
import org.example.firstkopring.domain.user.presentation.dto.request.SaveUserRequest
import org.springframework.stereotype.Service

@Service
class SaveUserService(
    private val userRepository: UserRepository
) {
    fun execute(saveUserRequest: SaveUserRequest) =
        userRepository.save(
            saveUserRequest.run {
                User(
                    name = name,
                    age = age
                )
            }
        )
}