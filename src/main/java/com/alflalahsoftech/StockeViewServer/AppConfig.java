package com.alflalahsoftech.StockeViewServer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
}
