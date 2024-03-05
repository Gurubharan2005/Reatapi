package com.example.q2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition()
public class Q2Application {

	public static void main(String[] args) {
		SpringApplication.run(Q2Application.class, args);
	}

}
