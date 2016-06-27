package com.stephengilbane.controller;

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
import com.stephengilbane.dto.VisitDTO;
import com.stephengilbane.entity.VisitDog;
import com.stephengilbane.entity.Visit;
import com.stephengilbane.exception.ItemNotFoundException;
import com.stephengilbane.service.VisitBusinessService;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

@Api(
        value = "Dog Visits",
        tags = { "DogVisit" }
        )
@RestController
@RequestMapping("/caninescheduler/visits")
public class VisitController
{
    private final VisitBusinessService visitService;
    
    /**
     * Constructor
     * @param vs Visit service to use.
     */
    @Autowired
    public VisitController(VisitBusinessService vs)
    {
        visitService = vs;
    }
    
    /**
     * Create a new Visit instance.
     * @param breed Breed attributes.
     * @return ResponseEntity specifying URI for new breed.
     */
    @SuppressWarnings("deprecation")
    @ApiOperation(
            nickname = "NewVisit",
            value = "Create a new Visit object.",
            notes = "Create a new Visit object.",
            response = DogBreed.class,
            responseHeaders = { @ResponseHeader( ) }
    )
    @RequestMapping(method = RequestMethod.POST)
    @ApiResponses(value = { 
            @ApiResponse(code = 400, message = "Invalid xxx name supplied") } 
    )
    public ResponseEntity<VisitDTO> createVisit (
            @ApiParam( value = "New Visit attributes.", required = true )
            @RequestBody @NonNull VisitDTO visitDto) 
    {

        VisitDTO newVisit = this.visitService.createVisit(visitDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newVisit.getId()).toUri());
        return new ResponseEntity<>(newVisit, httpHeaders, HttpStatus.CREATED);
    }
    /**
     * Get a Visit object.
     * @param visitId Primary Key
     * @return VisitDTO
     * @throws ItemNotFoundException if visit does not exist.
     */
    @RequestMapping(value = "/{visitId}", method = RequestMethod.GET)
    public VisitDTO getVisit(@PathVariable Long visitId) 
    {
        VisitDTO v = this.visitService.getVisit(visitId);
        if (v == null)
        {
            throw new ItemNotFoundException("VisitClient", visitId);
        }
        
        return v;
    }
    /**
     * Add a Dog to a Visit.
     * @param visitId Visit Primary Key
     * @param dogId Dog primary key
     * @return VisitDog entry created.
     * @throws ItemNotFoundException if Visit or Dog does not exist.
     */
    @RequestMapping(value = "/{visitId}/{dogId}", method = RequestMethod.PUT)
    public VisitDog addDogToVisit(@PathVariable Long visitId, @PathVariable Long dogId) 
    {
        VisitDog vd = this.visitService.addDogToVisit(visitId, dogId);
        return vd;
    }
    
    /**
     * Remove a Dog from a Visit.
     * @param visitId Visit Primary Key
     * @param dogId Dog primary key
     * @return true on success, false on failure.
     * @throws ItemNotFoundException if visit does not exist.
     */
    @RequestMapping(value = "/{visitId}/{dogId}", method = RequestMethod.DELETE)
    public boolean deleteDogFromVisit(@PathVariable Long visitId, @PathVariable Long dogId) 
    {
        boolean ok = this.visitService.removeDogFromVisit(visitId, dogId);

        return ok;
    }
}
