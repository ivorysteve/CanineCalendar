package com.stephengilbane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stephengilbane.ContactInfo;
import com.stephengilbane.exception.ItemNotFoundException;
import com.stephengilbane.repos.ContactInfoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Service for reading ContactInfo.  Primarily used
 * for debugging and service.
 * @author stephengilbane
 */
@Api(
        value = "Contact Information",
        tags = { "ContactInfo" },
        produces = "application/json")
@RestController
@RequestMapping("/caninescheduler/contacts")
public class ContactInfoRestController 
{
	private final ContactInfoRepository ciRepository;
	
	/**
	 * Constructor
	 * @param breedRepository
	 */
	@Autowired
	ContactInfoRestController(ContactInfoRepository contactInfoRepository) 
	{
		this.ciRepository = contactInfoRepository;
	}
	
    /**
     * Get a ContactInfo object.
     * @param contactId Primary Key
     * @return ContactInfo
     * @throws ItemNotFoundException if contact does not exist.
     */
    @ApiOperation(
            value = "Get a ContactInfo by primary ID.",
            response = ContactInfo.class
    )
    @RequestMapping(value = "/{contactId}", method = RequestMethod.GET)
    public ContactInfo readContactInfo(@PathVariable Long contactId) 
    {
        ContactInfo ci = ciRepository.findOne(contactId);
        if (ci == null)
        {
            throw new ItemNotFoundException("ContactInfo", contactId);
        }
        
        return ci;
    }

}
