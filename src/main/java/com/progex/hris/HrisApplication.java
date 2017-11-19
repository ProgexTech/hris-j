package com.progex.hris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.progex.hris")
public class HrisApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrisApplication.class, args);
	}
}
