package com.stephengilbane;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class CanineCalendarApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(CanineCalendarApplication.class, args);
	}
}

@RestController
@RequestMapping("/dogs/breeds")
class BreedsRestController 
{
	private final DogBreedRepository dogBreedRepository;
	
	/**
	 * Constructor
	 * @param breedRepository
	 */
	@Autowired
	BreedsRestController(DogBreedRepository breedRepository) 
	{
		this.dogBreedRepository = breedRepository;
	}
	
	/**
	 * Get a Dog Breed object.
	 * @param breedId Primary Key
	 * @return
	 */
	@RequestMapping(value = "/{breedId}", method = RequestMethod.GET)
	DogBreed readBreed(@PathVariable Long breedId) 
	{
		return this.dogBreedRepository.findOne(breedId);
	}
	
	/**
	 * Update a Dog Breed object.
	 * @param breedId Primary Key
	 * @return Updated object.
	 */
	@RequestMapping(value = "/{breedId}", method = RequestMethod.PUT)
	DogBreed updateBreed(@PathVariable Long breedId, DogBreed b) 
	{
		DogBreed oldBreed = this.dogBreedRepository.getOne(breedId);
		oldBreed.setName(b.getName());
		oldBreed.setBreedType(b.getBreedSize());
		this.dogBreedRepository.save(oldBreed);
		return oldBreed;
	}
	
	/**
	 * Get all Dog Breeds.
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	List<DogBreed> readAllBreeds() 
	{
		return this.dogBreedRepository.findAll();
	}
}