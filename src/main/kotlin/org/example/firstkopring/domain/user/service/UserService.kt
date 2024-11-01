package org.example.firstkopring.domain.user.service

import org.example.firstkopring.domain.user.domain.User
import org.example.firstkopring.domain.user.domain.repository.UserRepository
import org.example.firstkopring.domain.user.presentation.dto.request.SaveUserRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun saveUser(saveUserRequest: SaveUserRequest) {
        userRepository.save(
            saveUserRequest.run {
                User(
                    name = name,
                    age = age
                )
            }
        )
    }

    fun findUser(id: Long) : User =
        userRepository.findByIdOrNull(id)
            ?: throw RuntimeException("user runtime exception")

    fun selectAllUser(): List<User> = userRepository.findAll()

    fun deleteUser(id: Long) = userRepository.deleteById(id)
}