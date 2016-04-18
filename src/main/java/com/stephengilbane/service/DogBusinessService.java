package com.stephengilbane.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stephengilbane.DogBreed;
import com.stephengilbane.DogOwner;
import com.stephengilbane.dto.DogDTO;
import com.stephengilbane.entity.Dog;
import com.stephengilbane.exception.ItemNotFoundException;
import com.stephengilbane.repos.DogBreedRepository;
import com.stephengilbane.repos.DogRepository;

@Component
public class DogBusinessService
{
    private final DogRepository dogRepository;
    private final DogBreedRepository dogBreedRepository;
    
    /**
     * Constructor.
     * @param dogRepo Dog persistence layer.
     * @param breedRepo DogBreed persistence layer.
     */
    @Autowired
    public DogBusinessService(DogRepository dogRepo, DogBreedRepository breedRepo)
    {
        this.dogRepository = dogRepo;
        this.dogBreedRepository = breedRepo;
    }
    
    /**
     * 
     * @param dogDto
     * @return Dog object.
     */
    public Dog convertDogDtoToDogEntity(DogDTO dogDto)
    {
        Dog d = new Dog();
        d.setName(dogDto.getName());
        d.setVisitCount(dogDto.getVisitCount());
        Long breedId = dogDto.getBreedId();
        DogBreed breed = dogBreedRepository.findOne(breedId);
        if (breed == null)
        {
            throw new ItemNotFoundException("breed", breedId);
        }
        d.setBreed(breed);
        DogOwner owner = new DogOwner();
        owner.setId(dogDto.getOwnerId());
        d.setOwner(owner);
        
        return d;
    }
    
    /**
     * Get a dog given its ID.
     * @param dogId 
     */
    public Dog getDog(Long dogId)
    {
        Dog d = this.dogRepository.findOne(dogId);
        return d;
    }
    
    /**
     * Save a  Dog entity.
     * @param d Dog to save.
     */
    public Dog saveDog(Dog d)
    {
        Dog dog = this.dogRepository.save(d);
        return dog;
    }
    
    /**
     * Update a dog.
     * @param oldDog
     * @param dogDto
     * @return
     */
    public Dog updateDog(Dog oldDog, DogDTO dogDto)
    {
        
        oldDog.setName(dogDto.getName());

        oldDog = this.dogRepository.save(oldDog);
        
        return oldDog;
    }
    
    /**
     * Delete a Dog entity.
     */
    public void deleteDog(Dog d)
    {
        this.dogRepository.delete(d);
    }
}
