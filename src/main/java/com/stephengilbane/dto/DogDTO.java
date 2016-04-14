package com.stephengilbane.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.stephengilbane.Dog;
import com.stephengilbane.DogBreed;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data Transfer form of a Dog.
 * @author stephengilbane
 *
 */
@ApiModel( 
        value = "Dog", 
        description = "Attributes about a specific dog." 
)
public class DogDTO
{
    private long id;
    
    @ApiModelProperty( value = "Name of this dog.  Must not be null." ) 
    @NotNull
    private String name;
    
    @ApiModelProperty( value = "Number of completed visits to date." ) 
    @Min(0)
    private int visitCount;
    
    @ApiModelProperty( value = "Primary key of owner." ) 
    @NotNull
    private Long ownerId;
    
    @ApiModelProperty( value = "Primary key of this dog's breed type." ) 
    private Long breedId;
    
    @ApiModelProperty( value = "Displayable name of this dog's breed type." ) 
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
        DogBreed breed = d.getBreed();
        this.breedName = breed.getName();
        this.breedId = breed.getId();
        this.ownerId = d.getOwner().getId();
    }
    
    /**
     * @return this dog's name
     */
    public String getName()
    {
        return name;
    }
    /**
     * @param name this dog's name to set
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
