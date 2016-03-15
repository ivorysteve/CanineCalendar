package com.stephengilbane.exception;

/**
 * General exception for an invalid item.
 */
@SuppressWarnings("serial")
public class ItemNotFoundException 
extends RuntimeException 
{
    /**
     * Constructor
     * @param itemTypeName Printable name of item type.
     * @param id Primary key of item.
     */
    public ItemNotFoundException(String itemTypeName, Long id) {
        super("could not find " + itemTypeName + " '" + id + "'.");
    }
}
