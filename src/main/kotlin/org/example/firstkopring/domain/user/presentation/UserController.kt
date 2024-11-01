package org.example.firstkopring.domain.user.presentation

import org.example.firstkopring.domain.user.domain.User
import org.example.firstkopring.domain.user.presentation.dto.request.SaveUserRequest
import org.example.firstkopring.domain.user.service.DeleteUserService
import org.example.firstkopring.domain.user.service.GetAllUserService
import org.example.firstkopring.domain.user.service.GetUserService
import org.example.firstkopring.domain.user.service.SaveUserService
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
    private val saveUserService: SaveUserService,
    private val getUserService: GetUserService,
    private val getAllUserService: GetAllUserService,
    private val deleteUserService: DeleteUserService
) {
    @PostMapping
    fun saveUser(@RequestBody saveUserRequest: SaveUserRequest) = saveUserService.execute(saveUserRequest)

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long) : User = getUserService.execute(id)

    @GetMapping
    fun getAllUser() : List<User> = getAllUserService.execute()

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) = deleteUserService.execute(id)
}