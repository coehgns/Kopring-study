package org.example.firstkopring.domain.user.service

import org.example.firstkopring.domain.user.facade.UserFacade
import org.example.firstkopring.domain.user.presentation.dto.response.GetUserInfoResponse
import org.springframework.stereotype.Service

@Service
class GetUserInfoService(
    private val userFacade: UserFacade
) {
    fun execute(userId: Long): GetUserInfoResponse {
        val user = userFacade.findByUserId(userId)

        return GetUserInfoResponse(
            username = user.username,
            authority = user.authority
        )
    }
}