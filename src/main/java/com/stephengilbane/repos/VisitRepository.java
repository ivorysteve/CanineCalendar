
package com.stephengilbane.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stephengilbane.Visit;

/**
 * Repository for Visit objects.
 */
public interface VisitRepository 
extends JpaRepository<Visit, Long> 
{
    // No additional methods

}
