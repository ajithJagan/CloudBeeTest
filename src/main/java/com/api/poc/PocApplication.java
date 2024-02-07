package com.api.poc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
		System.out.println("Poc is running...");

		log.info("");
	}
}
