package org.example.firstkopring.domain.presentation

import org.example.firstkopring.domain.domain.User
import org.example.firstkopring.domain.presentation.dto.request.SaveUserRequest
import org.example.firstkopring.domain.presentation.dto.response.GetUserResponse
import org.example.firstkopring.domain.service.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {
    @PostMapping
    fun addUser(@RequestBody saveUserRequest: SaveUserRequest) = userService.saveUser(saveUserRequest)

    @GetMapping("/{id}")
    fun findUser(@PathVariable id: Long) : User = userService.findUser(id)

    @GetMapping
    fun selectAllUser() : List<User> = userService.selectAllUser()

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) = userService.deleteUser(id)
}