package com.stephengilbane.dto;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.stephengilbane.ContactInfo;
import com.stephengilbane.VisitType;
import com.stephengilbane.entity.VisitClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * DTO for client, including contact info.
 * 
 * @author stephengilbane
 *
 */
@ApiModel( 
        value = "Client or organization that dogs come to visit.", 
        description = "Attributes for a client of dog visits, such as a nursing home or hospital." 
)
public class VisitClientDTO
{
    private Long id;
    
    @ApiModelProperty( value = "Displayable name of organization.  Must not be null." )
    @NotNull
    private String name;
    
    @ApiModelProperty( value = "Type of visit for this organization." )
    private String visitTypeName = VisitType.UNKNOWN.name();
    
    @ApiModelProperty( value = "Minimum number of dogs for a given visit.  Must be > 0." )
    @Min(1)
    private int minDogs;
    
    @ApiModelProperty( value = "Maximum number of dogs for a given visit.  Must be > 0." )
    @Min(1)
    private int maxDogs;
    
    @ApiModelProperty( value = "Date of last visit." )
    private Date lastVisit;
    
    @ApiModelProperty( value = "If true, this client is not able to schedule visits." )
    private Boolean isSuspended = Boolean.FALSE;
    
    @ApiModelProperty( value = "Contact info for this client and its contact person." )
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
