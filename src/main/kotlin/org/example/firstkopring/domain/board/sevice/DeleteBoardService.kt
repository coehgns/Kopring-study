package org.example.firstkopring.domain.board.sevice

import org.example.firstkopring.domain.board.domain.repository.BoardRepository
import org.springframework.stereotype.Service

@Service
class DeleteBoardService(
    private val boardRepository: BoardRepository
) {
    fun execute(id: Long) = boardRepository.deleteById(id)
}