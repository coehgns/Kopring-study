package org.example.firstkopring.global.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain

class FilterConfig(
    private val jwtProvider: JwtProvider,
    private val objectMapper: ObjectMapper
): SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(httpSecurity: HttpSecurity?) {
        val jwtTokenFilter: JwtFilter = JwtFilter(jwtProvider)
    }
}