package com.stephengilbane;

/**
 * Repository for ContactInfo objects.
 */
import org.springframework.data.jpa.repository.JpaRepository;
public interface ContactInfoRepository 
extends JpaRepository<ContactInfo, Long> 
{
	// No additional methods

}
