package org.example.firstkopring.domain.board.presentation

import org.example.firstkopring.domain.board.domain.Board
import org.example.firstkopring.domain.board.presentation.dto.request.addBoardRequest
import org.example.firstkopring.domain.board.sevice.DeleteBoardService
import org.example.firstkopring.domain.board.sevice.GetAllBoardService
import org.example.firstkopring.domain.board.sevice.GetBoardService
import org.example.firstkopring.domain.board.sevice.addBoardService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/boards")
class BoardController(
    private val addBoardService: addBoardService,
    private val getBoardService: GetBoardService,
    private val getAllBoardService: GetAllBoardService,
    private val deleteBoardService: DeleteBoardService
) {
    @PostMapping
    fun addBoard(@RequestBody addBoardRequest: addBoardRequest) {
        addBoardService.execute(addBoardRequest)
    }

    @GetMapping("/{id}")
    fun getBoard(@PathVariable id: Long) : Board = getBoardService.execute(id)

    @GetMapping
    fun getAllBoard() : List<Board> = getAllBoardService.execute()

    @DeleteMapping("/{id}")
    fun deleteBoard(@PathVariable id: Long) = deleteBoardService.execute(id)
}