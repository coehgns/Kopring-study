package org.example.firstkopring.domain.user.exception

import org.example.firstkopring.global.error.exception.BusinessException
import org.example.firstkopring.global.error.exception.ErrorCode

object UserAlreadyExistException: BusinessException(ErrorCode.USER_ALREADY_EXISTS)