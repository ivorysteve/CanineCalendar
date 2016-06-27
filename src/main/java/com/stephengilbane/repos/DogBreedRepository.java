package com.stephengilbane.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stephengilbane.DogBreed;

/**
 * Repository for DogBreed objects.
 */
public interface DogBreedRepository 
extends JpaRepository<DogBreed, Long> 
{
    /**
     * Find a DogBreed by name.
     * @param name Name of Breed.
     * @return DogBreed or null.
     */
    DogBreed findByName(String name);

}
