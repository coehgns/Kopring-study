package org.example.firstkopring.domain.user.exception

import org.example.firstkopring.global.error.exception.BusinessException
import org.example.firstkopring.global.error.exception.ErrorCode

object UserNotFoundException: BusinessException(ErrorCode.USER_NOT_FOUND)