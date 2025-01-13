package org.example.firstkopring.domain.user.service

import org.example.firstkopring.domain.user.facade.UserFacade
import org.example.firstkopring.domain.user.presentation.dto.response.GetMyInfoResponse
import org.springframework.stereotype.Service

@Service
class GetMyInfoService(
    private val userFacade: UserFacade
) {
    fun execute(): GetMyInfoResponse {
        val user = userFacade.currentUser()

        return GetMyInfoResponse(
            username = user.username,
            authority = user.authority
        )
    }
}