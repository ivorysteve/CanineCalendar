package com.stephengilbane.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stephengilbane.VisitClient;
import com.stephengilbane.dto.VisitClientDTO;
import com.stephengilbane.repos.ContactInfoRepository;
import com.stephengilbane.repos.VisitClientRepository;
/**
 * Business Service for managing client info.
 * @author stephengilbane
 *
 */
@Component
public class VisitClientBusinessService
{
    private final VisitClientRepository visitClientRepo;
    private final ContactInfoRepository contactInfoRepo;
    
    @Autowired
    public VisitClientBusinessService(VisitClientRepository vcRepo, ContactInfoRepository ciRepo)
    {
        visitClientRepo = vcRepo;
        contactInfoRepo = ciRepo;
    }
    
    /**
     * Get a VisitClient given its ID.
     * @param clientId 
     */
    public VisitClient getVisitClient(Long clientId)
    {
        VisitClient client = visitClientRepo.findOne(clientId);
        return client;
    }
    
    /**
     * Create
     */
    public VisitClientDTO createVisitClient(VisitClientDTO vc)
    {
        return null;
    }
    
    /**
     * Delete a VisitClient given its ID.
     * @param clientId 
     */
    public void deleteVisitClient(Long clientId)
    {
        visitClientRepo.delete(clientId);
    }
}
