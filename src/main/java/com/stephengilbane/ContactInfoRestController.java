package com.stephengilbane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stephengilbane.repos.ContactInfoRepository;

@RestController
@RequestMapping("/contacts")
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
	

}
