package org.example.firstkopring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class FirstKopringApplication

fun main(args: Array<String>) {
    runApplication<FirstKopringApplication>(*args)
}
