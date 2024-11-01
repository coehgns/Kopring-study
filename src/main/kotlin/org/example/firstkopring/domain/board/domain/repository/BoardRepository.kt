package org.example.firstkopring.domain.board.domain.repository

import org.example.firstkopring.domain.board.domain.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository : JpaRepository<Board, Long> {
}