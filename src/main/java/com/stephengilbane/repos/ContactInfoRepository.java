package com.stephengilbane.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stephengilbane.ContactInfo;
/**
 * Repository for ContactInfo objects.
 */
public interface ContactInfoRepository 
extends JpaRepository<ContactInfo, Long> 
{
	// No additional methods

}
