package com.stephengilbane.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Class defining a specific dog on a specific visit.
 * @author stephengilbane
 *
 */
@Entity(name = "T_VISIT_DOG")
public class VisitDog
{
    @Id // Temp; should be compound
    @Column(name="ID")
    private Long id;
    
    @Column(name="DOG_ID")
    private Long dogID;
    
    @Column(name="VISIT_ID")
    private Long visitID;
    
    @Column(name="DOG_VISIT_STATE")    
    private int dogVisitState;

    /**
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * @return the dog primary key.
     */
    public Long getDogID()
    {
        return dogID;
    }

    /**
     * @param dogID the dog primary key to set
     */
    public void setDogID(Long dogID)
    {
        this.dogID = dogID;
    }

    /**
     * @return the visit primary key.
     */
    public Long getVisitID()
    {
        return visitID;
    }

    /**
     * @param visitID the visit primary key to set
     */
    public void setVisitID(Long visitID)
    {
        this.visitID = visitID;
    }

    /**
     * @return the dogVisitState
     */
    public int getDogVisitState()
    {
        return dogVisitState;
    }

    /**
     * @param dogVisitState the dogVisitState to set
     */
    public void setDogVisitState(int dogVisitState)
    {
        this.dogVisitState = dogVisitState;
    }

}
