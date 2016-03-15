package com.stephengilbane.exception;

/**
 * General exception for an invalid owner.
 */
@SuppressWarnings("serial")
public class DogOwnerNotFoundException 
extends RuntimeException 
{
    public DogOwnerNotFoundException(Long ownerId) {
        super("could not find dog owner '" + ownerId + "'.");
    }
}
