package com.stephengilbane.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stephengilbane.entity.Dog;

/**
 * Repository for Dog objects.
 */
public interface DogRepository 
extends JpaRepository<Dog, Long> 
{
    // No additional methods

}
