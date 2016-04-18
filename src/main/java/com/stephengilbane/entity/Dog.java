package com.stephengilbane.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.stephengilbane.DogBreed;
import com.stephengilbane.DogOwner;

import javax.persistence.JoinColumn;

/**
 * Class defining a specific dog.
 * 
 * @author stephengilbane
 *
 */
@Entity(name = "T_DOG")
public class Dog
{
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    
    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private DogOwner owner;
    
    @ManyToOne
    @JoinColumn(name = "BREED_ID")
    private DogBreed breed;
    
    private Boolean isReadyToVisit = Boolean.FALSE;
    
    private int visit_count = 0;

    /**
     * @return the primary key.
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @param id the primary key to set.
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * @return this dog's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the dog name to set.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return this dog's owner.
     */
    public DogOwner getOwner()
    {
        return owner;
    }

    /**
     * @param owner the dog owner to set.
     */
    public void setOwner(DogOwner owner)
    {
        this.owner = owner;
    }

    /**
     * @return the breed of this dog.
     */
    public DogBreed getBreed()
    {
        return breed;
    }

    /**
     * @param breed the dog breed to set.
     */
    public void setBreed(DogBreed breed)
    {
        this.breed = breed;
    }

    /**
     * @return TRUE if this dog is Ready To go on a Visit; FALSE if not yet cleared.
     */
    public Boolean isReadyToVisit()
    {
        return isReadyToVisit;
    }

    /**
     * @param isReadyToVisit TRUE if this dog is Ready To go on a Visit; FALSE if not yet cleared.
     */
    public void setIsReadyToVisit(Boolean isReadyToVisit)
    {
        this.isReadyToVisit = isReadyToVisit;
    }

    /**
     * @return the total number of visits made by this dog.
     */
    public int getVisitCount()
    {
        return visit_count;
    }

    /**
     * @param visit_count The total number of visits made by this dog.
     */
    public void setVisitCount(int visit_count)
    {
        this.visit_count = visit_count;
    }
}
