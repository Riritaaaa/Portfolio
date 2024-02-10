package com.cp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan (basePackages = {"com.cp.entity", "com.cp.controller", "com.cp.repository", "com.cp.bicycleService", "com.cp.service"})
public class BicycleRetalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BicycleRetalApplication.class, args);
	}

}
