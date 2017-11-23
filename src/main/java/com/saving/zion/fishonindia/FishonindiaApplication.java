package com.saving.zion.fishonindia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class FishonindiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FishonindiaApplication.class, args);
	}
}
