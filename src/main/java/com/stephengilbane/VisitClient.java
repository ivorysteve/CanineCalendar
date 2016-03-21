package com.stephengilbane;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Class defining a client organization that requests dog visits.
 * 
 * @author stephengilbane
 *
 */
@Entity(name = "T_CLIENT")
public class VisitClient
{
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    
    @Column(name="CONTACT_INFO_ID")
    private Long contactInfoId;
    
    @Column(name="VISIT_TYPE")
    private int visitTypeValue = VisitType.UNKNOWN.getDbValue();
    
    @Transient
    private VisitType visitType = VisitType.UNKNOWN;
    
    @Column(name="MIN_DOGS")
    private int minDogs;
    
    @Column(name="MAX_DOGS")
    private int maxDogs;
    
    @Column(name="LAST_VISIT_DATE")
    private Date lastVisit;


    /**
     * @return the primary key.
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @param id the primary key to set
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * @return the name of this client organization.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name of this client organization to set.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the primary key of the contact info for this org.
     */
    public Long getContactInfoId()
    {
        return contactInfoId;
    }

    /**
     * @param contactInfoId the primary key of the contact info for this org to set.
     */
    public void setContactInfoId(Long contactInfoId)
    {
        this.contactInfoId = contactInfoId;
    }

    /**
     * @return the visitType enumeration database value.
     */
    public int getVisitTypeValue()
    {
        return visitTypeValue;
    }

    /**
     * @param visitTypeValue the visitType enumeration value to set
     */
    public void setVisitTypeValue(int visitTypeValue)
    {
        VisitType vt = VisitType.fromDbValue(visitTypeValue);
        this.visitTypeValue = visitTypeValue;
        this.visitType = vt;
    }
    
    /**
     * @return the VisitType enumeration value for this client.
     */
    public VisitType getVisitType()
    {
        return this.visitType;
    }
    
    /**
     * @param vt the VisitType enumeration value for this client.
     */
    public void setVisitType(VisitType vt)
    {
        if (vt != null)
        {
            this.visitType = vt;
            this.visitTypeValue = vt.getDbValue();
        }
    }

    /**
     * @return the minimum number of Dogs for a visit to this client.
     */
    public int getMinDogs()
    {
        return minDogs;
    }

    /**
     * @param minDogs the minimum number of Dogs for a visit to this client to set.
     */
    public void setMinDogs(int minDogs)
    {
        this.minDogs = minDogs;
    }

    /**
     * @return the maximum  number of Dogs for a visit to this client.
     */
    public int getMaxDogs()
    {
        return maxDogs;
    }

    /**
     * @param maxDogs the maximum number of Dogs for a visit to this client to set.
     */
    public void setMaxDogs(int maxDogs)
    {
        this.maxDogs = maxDogs;
    }

    /**
     * @return the date of the last Visit to this client.
     */
    public Date getLastVisit()
    {
        return lastVisit;
    }

    /**
     * @param lastVisit the date of the last Visit to this client to set.
     */
    public void setLastVisit(Date lastVisit)
    {
        this.lastVisit = lastVisit;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        return sb.toString();
    }

}
