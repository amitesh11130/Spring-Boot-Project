package com.springbootapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
public class OrderOnboardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderOnboardingApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder
				.setReadTimeout(Duration.ofSeconds(5))
				.build();
	}

	@Bean
	public RestClient getRestClient(){
		var factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(2000);
		//factory.setReadTimeout(2000);
		return RestClient.builder().requestFactory(factory).build();
	}

}
