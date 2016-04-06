package com.stephengilbane;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * A visit instance.  A visit is a specific set of dogs that visit a client
 * on a specific day and time.  The Visit instance lifecycle goes through 
 * a set of states.
 * 
 * @author stephengilbane
 */
@Entity(name = "T_VISIT")
public class Visit
{
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name="CLIENT_ID")
    private Long clientId;
    
    @Column(name="VISIT_DATE")
    private /* LocalDate */ Date visitDate;
    
    @Column(name="VISIT_TIME")
    private /* LocalTime */ Date visitTime;
    
    @Column(name="CLIENT_NOTES")
    private String clientNotes;
    
    @Transient
    private List<Dog> dogs;
    
    @Column(name="VISIT_STATE")
    private Integer visitStateValue;
    
    @Transient
    private VisitState visitState;
    
    @Column(name="VISIT_REPORT")
    private String report;
    
    /**
     * @return the primary key of this visit.
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
     * @return the clientId for this visit.
     */
    public Long getClientId()
    {
        return clientId;
    }
    /**
     * @param clientId the clientId for this visit to set.
     */
    public void setClientId(Long clientId)
    {
        this.clientId = clientId;
    }
    /**
     * @return the date of the visit.
     */
    public Date getVisitDate()
    {
        return visitDate;
    }
    /**
     * @param visitDate the date of the visit to set.
     */
    public void setVisitDate(Date visitDate)
    {
        this.visitDate = visitDate;
    }
    /**
     * @return the time of the visit.
     */
    public Date getVisitTime()
    {
        return visitTime;
    }
    /**
     * @param visitTime the time of the visit to set.
     */
    public void setVisitTime(Date visitTime)
    {
        this.visitTime = visitTime;
    }
    /**
     * @return any pre-visit notes or instructions by client.
     */
    public String getClientNotes()
    {
        return clientNotes;
    }
    /**
     * @param notes any pre-visit notes or instructions by client to set.
     */
    public void setClientNotes(String notes)
    {
        this.clientNotes = notes;
    }
    /**
     * @return the list of dogs going on the visit.
     */
    public List<Dog> getDogs()
    {
        return dogs;
    }
    /**
     * @param dogs the list of dogs going on the visit.
     */
    public void setDogs(List<Dog> dogs)
    {
        this.dogs = dogs;
    }
    /**
     * @return the visitState for this visit.
     */
    public VisitState getVisitState()
    {
        return visitState;
    }
    /**
     * @param visitState the visitState to set for this visit.
     */
    public void setVisitState(VisitState visitState)
    {
        this.visitState = visitState;
    }
    /**
     * @return the post-visit report, or null if none.
     */
    public String getReport()
    {
        return report;
    }
    /**
     * @param report the post-visit report to set.
     */
    public void setReport(String report)
    {
        this.report = report;
    }

}
