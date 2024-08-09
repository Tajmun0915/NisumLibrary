package com.nisum.DiscoverRegistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoverRegistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoverRegistoryApplication.class, args);
	}

}
