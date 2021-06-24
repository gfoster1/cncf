/*
 * Copyright (c) 2021.
 * This file is the property of Whitespace and may not be used, duplicated, or shared.
 */

package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.csrf().disable()
                .authorizeExchange()
                .pathMatchers(HttpMethod.POST, "/books").hasRole("ADMIN")
                .pathMatchers(HttpMethod.POST, "/blogs").hasRole("ADMIN")
                .pathMatchers("/**").permitAll()
                .and()
                .httpBasic();
        return http.build();
    }
}
