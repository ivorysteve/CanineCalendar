package com.stephengilbane;

/**
 * Repository for DogBreed objects.
 */
import org.springframework.data.jpa.repository.JpaRepository;
public interface DogBreedRepository 
extends JpaRepository<DogBreed, Long> 
{
	// No additional methods

}
