package org.example.firstkopring.global.error.exception

class BusinessException(
    val exception: ErrorCode
): RuntimeException()