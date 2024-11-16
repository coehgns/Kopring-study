package org.example.firstkopring.domain.board.presentation.dto.response

import org.example.firstkopring.domain.board.domain.Board
import org.example.firstkopring.domain.user.domain.User

data class BoardResponse(
    val user: User?,
    val title: String,
    val content: String
) {
    companion object {
        fun fromBoard(board: Board): BoardResponse {
            return BoardResponse(
                user = board.user,
                title = board.title,
                content = board.content
            )
        }
    }
}
