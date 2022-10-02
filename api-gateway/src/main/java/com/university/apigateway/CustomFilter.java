package com.university.apigateway;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class CustomFilter implements GlobalFilter {

    Logger logger= LoggerFactory.getLogger(CustomFilter.class);

    //for all requests
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request=exchange.getRequest();
        //you can perform auth,logging etc.
        logger.info("Client Id: {}",request.getHeaders().getFirst("ClientId"));

        return chain.filter(exchange).then(Mono.fromRunnable(()->{

            //post Filter
            ServerHttpResponse response=exchange.getResponse();

            logger.info("Response Status: {}",response.getStatusCode());
        }));
    }
}
