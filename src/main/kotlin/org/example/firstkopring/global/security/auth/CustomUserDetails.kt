package org.example.firstkopring.global.security.auth

import org.springframework.boot.autoconfigure.security.SecurityProperties.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(
    val user: User
): UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> = AuthorityUtils.createAuthorityList()

    override fun getUsername(): String = user.name

    override fun getPassword(): String = user.password

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}