package org.example.firstkopring.domain.board.sevice

import org.example.firstkopring.domain.board.domain.repository.BoardRepository
import org.example.firstkopring.domain.board.presentation.dto.request.ModifyBoardRequest
import org.example.firstkopring.global.error.exception.BusinessException
import org.example.firstkopring.global.error.exception.ErrorCode
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ModifyBoardService(
    private val boardRepository: BoardRepository
) {
    fun execute(id: Long, modifyBoardRequest: ModifyBoardRequest) {
        val board = boardRepository.findByIdOrNull(id)
            ?: throw BusinessException(ErrorCode.BOARD_NOT_FOUND)

        board.modifyBoard(modifyBoardRequest.title, modifyBoardRequest.content)
        boardRepository.save(board)
    }
}