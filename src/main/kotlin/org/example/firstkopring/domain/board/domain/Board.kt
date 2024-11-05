package org.example.firstkopring.domain.board.domain

import jakarta.persistence.*
import org.example.firstkopring.domain.user.domain.User

@Entity
class Board(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val Id: Long? = null,

    @Column(name = "title", nullable = false, unique = true)
    val title: String,

    @Column(name = "content", nullable = true)
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User? = null
) {
    fun modifyBoard(title: String, content: String) {
        Board(
            title = title,
            content = content
        )
    }
}