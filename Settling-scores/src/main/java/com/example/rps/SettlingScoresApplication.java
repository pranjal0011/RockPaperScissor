package com.example.rps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.rps")
public class SettlingScoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(SettlingScoresApplication.class, args);
		
		System.out.println("Helloji");
	}

}
