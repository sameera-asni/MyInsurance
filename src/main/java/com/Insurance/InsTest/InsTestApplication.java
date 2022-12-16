package com.Insurance.InsTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Configuration
@EnableAutoConfiguration
@Component
@EnableScheduling
@SpringBootApplication
public class InsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsTestApplication.class, args);
	}

}
