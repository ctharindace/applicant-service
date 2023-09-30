package com.chethiya.applicant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.chethiya.application.controllers", "com.chethiya.application.services" })
//@EnableJpaRepositories(basePackages = { "com.chethiya.application.dao.repositories" })
//@EntityScan(basePackages = "com.chethiya.application.model")
public class ApplicantService {

	public static void main(String[] args) {
		SpringApplication.run(ApplicantService.class, args);
	}

}
