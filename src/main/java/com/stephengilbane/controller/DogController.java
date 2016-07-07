package com.stephengilbane.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Context;

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

import com.stephengilbane.FileUtils;
import com.stephengilbane.dto.DogDTO;
import com.stephengilbane.entity.Dog;
import com.stephengilbane.exception.ItemNotFoundException;
import com.stephengilbane.service.DogBusinessService;
import com.stephengilbane.validator.DogValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * REST controller for dogs.
 * @author stephengilbane
 *
 */
@RestController
@Api(
        value = "Dogs",
        tags = { "Dog operations" }
)
@RequestMapping("/caninescheduler/dogs")
public class DogController 
{
    private final Validator dogValidator = new DogValidator();
    
    private DogBusinessService dogBusinessService;
    
    /**
     * Constructor
     * @param dogRepo DogRepository to use.
     * @param bizMgr DogBusinessManager to use.
     */
    @Autowired
    DogController(DogBusinessService bizMgr) 
    {
        dogBusinessService = bizMgr;
    }
    

    /**
     * Create a new dog.
     * @param dog Dog attributes.
     * @return ResponseEntity
     * 
     */
    @ApiOperation(
            value = "Create a new Dog.",
            notes = "Create a new Dog object.",
            response = Dog.class
    )
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> createDog(
            @RequestBody @NotNull 
            @ApiParam( value = "New Dog object that needs to be added to the store.", required = true )
            DogDTO dogDto) 
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
     * Get all Dog objects.
     * @param dogId Primary Key
     * @return List<DogDTO>
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Find all dogs.",
       notes = "Returns list of dogs",
       responseContainer = "List",
       response = DogDTO.class
    )
    @ApiResponses(value = { 
    })
    List<DogDTO> getAllDogs() 
    {
        List<DogDTO> dogs = dogBusinessService.getAllDogs();

        return dogs;
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
    DogDTO getDog(@PathVariable @NotNull Long dogId) 
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
    
    /**
     * Get thumb image for a dog.
     * XXX: ADD COLUMN IN T_DOG.
     * @param dogId
     * @return
     */
    @ApiOperation(
            value = "Get a Dog's picture.",
            notes = "Get a dog's standard picture."
    )
    @RequestMapping(value = "/{dogId}/image", method = RequestMethod.GET)
    ResponseEntity<?> getDogPicture(@PathVariable @NotNull Long dogId) 
    {
        Dog dog = dogBusinessService.getDog(dogId);
        if (dog == null)
        {
            throw new ItemNotFoundException("Dog #", dogId);
        }
        String imageName = dog.getThumbImageFilename();
        if (imageName == null)
        {
            throw new ItemNotFoundException("Image for Dog #", dogId);
        }
        byte[] img = null;
        try
        {
            img = dogBusinessService.getImageBytes(imageName);
        }
        catch (IOException ex)
        {
            throw new ItemNotFoundException("image", dogId);
        }
        String fileType = "octet/binary";
        try {
            fileType = FileUtils.toImageType(imageName);
        }
        catch (Exception ex)
        {
            fileType = "octet/binary";
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentLength(img.length);
        httpHeaders.setContentDispositionFormData("inline", imageName);
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, fileType);

        return new ResponseEntity<>(img, httpHeaders, HttpStatus.OK);
    }

}
