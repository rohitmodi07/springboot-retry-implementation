package com.practicaljava.retryinboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class RetryinbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetryinbootApplication.class, args);
	}

}
