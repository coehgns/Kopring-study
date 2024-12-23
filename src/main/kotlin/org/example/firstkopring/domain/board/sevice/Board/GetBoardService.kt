package org.example.firstkopring.domain.board.sevice.Board

import org.example.firstkopring.domain.board.domain.Board
import org.example.firstkopring.domain.board.domain.repository.BoardRepository
import org.example.firstkopring.domain.board.presentation.dto.response.BoardResponse
import org.example.firstkopring.global.error.exception.BusinessException
import org.example.firstkopring.global.error.exception.ErrorCode
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GetBoardService(
    private val boardRepository: BoardRepository
) {
    fun execute(id: Long): BoardResponse {
        val board: Board = boardRepository.findByIdOrNull(id)
            ?: throw BusinessException(ErrorCode.BOARD_NOT_FOUND)

        return BoardResponse.fromBoard(board)
    }
}