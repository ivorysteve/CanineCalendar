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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stephengilbane.DogBreed;
import com.stephengilbane.repos.DogBreedRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * REST controller for dog breeds.
 * @author stephengilbane
 *
 */
@Api(
        tags = { "breed" },
        produces = "application/json")
@RestController
@RequestMapping("/caninescheduler/breeds")
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
    @ApiOperation(
            value = "Create a new DogBreed object.",
            notes = "Create a new DogBreed object. Name must be unique.",
            response = DogBreed.class
    )
	@RequestMapping(method = RequestMethod.POST)
    @ApiResponses(value = { 
            @ApiResponse(code = 400, message = "Invalid breed name supplied") } 
    )
	ResponseEntity<DogBreed> addDogBreed(
	        @ApiParam( value = "New DogBreed attributes.", required = true )
	        @RequestBody DogBreed input) 
	{
		// XXX Validate input: unique (case-insensitive) name.
	    
		DogBreed newBreed = new DogBreed(input.getName(), input.getBreedSize());
		DogBreed resultBreed = dogBreedRepository.save(newBreed);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(
				ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resultBreed.getId()).toUri());
		return new ResponseEntity<>(resultBreed, httpHeaders, HttpStatus.CREATED);
	}
	
	/**
	 * Get a Dog Breed object.
	 * @param breedId Primary Key
	 * @return
	 */
    @ApiOperation(
            value = "Get a DogBreed by ID.",
            response = DogBreed.class
    )
	@RequestMapping(value = "/{breedId}", method = RequestMethod.GET)
    @ResponseBody
	DogBreed getDogBreed(@PathVariable Long breedId) 
	{
		return this.dogBreedRepository.findOne(breedId);
	}
	
	/**
	 * Update a Dog Breed object.
	 * @param breedId Primary Key
	 * @return Updated object.
	 */
	@ApiOperation(
	        value = "Update a DogBreed instance.",
	        notes = "Update DogBreed indicated by ID. Name must be unique.",
	        response = DogBreed.class
	)
	@RequestMapping(value = "/{breedId}", method = RequestMethod.PUT)
    @ResponseBody
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
	@ApiOperation(
	        value = "Get a list of all DogBreed objects recognized in the system.",
	        response = DogBreed.class,
	        responseContainer = "List"
	)
	@RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
	List<DogBreed> getAllDogBreeds() 
	{
		return this.dogBreedRepository.findAll();
	}
}
