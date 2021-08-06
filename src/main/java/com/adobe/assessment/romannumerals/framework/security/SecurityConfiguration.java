package com.adobe.assessment.romannumerals.framework.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author Vimalraj Chandra Sekaran (rajvimalc)
 * Email: rajvimalc@gmail.com
 * Created on: 8/5/2021 10:18 PM
 *
 * Security Configuration class for handling permitted uri paths
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {

    /**
     * Configure to allow all Apis starting with context path configured and health check api
     *
     * @param http Application's Server Http Security
     * @param contextPath Configured by application config 'server.servlet.context-path'
     */
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(
            ServerHttpSecurity http, @Value("${server.servlet.context-path}") String contextPath) {

        // @formatter:off
        http
                .csrf().disable()

                .authorizeExchange()
                    .pathMatchers("/", contextPath + "/**").permitAll()
                    .anyExchange().denyAll()

                .and().httpBasic()
        ;
        // @formatter:on

        return http.build();
    }
}
