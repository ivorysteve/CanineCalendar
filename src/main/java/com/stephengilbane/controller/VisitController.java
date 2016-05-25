package com.stephengilbane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stephengilbane.dto.VisitDTO;
import com.stephengilbane.entity.VisitDog;
import com.stephengilbane.exception.ItemNotFoundException;
import com.stephengilbane.service.VisitBusinessService;

import io.swagger.annotations.Api;

@Api(
        value = "Dog Visit events",
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
