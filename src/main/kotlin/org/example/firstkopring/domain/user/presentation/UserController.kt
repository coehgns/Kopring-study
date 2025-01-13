package org.example.firstkopring.domain.user.presentation

import org.example.firstkopring.domain.user.presentation.dto.response.GetMyInfoResponse
import org.example.firstkopring.domain.user.presentation.dto.response.GetUserInfoResponse
import org.example.firstkopring.domain.user.service.GetMyInfoService
import org.example.firstkopring.domain.user.service.GetUserInfoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val getMyInfoService: GetMyInfoService,
    private val getUserInfoService: GetUserInfoService
) {
    @GetMapping
    fun getMyInfo(): GetMyInfoResponse {
        return getMyInfoService.execute()
    }

    @GetMapping("/{user-id}")
    fun getUserInfo(@PathVariable("user-id") userid: Long): GetUserInfoResponse {
        return getUserInfoService.execute(userid)
    }
}