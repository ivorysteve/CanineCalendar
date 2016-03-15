package com.stephengilbane;

import org.springframework.stereotype.Component;

import com.stephengilbane.dto.DogDTO;

@Component
public class DogBusinessManager
{
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
        
        return d;
    }
}
