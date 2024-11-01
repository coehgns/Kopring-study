package org.example.firstkopring.domain.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val Id: Long? = null,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "age", nullable = false)
    val age: Int
)