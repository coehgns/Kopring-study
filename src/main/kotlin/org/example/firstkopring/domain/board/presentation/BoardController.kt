package org.example.firstkopring.domain.board.presentation

import org.example.firstkopring.domain.board.presentation.dto.request.BoardRequest
import org.example.firstkopring.domain.board.presentation.dto.request.ModifyBoardRequest
import org.example.firstkopring.domain.board.presentation.dto.response.BoardResponse
import org.example.firstkopring.domain.board.sevice.Board.*
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/boards")
class BoardController(
    private val addBoardService: AddBoardService,
    private val getBoardService: GetBoardService,
    private val getAllBoardService: GetAllBoardService,
    private val deleteBoardService: DeleteBoardService,
    private val modifyBoardService: ModifyBoardService
) {
    @PostMapping
    fun addBoard(@RequestBody boardRequest: BoardRequest) {
        addBoardService.execute(boardRequest)
    }

    @GetMapping("/{id}")
    fun getBoard(@PathVariable id: Long) : BoardResponse = getBoardService.execute(id)

    @GetMapping
    fun getAllBoard() : List<BoardResponse> = getAllBoardService.execute()

    @DeleteMapping("/{id}")
    fun deleteBoard(@PathVariable id: Long) = deleteBoardService.execute(id)

    @PatchMapping("/{id}")
    fun modifyBoard(@PathVariable id: Long, @RequestBody modifyBoardRequest: ModifyBoardRequest) {
        modifyBoardService.execute(id, modifyBoardRequest)
    }
}