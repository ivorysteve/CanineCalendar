package com.stephengilbane.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.stephengilbane.Dog;

/**
 * Data Transfer form of a Dog.
 * @author stephengilbane
 *
 */
public class DogDTO
{
    private long id;
    
    @NotNull
    private String name;
    @Min(0)
    private int visitCount;
    @NotNull
    private Long ownerId;
    
    private Long breedId;
    @NotNull
    private String breedName;
    
    /**
     * Constructor
     */
    public DogDTO() {}
    /**
     * Dog Constructor
     */
    public DogDTO(Dog d)
    {
        this.name = d.getName();
        this.id = d.getId();
        this.visitCount = d.getVisitCount();
        this.breedId = d.getBreed().getId();
        this.ownerId = d.getOwner().getId();
        this.breedName = d.getBreed().getName();
    }
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
    public long getId()
    {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(long id)
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
    public long getOwnerId()
    {
        return ownerId;
    }
    /**
     * @param ownerId the ownerId to set
     */
    public void setOwnerId(long ownerId)
    {
        this.ownerId = ownerId;
    }
    /**
     * @return the breedId
     */
    public long getBreedId()
    {
        return breedId;
    }
    /**
     * @param breedId the breedId to set
     */
    public void setBreedId(long breedId)
    {
        this.breedId = breedId;
    }
    /**
     * @return the breed name.
     */
    public String getBreedName()
    {
        return breedName;
    }
    /**
     * @param bName the breed name to set
     */
    public void setBreedName(String bName)
    {
        this.breedName = bName;
    }
}
