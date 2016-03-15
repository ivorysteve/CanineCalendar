package com.stephengilbane;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stephengilbane.dto.DogDTO;
import com.stephengilbane.exception.DogOwnerNotFoundException;
import com.stephengilbane.exception.ItemNotFoundException;
import com.stephengilbane.repos.DogRepository;
import com.stephengilbane.validator.DogValidator;

/**
 * REST controller for dogs.
 * @author stephengilbane
 *
 */
@RestController
@RequestMapping("/dogs/dogs")
public class DogRestController 
{
    private final DogRepository dogRepository;
    
    private final Validator dogValidator = new DogValidator();
    
    private DogBusinessManager dogBusinessMgr;
    
    /**
     * Constructor
     * @param dogRepo DogRepository to use.
     * @param bizMgr DogBusinessManager to use.
     */
    @Autowired
    DogRestController(DogRepository dogRepo, DogBusinessManager bizMgr) 
    {
        this.dogRepository = dogRepo;
        this.dogBusinessMgr = bizMgr;
    }
    

    /**
     * Create a new dog.
     * @param dog Dog attributes.
     * @return ResponseEntity
     * 
     */
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody @NotNull DogDTO dog) 
    {

        dogValidator.validate(dog, null);

        Dog newDog = dogBusinessMgr.convertDogDtoToDogEntity(dog);
        Dog result = dogRepository.save(newDog);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri());
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }
    
    /**
     * Get a Dog object.
     * @param dogId Primary Key
     * @return
     */
    @RequestMapping(value = "/{dogId}", method = RequestMethod.GET)
    Dog readDog(@PathVariable Long dogId) 
    {
        Dog d = this.dogRepository.findOne(dogId);
        if (d == null)
        {
            throw new ItemNotFoundException("dog", dogId);
        }
        return d;
    }
    
    /**
     * Update a Dog  object.
     * @param dogId Primary Key
     * @return Updated object.
     */
    @RequestMapping(value = "/{dogId}", method = RequestMethod.PUT)
    DogDTO updateDog(@PathVariable Long dogId, @RequestBody Dog d) 
    {
        /**
        DogBreed oldBreed = this.dogBreedRepository.findOne(breedId);
        oldBreed.setName(b.getName());
        oldBreed.setBreedType(b.getBreedSize());
        this.dogBreedRepository.save(oldBreed);
        return oldBreed;
        **/
        return new DogDTO();
        
    }
    
    /**
     * Delete a Dog object.
     * @param dogId Primary Key
     * @return
     */
    @RequestMapping(value = "/{dogId}", method = RequestMethod.DELETE)
    void deleteDog(@PathVariable @NotNull Long dogId) 
    {
        Dog d = this.dogRepository.findOne(dogId);
        if (d == null)
        {
            throw new ItemNotFoundException("dog", dogId);
        }
        this.dogRepository.delete(d);
    }

}
