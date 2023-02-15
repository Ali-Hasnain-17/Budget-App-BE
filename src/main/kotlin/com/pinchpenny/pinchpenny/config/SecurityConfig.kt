package com.pinchpenny.pinchpenny.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
@EnableWebSecurity
@Configuration
class SecurityConfig(){
    @Throws(Exception::class)
    fun configure(httpSecurity: HttpSecurity) {
        httpSecurity
            .cors()
            .and()
                .csrf()
            .disable()
//                .authorizeRequests()
//                .antMatchers(*anonymousUrls)
            .authorizeHttpRequests()
            .requestMatchers("*")
            .permitAll()
            //                .anyRequest()
//                .authenticated()
//                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }
}