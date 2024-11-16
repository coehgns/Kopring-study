package org.example.firstkopring.domain.board.sevice.Board

import org.example.firstkopring.domain.board.domain.Board
import org.example.firstkopring.domain.board.domain.repository.BoardRepository
import org.example.firstkopring.domain.user.facade.UserFacade
import org.example.firstkopring.global.error.exception.BusinessException
import org.example.firstkopring.global.error.exception.ErrorCode
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class DeleteBoardService(
    private val boardRepository: BoardRepository,
    private val userFacade: UserFacade
) {
    fun execute(id: Long) {
        val board: Board = boardRepository.findByIdOrNull(id)
            ?: throw BusinessException(ErrorCode.BOARD_NOT_FOUND)

        val currentUser = userFacade.currentUser()

        if(currentUser != board.user) {
            throw BusinessException(ErrorCode.BOARD_AUTHOR_MISMATCH)
        }

        boardRepository.deleteById(id)
    }
}