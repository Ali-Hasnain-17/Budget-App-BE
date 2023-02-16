package com.pinchpenny.pinchpenny.filters

import com.pinchpenny.pinchpenny.services.MyUserDetailsService
import com.pinchpenny.pinchpenny.utils.JwtUtil
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtFilter: OncePerRequestFilter() {
    @Autowired private lateinit var jwtUtil: JwtUtil
    @Autowired private lateinit var userDetailsService: MyUserDetailsService

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authHeader: String? = request.getHeader("Authorization")
        var jwt: String? = null
        var email: String? = null
        if (authHeader != null && authHeader.startsWith("Bearer")) {
            jwt = authHeader.substring(7)
            email = jwtUtil.extractEmail(jwt)
        }

        if (email != null && SecurityContextHolder.getContext().authentication == null) {
            val userDetails: UserDetails = userDetailsService.loadUserByUsername(email)
            if (jwtUtil.validateToken(jwt, userDetails)) {
                val authToken: UsernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.authorities
                )
                authToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = authToken
            }
        }
        filterChain.doFilter(request, response)
    }
}