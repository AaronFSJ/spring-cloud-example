package com.aaron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientBusRefreshApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientBusRefreshApplication.class, args);
	}
}
