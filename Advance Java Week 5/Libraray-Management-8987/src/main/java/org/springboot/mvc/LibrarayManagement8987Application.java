package org.springboot.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

// spring boot mvc services
@SpringBootApplication
@ComponentScan(basePackages = { "org.springboot.mvc" })
public class LibrarayManagement8987Application {

	public static void main(String[] args) {
		SpringApplication.run(LibrarayManagement8987Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
