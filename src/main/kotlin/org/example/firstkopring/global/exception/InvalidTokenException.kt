package org.example.firstkopring.global.exception

import org.example.firstkopring.global.error.exception.BusinessException
import org.example.firstkopring.global.error.exception.ErrorCode

object InvalidTokenException: BusinessException(ErrorCode.INVALID_TOKEN)