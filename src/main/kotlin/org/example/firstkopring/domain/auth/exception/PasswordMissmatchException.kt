package org.example.firstkopring.domain.auth.exception

import org.example.firstkopring.global.error.exception.BusinessException
import org.example.firstkopring.global.error.exception.ErrorCode

object PasswordMissmatchException: BusinessException(ErrorCode.PASSWORD_MISMATCH)