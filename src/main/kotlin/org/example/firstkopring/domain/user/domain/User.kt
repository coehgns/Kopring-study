package org.example.firstkopring.domain.user.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.example.firstkopring.domain.board.domain.Board

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val Id: Long? = null,

    @Column(name = "name", nullable = false)
    val name: String,

    @OneToMany(mappedBy = "user")
    val boardList: List<Board>? = null
)