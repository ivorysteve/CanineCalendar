package com.stephengilbane;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="T_BREED")
public class DogBreed 
{
    @Id
    @GeneratedValue
    private Long id;
    
    public String name;
    
	@Column(name="size")
    public String breedSize;
	
	public DogBreed()
	{
		
	}
	
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
	
	@Override
	public String toString()
	{
		return name;
	}

}
