package com.stephengilbane.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stephengilbane.dto.VisitDTO;
import com.stephengilbane.entity.Dog;
import com.stephengilbane.entity.Visit;
import com.stephengilbane.entity.VisitDog;
import com.stephengilbane.exception.InvalidInputException;
import com.stephengilbane.repos.DogRepository;
import com.stephengilbane.repos.VisitDogRepository;
import com.stephengilbane.repos.VisitRepository;

/**
 * Business service for managing visit instances.
 * @author stephengilbane
 *
 */
@Component
public class VisitBusinessService
{
    private final VisitRepository visitRepo;
    private final VisitDogRepository visitDogRelRepo;
    private final DogRepository dogRepo;
    
    private final Logger log = Logger.getLogger(VisitBusinessService.class.getName());
    
    @Autowired
    public VisitBusinessService(VisitRepository vRepo, VisitDogRepository vDogRepo, DogRepository dRepo)
    {
        this.visitRepo = vRepo;
        this.visitDogRelRepo = vDogRepo;
        this.dogRepo = dRepo;
    }

    
    /**
     * Get a VisitDTO given its ID.
     * @param visitId Primary key for visit. 
     */
    public VisitDTO getVisit(Long visitId)
    {
        Visit v = visitRepo.findOne(visitId);
        if (v != null)
        {
            VisitDTO dto = new VisitDTO(v);
            List<Dog> dogs = getDogsOnVisit(visitId);
            dto.setDogs(dogs);
            return dto;
        }
        return null;
    }
    
    /**
     * Find all VisitDog entries given a Visit ID.
     * @param visitID
     * @return List of VisitDog relations.
     */
    public List<Dog> getDogsOnVisit(Long visitID)
    {
        List<VisitDog> list = visitDogRelRepo.findByVisitID(visitID);
        List<Dog> dogs = new ArrayList<Dog>();
        for (VisitDog vdRel: list)
        {
            Dog dog = this.dogRepo.findOne(vdRel.getDogID());
            if (dog == null)
            {
                log.warning("Invalid dogVisitRel: " + vdRel.getDogID() + " => " + vdRel.getVisitID());
            }
            else
            {
                dogs.add(dog);
            }
        }
        
        return dogs;
    }
    
    /**
     * Add a Dog to a Visit.
     * @param visitID
     * @param dogID
     * @return the visit-dog entry that was created.
     * @throws InvalidInputException if input values are invalid.
     */
    public VisitDog addDogToVisit(Long visitID, Long dogID)
    {
        VisitDTO v = getVisit(visitID);
        if (v == null)
        {
            throw new InvalidInputException("Visit", visitID);
        }
        Dog dog = this.dogRepo.findOne(dogID);
        if (dog == null)
        {
            throw new InvalidInputException("Dog", dogID);
        }
        VisitDog vd = this.visitDogRelRepo.findByVisitIDAndDogID(visitID, dogID);
        if (vd != null)
        {
            // Already exists
            return vd;
        }
        // Create a new entry.
        vd = new VisitDog();
        vd.setDogID(dogID);
        vd.setVisitID(visitID);
        vd = this.visitDogRelRepo.saveAndFlush(vd);
        return vd;
    }
    
    /**
     * Remove a Dog from a Visit.
     * @param visitID
     * @param dogID
     * @return true if the visit-dog entry was found and deleted, false if not found.
     */
    public boolean removeDogFromVisit(Long visitID, Long dogID)
    {
        VisitDTO v = getVisit(visitID);
        if (v == null)
        {
            throw new InvalidInputException("Visit", visitID);
        }
        Dog dog = this.dogRepo.findOne(dogID);
        if (dog == null)
        {
            throw new InvalidInputException("Dog", dogID);
        }
        VisitDog vd = this.visitDogRelRepo.findByVisitIDAndDogID(visitID, dogID);
        if (vd == null)
        {
            return false;
        }
        this.visitDogRelRepo.delete(vd.getId());
        return true;
    }
        
}
