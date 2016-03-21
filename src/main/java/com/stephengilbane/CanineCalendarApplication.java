package com.stephengilbane;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
