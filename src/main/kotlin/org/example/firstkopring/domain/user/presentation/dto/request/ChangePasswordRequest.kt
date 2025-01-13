package org.example.firstkopring.domain.user.presentation.dto.request

data class ChangePasswordRequest(
    val oldPassword: String,
    val newPassword: String
)
