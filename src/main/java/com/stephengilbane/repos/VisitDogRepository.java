package com.stephengilbane.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stephengilbane.entity.VisitDog;

/**
 * Repository for Visit-Dog relationship objects.
 */
public interface VisitDogRepository 
extends JpaRepository<VisitDog, Long> 
{
    /**
     * Find all VisitDog entries given a Visit ID.
     * @param visitID
     * @return List of VisitDog relations.
     */
    List<VisitDog> findByVisitID(Long visitID);

    /**
     * Find a Visit-Dog relation by visit and dog ID values.
     * @param visitID
     * @param dogID
     * @return VisitDog or null.
     */
    VisitDog findByVisitIDAndDogID(Long visitID, Long dogID);
}

