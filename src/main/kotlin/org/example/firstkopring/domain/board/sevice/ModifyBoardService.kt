package org.example.firstkopring.domain.board.sevice

import org.example.firstkopring.domain.board.domain.repository.BoardRepository
import org.example.firstkopring.domain.board.presentation.dto.request.ModifyBoardRequest
import org.example.firstkopring.domain.user.facade.UserFacade
import org.example.firstkopring.global.error.exception.BusinessException
import org.example.firstkopring.global.error.exception.ErrorCode
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ModifyBoardService(
    private val boardRepository: BoardRepository,
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(id: Long, modifyBoardRequest: ModifyBoardRequest) {
        val board = boardRepository.findByIdOrNull(id)
            ?: throw BusinessException(ErrorCode.BOARD_NOT_FOUND)

        val currentUser = userFacade.currentUser()

        if(currentUser == board.user) {
            throw BusinessException(ErrorCode.BOARD_AUTHOR_MISMATCH)
        }

        board.modifyBoard(modifyBoardRequest.title, modifyBoardRequest.content)
    }
}