package com.stephengilbane.validator;

import static org.apache.commons.lang3.StringUtils.isBlank;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.stephengilbane.Dog;
import com.stephengilbane.dto.DogDTO;

public class DogValidator 
implements Validator
{
    public boolean supports(Class clazz)
    {
        return DogDTO.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required");
        DogDTO dog = (DogDTO) target;
        if (isBlank(dog.getName()))
        {
            errors.rejectValue("name", "field.required", new Object[] {}, "Dog name must be present!");
        }
    }
}
