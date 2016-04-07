package com.stephengilbane.dto;

import java.util.Date;

import com.stephengilbane.ContactInfo;
import com.stephengilbane.VisitClient;
import com.stephengilbane.VisitType;

/**
 * DTO for client, including contact info.
 * 
 * @author stephengilbane
 *
 */
public class VisitClientDTO
{
    private Long id;

    private String name;
    private String visitTypeName = VisitType.UNKNOWN.name();
    private int minDogs;
    private int maxDogs;
    private Date lastVisit;
    private Boolean isSuspended;
    private ContactInfo contactInfo;
    
    /**
     * Empty Constructor.
     */
    public VisitClientDTO()
    {
        
    }
    
    /**
     * Constructor.
     * @param vc VisitClient to copy from.
     * @param ci ContactInfo for client to copy from. May be null.
     */
    public VisitClientDTO(VisitClient vc, ContactInfo ci)
    {
        this.id = vc.getId();
        this.name = vc.getName();
        this.minDogs = vc.getMinDogs();
        this.maxDogs = vc.getMaxDogs();
        this.lastVisit = vc.getLastVisit();
        this.visitTypeName = vc.getVisitType().name();
        this.isSuspended = vc.getIsSuspended();
        this.contactInfo = ci;
    }


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
     * @return the contactInfo for this client.
     */
    public ContactInfo getContactInfo()
    {
        return contactInfo;
    }

    /**
     * @param contactInfo the contactInfo to set
     */
    public void setContactInfo(ContactInfo contactInfo)
    {
        this.contactInfo = contactInfo;
    }

    /**
     * @return the visitTypeName
     */
    public String getVisitTypeName()
    {
        return visitTypeName;
    }

    /**
     * @param visitTypeName the visitTypeName to set
     */
    public void setVisitTypeName(String visitTypeName)
    {
        this.visitTypeName = visitTypeName;
    }

    /**
     * @return the minDogs
     */
    public int getMinDogs()
    {
        return minDogs;
    }

    /**
     * @param minDogs the minDogs to set
     */
    public void setMinDogs(int minDogs)
    {
        this.minDogs = minDogs;
    }

    /**
     * @return the maxDogs
     */
    public int getMaxDogs()
    {
        return maxDogs;
    }

    /**
     * @param maxDogs the maxDogs to set
     */
    public void setMaxDogs(int maxDogs)
    {
        this.maxDogs = maxDogs;
    }

    /**
     * @return the isSuspended
     */
    public Boolean getIsSuspended()
    {
        return isSuspended;
    }

    /**
     * @param isSuspended the isSuspended to set
     */
    public void setIsSuspended(Boolean isSuspended)
    {
        this.isSuspended = isSuspended;
    }

    /**
     * @return the lastVisit
     */
    public Date getLastVisit()
    {
        return lastVisit;
    }

    /**
     * @param lastVisit the lastVisit to set
     */
    public void setLastVisit(Date lastVisit)
    {
        this.lastVisit = lastVisit;
    }
}
