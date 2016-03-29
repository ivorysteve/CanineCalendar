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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


import com.stephengilbane.dto.DogDTO;
import com.stephengilbane.exception.ItemNotFoundException;
import com.stephengilbane.service.DogBusinessService;
import com.stephengilbane.validator.DogValidator;

/**
 * REST controller for dogs.
 * @author stephengilbane
 *
 */
@RestController
@Api(value = "/dogs/dogs"
)
@RequestMapping("/dogs/dogs")
public class DogRestController 
{
    private final Validator dogValidator = new DogValidator();
    
    private DogBusinessService dogBusinessService;
    
    /**
     * Constructor
     * @param dogRepo DogRepository to use.
     * @param bizMgr DogBusinessManager to use.
     */
    @Autowired
    DogRestController(DogBusinessService bizMgr) 
    {
        dogBusinessService = bizMgr;
    }
    

    /**
     * Create a new dog.
     * @param dog Dog attributes.
     * @return ResponseEntity
     * 
     */
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody @NotNull DogDTO dogDto) 
    {
        dogValidator.validate(dogDto, null);

        Dog newDog = dogBusinessService.convertDogDtoToDogEntity(dogDto);
        Dog result = dogBusinessService.saveDog(newDog);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri());
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }
    
    /**
     * Get a Dog object.
     * @param dogId Primary Key
     * @return DogDTO
     */
    @RequestMapping(value = "/{dogId}", method = RequestMethod.GET)
    @ApiOperation(value = "Find dog by ID",
       notes = "Returns a dog given its primary key",
       response = DogDTO.class
    )
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid Dog ID"),
        @ApiResponse(code = 404, message = "Dog not found")
    })
    DogDTO readDog(@PathVariable @NotNull Long dogId) 
    {
        Dog d = dogBusinessService.getDog(dogId);
        if (d == null)
        {
            throw new ItemNotFoundException("dog", dogId);
        }
        return new DogDTO(d);
    }
    
    /**
     * Update a Dog  object.
     * @param dogId Primary Key
     * @param dogDto Dog with updated attributes
     * @return Updated object.
     * @throws ItemNotFoundException If dogId is invalid.
     */
    @RequestMapping(value = "/{dogId}", method = RequestMethod.PUT)
    DogDTO updateDog(@PathVariable @NotNull Long dogId, @RequestBody DogDTO dogDto) 
    {
        Dog oldDog = dogBusinessService.getDog(dogId);
        if (oldDog == null)
        {
            throw new ItemNotFoundException("dog", dogId);
        }
        dogValidator.validate(dogDto, null);
        oldDog = dogBusinessService.updateDog(oldDog, dogDto);
        
        return new DogDTO(oldDog);
    }
    
    /**
     * Delete a Dog object.
     * @param dogId Primary Key
     * @throws ItemNotFoundException If dogId is invalid.
     */
    @RequestMapping(value = "/{dogId}", method = RequestMethod.DELETE)
    void deleteDog(@PathVariable @NotNull Long dogId) 
    {
        Dog d = dogBusinessService.getDog(dogId);
        if (d == null)
        {
            throw new ItemNotFoundException("dog", dogId);
        }
        dogBusinessService.deleteDog(d);
    }

}
