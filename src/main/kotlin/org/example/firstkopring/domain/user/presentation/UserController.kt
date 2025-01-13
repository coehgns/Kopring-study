package org.example.firstkopring.domain.user.presentation

import org.example.firstkopring.domain.user.presentation.dto.response.GetMyInfoResponse
import org.example.firstkopring.domain.user.service.GetMyInfoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val getMyInfoService: GetMyInfoService
) {
    @GetMapping
    fun getMyInfo(): GetMyInfoResponse {
        return getMyInfoService.execute()
    }
}