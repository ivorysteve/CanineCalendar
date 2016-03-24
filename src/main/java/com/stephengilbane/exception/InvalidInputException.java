package com.stephengilbane.exception;
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
}
