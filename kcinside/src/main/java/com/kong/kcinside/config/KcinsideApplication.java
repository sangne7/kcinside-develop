package com.kong.kcinside.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KcinsideApplication {

	public static void main(String[] args) {
		SpringApplication.run(KcinsideApplication.class, args);
		# pull_test
		System.out.println("run server...");
	}

}
