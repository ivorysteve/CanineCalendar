package com.stephengilbane.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Data Transfer form of a Dog.
 * @author stephengilbane
 *
 */
public class DogDTO
{
    private int id;
    
    @NotNull
    private String name;
    @Min(0)
    private int visitCount;
    @NotNull
    private Integer ownerId;
    @NotNull
    private Integer breedId;
    
    /**
     * Constructor
     */
    public DogDTO() {}
    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * @return the visitCount
     */
    public int getVisitCount()
    {
        return visitCount;
    }
    /**
     * @param visitCount the visitCount to set
     */
    public void setVisitCount(int visitCount)
    {
        this.visitCount = visitCount;
    }
    /**
     * @return the ownerId
     */
    public int getOwnerId()
    {
        return ownerId;
    }
    /**
     * @param ownerId the ownerId to set
     */
    public void setOwnerId(int ownerId)
    {
        this.ownerId = ownerId;
    }
    /**
     * @return the breedId
     */
    public int getBreedId()
    {
        return breedId;
    }
    /**
     * @param breedId the breedId to set
     */
    public void setBreedId(int breedId)
    {
        this.breedId = breedId;
    }
}
