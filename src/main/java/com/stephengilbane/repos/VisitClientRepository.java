package com.stephengilbane.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stephengilbane.DogOwner;

/**
 * Repository for Dog Visit Client objects.
 */
public interface VisitClientRepository 
extends JpaRepository<DogOwner, Long> 
{
    // No additional methods

}
