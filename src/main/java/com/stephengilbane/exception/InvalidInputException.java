package com.stephengilbane.exception;

import org.springframework.http.HttpStatus;
/**
 * General exception for an invalid (creation or update) parameter.
 */
@SuppressWarnings("serial")
public class InvalidInputException
extends RuntimeException
{
    /**
     * Constructor
     * @param paramTypeName Printable name of invalid parameter.
     * @param value Passed-in value of parameter.
     */
    public InvalidInputException(String paramTypeName, Object value) {
        super("Invalid value for " + paramTypeName + ": '" + value + "'.");
    }
    /**
     * Constructor for null/blank/empty value.
     * @param paramTypeName Printable name of invalid parameter.
     */
    public InvalidInputException(String paramTypeName) {
        super("Invalid empty value for " + paramTypeName);
    }
    
    /**
     * @return HTTP Status code.
     */
    public HttpStatus getStatusCode()
    {
        return HttpStatus.BAD_REQUEST;
    }
}
