package org.example.firstkopring.domain.board.sevice.Board

import org.example.firstkopring.domain.board.domain.repository.BoardRepository
import org.example.firstkopring.domain.board.presentation.dto.response.BoardResponse
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class GetAllBoardService(
    private val boardRepository: BoardRepository
) {
    fun execute() : List<BoardResponse> {
        return boardRepository.findAll()
            .stream()
            .map(BoardResponse::fromBoard)
            .collect(Collectors.toList())
    }
}