package org.example.firstkopring.global.error.exception

class BusinessException(
    val errorCode: ErrorCode
): RuntimeException()