package com.stephengilbane.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stephengilbane.entity.VisitDog;

/**
 * Repository for Visit-Dog relationship objects.
 */
public interface VisitDogRepository 
extends JpaRepository<VisitDog, Long> 
{
    // No additional methods
    // XXX: Need to change this to reflect compound key.

}

