package com.stephengilbane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.stephengilbane.repos.DogBreedRepository;

/**
 * Main dog calendar application.  
 * Called by Spring Boot.
 * 
 * @author stephengilbane
 *
 */
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class CanineCalendarApplication 
{
	
	private static final Logger log = LoggerFactory.getLogger(CanineCalendarApplication.class);

	/**
	 * Main method called by Spring Boot.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		SpringApplication.run(CanineCalendarApplication.class, args);
	}
	
	/**
	 * Example CommandLinRunner to run during startup.
	 * @param repository
	 * @return
	 */
	@Bean
	public CommandLineRunner demo(DogBreedRepository repository) 
	{
		return (args) -> {
			log.info("Starting with breeds:");
			for (DogBreed db : repository.findAll()) 
			{
				log.info('\t' + db.toString());
			}
		};
	}
}
