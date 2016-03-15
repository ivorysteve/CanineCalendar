package com.stephengilbane.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stephengilbane.DogOwner;

/**
 * Repository for DogOwner objects.
 */
public interface DogOwnerRepository 
extends JpaRepository<DogOwner, Long> 
{
    // No additional methods

}