package com.sid.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    @Bean
    DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp)
    {
        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
    }

    @Bean
    RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder)
    {
        return  routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/restcountries/**")
                        .filters(f ->
                                f.addRequestHeader("X-RapidAPI-Key", "0c5df1ad43mshe7cb02c43efb5c3p11ce56jsnac7a094737b6")
                                        .addRequestHeader("X-RapidAPI-Host", "country-list5.p.rapidapi.com")
                                        .rewritePath("/restcountries/(?<segment>)","/${segment}"))
                        .uri("https://country-list5.p.rapidapi.com")
                ).route(p -> p
                        .path("/forex/**")
                        .filters(f ->
                                f.addRequestHeader("X-RapidAPI-Key", "0c5df1ad43mshe7cb02c43efb5c3p11ce56jsnac7a094737b6")
                                        .addRequestHeader("X-RapidAPI-Host", "currency-conversion-and-exchange-rates.p.rapidapi.com")
                                        .rewritePath("/forex/(?<segment>)","/${segment}"))
                        .uri("https://currency-conversion-and-exchange-rates.p.rapidapi.com"))

                .build();

    }

}
