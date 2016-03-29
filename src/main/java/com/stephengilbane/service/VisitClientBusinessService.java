package com.stephengilbane.service;

import static org.apache.commons.lang3.StringUtils.isBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.stephengilbane.ContactInfo;
import com.stephengilbane.VisitClient;
import com.stephengilbane.VisitType;
import com.stephengilbane.dto.VisitClientDTO;
import com.stephengilbane.exception.InvalidInputException;
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
     * Get a VisitClientDTO given its ID.
     * @param clientId 
     */
    public VisitClientDTO getVisitClient(Long clientId)
    {
        VisitClient client = visitClientRepo.findOne(clientId);
        if (client != null)
        {
            Long ciId = client.getContactInfoId();
            ContactInfo ci = contactInfoRepo.findOne(ciId);
            VisitClientDTO dto = new VisitClientDTO(client, ci);
            return dto;
        }
        return null;
    }
    
    /**
     * Create a new Visit Client.
     */
    //@Transactional
    public VisitClientDTO createVisitClient(VisitClientDTO dto)
    {
        ContactInfo ci = contactInfoRepo.save(dto.getContactInfo());
        dto.setContactInfo(ci);
        
        VisitClient vc = convertToVisitClient(dto);
        vc = this.visitClientRepo.save(vc);
        
        VisitClientDTO vcResult = new VisitClientDTO(vc, ci);
        
        return vcResult;
    }
    
    /**
     * Delete a VisitClient given its ID.
     * @param clientId 
     */
    public void deleteVisitClient(Long clientId)
    {
        visitClientRepo.delete(clientId);
    }
    
    /**
     * Validate client contact info.
     * @param vc
     * @throws InvalidInputException on any invalid field or set of fields.
     */
    public void validateVisitClient(VisitClientDTO vc)
    {
        if (isBlank(vc.getName()))
        {
            throw new InvalidInputException("Client name");
        }
        if (vc.getMinDogs() < 1)
        {
            throw new InvalidInputException("Minimum number of dogs", vc.getMinDogs());
        }
        ContactInfo ci = vc.getContactInfo();
        if (ci == null)
        {
            throw new InvalidInputException("Contact Information");
        }
        if (isBlank(ci.getHomePhone()) && isBlank(ci.getMobilePhone()))
        {
            throw new InvalidInputException("Missing phone number");
        }
        if (isBlank(ci.getFirstName()) && isBlank(ci.getLastName()))
        {
            throw new InvalidInputException("Missing contact name information");
        }
    }
    
    /**
     * Convert VisitClientDTO to VisitClient entity.
     * @param dto
     * @return
     */
    public static VisitClient convertToVisitClient(VisitClientDTO dto)
    {
        VisitClient vc = new VisitClient();
        vc.setId(dto.getId());
        vc.setName(dto.getName());
        vc.setMinDogs(dto.getMinDogs());
        vc.setMaxDogs(dto.getMaxDogs());
        VisitType vt = VisitType.valueOf(dto.getVisitTypeName());
        vc.setVisitTypeValue(vt == null ? VisitType.GP.getDbValue() : vt.getDbValue());
        if (dto.getContactInfo() != null)
        {
            vc.setContactInfoId(dto.getContactInfo().getId());
        }
        
        return vc;
    }
}
