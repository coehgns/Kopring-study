package org.example.firstkopring.domain.board.sevice

import org.example.firstkopring.domain.board.domain.Board
import org.example.firstkopring.domain.board.presentation.dto.request.addBoardRequest
import org.example.firstkopring.domain.board.domain.repository.BoardRepository
import org.springframework.stereotype.Service

@Service
class addBoardService(
    private val boardRepository: BoardRepository
) {
    fun execute(addBoardRequest: addBoardRequest) {
        boardRepository.save(
            addBoardRequest.run {
                Board(
                    title = title,
                    content = content
                )
            }
        )
    }
}