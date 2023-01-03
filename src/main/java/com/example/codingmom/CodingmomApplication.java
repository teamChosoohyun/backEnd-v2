package com.example.codingmom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CodingmomApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingmomApplication.class, args);
	}

}
