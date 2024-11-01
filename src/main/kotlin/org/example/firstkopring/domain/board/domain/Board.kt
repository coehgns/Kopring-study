package org.example.firstkopring.domain.board.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Board(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val Id: Long? = null,

    @Column(name = "title", nullable = false, unique = true)
    val title: String,

    @Column(name = "content", nullable = true)
    val content: String
)