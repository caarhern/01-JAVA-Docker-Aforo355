package com.aforo255.historical.reactive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.aforo255.historical.reactive.handler.HistoricalHandler;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
@Configuration
public class RouterFunctionConfig {
	
	@Bean
	public RouterFunction<ServerResponse> routes(HistoricalHandler handler){
		
		return route(GET("/api/v2/historical").or(GET("/api/v3/historical")), handler::listar)
				.andRoute(GET("/api/v2/historical/{id}"), handler::ver);
	}
}
