package org.example.firstkopring.domain.user.domain

import jakarta.persistence.*
import org.example.firstkopring.domain.board.domain.Board
import org.example.firstkopring.domain.user.domain.enums.Authority

@Entity
@Table(name = "user_tbl")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    val Id: Long,

    @Column(name = "username", nullable = false, unique = true)
    var username: String,

    @Column(name = "password", nullable = false, unique = true)
    var password: String,

    @OneToMany(mappedBy = "user")
    val boardList: List<Board> = ArrayList(),

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    var authority: Authority
)