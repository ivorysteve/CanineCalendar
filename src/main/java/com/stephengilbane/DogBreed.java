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
    
	public Long getId() 
	{
		return id;
	}
	
	public void setId(Long id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getBreedSize() 
	{
		return breedSize;
	}
	public void setBreedType(String breedSize) 
	{
		this.breedSize = breedSize;
	}

}
