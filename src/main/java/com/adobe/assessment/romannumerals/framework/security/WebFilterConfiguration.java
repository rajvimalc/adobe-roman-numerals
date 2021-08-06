package com.adobe.assessment.romannumerals.framework.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @author Vimalraj Chandra Sekaran (rajvimalc)
 * Email: rajvimalc@gmail.com
 * Created on: 8/5/2021 10:18 PM
 *
 * WebFilter Configuration class for mutating URIs with context path
 */
@Configuration
@Slf4j
public class WebFilterConfiguration {

    @Bean
    @ConditionalOnProperty("server.servlet.context-path")
    public WebFilter contextPathWebFilter(ServerProperties serverProperties) {

        final String contextPath = serverProperties.getServlet().getContextPath();
        log.info("Webflux base path is set to '{}'", contextPath);

        return (exchange, chain) -> filter(exchange, chain, contextPath);
    }

    /**
     * Mutate the incoming request with context path, except health check api
     *
     * @param contextPath Configured by application config 'server.servlet.context-path'
     */
    protected Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain, String contextPath) {

        final String requestPath = exchange.getRequest().getURI().getPath();

        if (requestPath.equals("/")) {
            return mutateContextPath(exchange, chain, "");

        } else if (requestPath.startsWith(contextPath + "/") || requestPath.equals(contextPath)) {
            return mutateContextPath(exchange, chain, contextPath);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    protected Mono<Void> mutateContextPath(ServerWebExchange exchange, WebFilterChain chain, String contextPath) {
        return chain.filter(
                exchange
                        .mutate()
                        .request(exchange.getRequest().mutate().contextPath(contextPath).build())
                        .build()
        );
    }

}
