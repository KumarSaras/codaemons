package com.codaemons.be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CoDaemonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoDaemonsApplication.class, args);
	}

}
