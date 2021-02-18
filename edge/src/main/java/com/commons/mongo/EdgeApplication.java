package com.commons.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EdgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgeApplication.class, args);
	}


	@Bean
	@LoadBalanced public RestTemplate restTemplate() { 
		return new RestTemplate();
	}

	@Bean
	@LoadBalanced public WebClient.Builder loadBalancedWebClientBuilder() {
		return WebClient.builder(); 
	}



	@Bean public RouteLocator routeLocator(RouteLocatorBuilder builder) { 
		return builder.routes()
				// SAMPLE-APP-SERVICE
				.route(r -> r.path("/person/**").uri("lb://PERSON-SERVICE"))
				.route(r -> r.path("/email/**").uri("lb://EMAIL-SERVICE"))
				.route(r -> r.path("/password/**").uri("lb://PASSWORD-SERVICE"))
				.build();

	}
}
