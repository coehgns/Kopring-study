package org.example.firstkopring.domain.board.sevice

import org.example.firstkopring.domain.board.domain.Board
import org.example.firstkopring.domain.board.presentation.dto.request.AddBoardRequest
import org.example.firstkopring.domain.board.domain.repository.BoardRepository
import org.springframework.stereotype.Service

@Service
class AddBoardService(
    private val boardRepository: BoardRepository
) {
    fun execute(addBoardRequest: AddBoardRequest) {
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