package com.alflalahsoftech.StockeViewServer;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/serv")
public class StockeViewServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockeViewServerApplication.class, args);
	}
	@Autowired
	public RestTemplate restTemplate;
	
	@GetMapping("/topic")
	public List<String> getUserNames(){

		ResponseEntity<List<String>> resp = restTemplate.exchange("http://localhost:8002/dbSrvc/topicName",HttpMethod.GET,null, new ParameterizedTypeReference<List<String>>() {
		});
		
		 List<String> uList	 = resp.getBody();
		 System.out.println("===========================topic Name list: " + uList);
		return uList;
	}
	

}
