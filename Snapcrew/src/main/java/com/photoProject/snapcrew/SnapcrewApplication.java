package com.photoProject.snapcrew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = {"com.photoProject.snapcrew.entity", "com.photoProject.snapcrew"})
public class SnapcrewApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnapcrewApplication.class, args);
	}

}
