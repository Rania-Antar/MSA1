package com.esprit.microservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CandidateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidateApplication.class, args);
	}
	
	@Bean
	   ApplicationRunner init(CandidateRepository repository){
		return args -> {
			Stream.of("Rania" , "Mariem" , "Sarah").forEach(nom -> {
				repository.save(new Candidat(nom));
			});
			repository.findAll().forEach(System.out::println);
		};
	}

}
