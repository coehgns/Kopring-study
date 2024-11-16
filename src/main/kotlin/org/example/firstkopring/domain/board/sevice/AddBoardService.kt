package org.example.firstkopring.domain.board.sevice

import org.example.firstkopring.domain.board.domain.Board
import org.example.firstkopring.domain.board.domain.repository.BoardRepository
import org.example.firstkopring.domain.board.presentation.dto.request.BoardRequest
import org.example.firstkopring.domain.user.domain.User
import org.example.firstkopring.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class AddBoardService(
    private val boardRepository: BoardRepository,
    private val userFacade: UserFacade
) {
    fun execute(boardRequest: BoardRequest) {
        val currentUser: User = userFacade.currentUser()

        boardRepository.save(
            boardRequest.run {
                Board(
                    title = title,
                    content = content,
                    user = currentUser
                )
            }
        )
    }
}