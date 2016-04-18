package com.stephengilbane.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stephengilbane.entity.VisitClient;

/**
 * Repository for Dog Visit Client objects.
 */
public interface VisitClientRepository 
extends JpaRepository<VisitClient, Long> 
{
    // No additional methods

}
