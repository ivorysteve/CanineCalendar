package com.stephengilbane.validator;

import static org.apache.commons.lang3.StringUtils.isBlank;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.stephengilbane.Dog;
import com.stephengilbane.dto.DogDTO;

/**
 * Validate basic fields in a new or updated Dog.
 * @author stephengilbane
 *
 */
public class DogValidator 
implements Validator
{
    public boolean supports(Class clazz)
    {
        return DogDTO.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors)
    {
        DogDTO dog = (DogDTO) target;
        if (isBlank(dog.getName()))
        {
            errors.rejectValue("name", "field.required", new Object[] {}, "Dog name must be present!");
        }
        if (dog.getBreedId() <= 0)
        {
            errors.rejectValue("breedId", "field.required", new Object[] {}, "Dog Breed ID must be valid!");            
        }
        if (dog.getOwnerId() <= 0)
        {
            errors.rejectValue("ownerId", "field.required", new Object[] {}, "Owner ID must be valid!");            
        }
    }
}
