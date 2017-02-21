package com.iqmsoft.butterfaces.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.iqmsoft.butterfaces.boot.mongo.Admin;
import com.iqmsoft.butterfaces.boot.mongo.AdminRepository;

@Configuration
@EnableMongoRepositories(basePackages = "com.iqmsoft.butterfaces.boot.mongo")
@ComponentScan(basePackages = "com.iqmsoft.butterfaces.boot")
@EnableAutoConfiguration
@SpringBootApplication
public class ButterFacesExampleApplication implements CommandLineRunner {

	@Autowired
	private AdminRepository adminRepository;

	public static void main(String[] args) {
		SpringApplication.run(ButterFacesExampleApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		if (adminRepository.count() == 0) {
			Admin e = new Admin("admin", "password");
			adminRepository.save(e);
		}

	}

}
