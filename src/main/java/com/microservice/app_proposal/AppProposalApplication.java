package com.microservice.app_proposal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppProposalApplication {
	public static void main(String[] args) {SpringApplication.run(AppProposalApplication.class, args);}

}
