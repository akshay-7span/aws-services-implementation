package com.aws.learning;

import com.aws.learning.service.Publisher;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(Publisher publisher) {
		return args -> {
			Thread.sleep(3000);
			for (int i = 0; i < 1; i++) {
				publisher.publishMessage(String.valueOf("Hello" +i));
			}
		};
	}

}
