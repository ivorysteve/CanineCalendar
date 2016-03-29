package com.stephengilbane.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stephengilbane.DogBreed;
import com.stephengilbane.repos.DogBreedRepository;

/**
 * REST controller for dog breeds.
 * @author stephengilbane
 *
 */
@RestController
@RequestMapping("/dogs/breeds")
public class DogBreedRestController 
{
	private final DogBreedRepository dogBreedRepository;
	
	/**
	 * Constructor
	 * @param breedRepository
	 */
	@Autowired
	DogBreedRestController(DogBreedRepository breedRepository) 
	{
		this.dogBreedRepository = breedRepository;
	}
	

	/**
	 * Create a new dog breed.
	 * @param input
	 * @return ResponseEntity
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody DogBreed input) 
	{
		// XXX Validate input: unique (case-insensitive) name.
	    
		DogBreed newBreed = new DogBreed(input.getName(), input.getBreedSize());
		DogBreed result = dogBreedRepository.save(newBreed);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(
				ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri());
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
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
	DogBreed updateBreed(@PathVariable Long breedId, @RequestBody DogBreed b) 
	{
		DogBreed oldBreed = this.dogBreedRepository.findOne(breedId);
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
