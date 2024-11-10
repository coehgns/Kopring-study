package org.example.firstkopring.domain.board.sevice

import org.example.firstkopring.domain.board.domain.Board
import org.example.firstkopring.domain.board.domain.repository.BoardRepository
import org.example.firstkopring.global.error.exception.BusinessException
import org.example.firstkopring.global.error.exception.ErrorCode
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class GetBoardService(
    private val boardRepository: BoardRepository
) {
    fun execute(id: Long) : Board =
        boardRepository.findByIdOrNull(id)
            ?: throw BusinessException(ErrorCode.BOARD_NOT_FOUND)
}