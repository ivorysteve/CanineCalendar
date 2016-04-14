package com.stephengilbane;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Class defining a breed of dog.
 * @author stephengilbane
 *
 */
@ApiModel( value = "DogBreed", description = "Dog Breed descriptor.  Used as both entity and DTO." )
@Entity(name="T_BREED")
public class DogBreed 
{
    @ApiModelProperty( value = "Dog breed primary key." ) 
    @Id
    @GeneratedValue
    private Long id;
    
    @ApiModelProperty( value = "Dog breed printable name.  Must be unique.", required = true ) 
    public String name;
    
    @ApiModelProperty( value = "Dog breed's size.", required = true ) 
	@Column(name="size")
    public String breedSize;
	
	/**
	 *  Empty constructor.
	 */
	public DogBreed()
	{
		
	}
	
	/**
	 * Constructor.
	 * @param n Breed name.
	 * @param sz Breed size.
	 */
	public DogBreed(String n, String sz)
	{
		name = n;
		breedSize = sz;
	}
    
	/**
	 * Primary key.
	 * @return
	 */
	public Long getId() 
	{
		return id;
	}
	
	public void setId(Long id) 
	{
		this.id = id;
	}
	
	/**
	 * Printable name of breed.
	 * @return
	 */
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	/**
	 * Relative size of this breed.
	 * @return
	 */
	public String getBreedSize() 
	{
		return breedSize;
	}
	public void setBreedType(String breedSize) 
	{
		this.breedSize = breedSize;
	}
	
	/**
	 * String description.
	 */
	@Override
	public String toString()
	{
		return name;
	}

}
