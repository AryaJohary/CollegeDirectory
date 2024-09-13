package com.aryajohary.collegedirectory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CollegedirectoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegedirectoryApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(){
		return runner -> createUsers();
	}

	private void createUsers() {
		
	}

}
