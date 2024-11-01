package org.example.firstkopring.domain.board.sevice

import org.example.firstkopring.domain.board.domain.Board
import org.example.firstkopring.domain.board.domain.repository.BoardRepository
import org.springframework.stereotype.Service

@Service
class GetAllBoardService(
    private val boardRepository: BoardRepository
) {
    fun execute() : List<Board> = boardRepository.findAll()
}