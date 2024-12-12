package org.example.firstkopring.global.error.exception

open class BusinessException(
    val errorCode: ErrorCode
): RuntimeException()