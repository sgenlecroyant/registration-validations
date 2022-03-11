package com.registration.validationrules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApplicationRegistrationMetadataResponseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationRegistrationMetadataResponseApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		String pattern = "(^[a-zA-Z0-9-_.']+@[a-zA-Z0-9-_.']+.[a-zA-Z]+$)|(^[a-zA-Z0-9-_.#$&+']{3,320}$)";
		Pattern compiledPattern = Pattern.compile(pattern);
		Matcher patternMatcher = compiledPattern.matcher("myemail");
		boolean matches = patternMatcher.matches();
		System.out.println("email validated: " + matches);
	}

}
