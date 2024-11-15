package org.example.firstkopring.global.security.jwt

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class JwtFilter(
    private val jwtUtils: JwtUtils
): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authorizationHeader: String? = request.getHeader("Authorization")
            ?: return filterChain.doFilter(request, response)

        val token = authorizationHeader?.substring("Bearer ".length)
            ?: return filterChain.doFilter(request, response)

        if (jwtUtils.validation(token)) {
            val username = jwtUtils.parseUsername(token)
            val authentication: Authentication = jwtUtils.getAuthentication(username)
            SecurityContextHolder.getContext().authentication = authentication
        }

        filterChain.doFilter(request, response)
    }
}