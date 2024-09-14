package com.aryajohary.collegedirectory;

import com.aryajohary.collegedirectory.schemas.Department;
import com.aryajohary.collegedirectory.schemas.Role;
import com.aryajohary.collegedirectory.schemas.StudentProfile;
import com.aryajohary.collegedirectory.services.DepartmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CollegedirectoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegedirectoryApplication.class, args);
	}

}
