package org.example.firstkopring.domain.user.presentation.dto.response

import org.example.firstkopring.domain.user.domain.enums.Authority

data class GetMyInfoResponse(
    val username: String,
    val authority: Authority
)
