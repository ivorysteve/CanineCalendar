package com.stephengilbane.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stephengilbane.dto.VisitDTO;
import com.stephengilbane.entity.Visit;
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
    
    @Autowired
    public VisitBusinessService(VisitRepository vRepo)
    {
        visitRepo = vRepo;
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
            return dto;
        }
        return null;
    }

}
