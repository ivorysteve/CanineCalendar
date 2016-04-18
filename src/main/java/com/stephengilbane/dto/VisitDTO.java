package com.stephengilbane.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

import com.stephengilbane.TimeUtils;
import com.stephengilbane.entity.Dog;
import com.stephengilbane.entity.Visit;

/**
 * Public DTO for Visits.
 * @author stephengilbane
 *
 */
public class VisitDTO
{
    private Long id;
    private Long clientId;
    private LocalDate visitDate;
    private String visitDateStr;
    private LocalTime visitTime;
    private String visitTimeStr;
    private String clientNotes;
    private String report;
    private List<Dog> dogs;
    
    /**
     * Copy constructor.
     * @param v Visit to copy from.
     */
    public VisitDTO(Visit v)
    {
        this.id = v.getId();
        this.clientId = v.getClientId();
        this.dogs = v.getDogs();
        
        java.util.Date vd = v.getVisitDate();
        if (vd != null)
        {
            this.visitDate = TimeUtils.dateToLocalDate(vd);
            this.visitDateStr = visitDate.toString();
        }
        java.util.Date vt = v.getVisitTime();
        if (vt != null)
        {
            this.visitTime = TimeUtils.dateToLocalTime(vt);
            this.visitTimeStr = this.visitTime.toString();
        }
        this.clientNotes = v.getClientNotes();
        this.report = v.getReport();
    }

    /**
     * @return the visit primary key.
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @param id the visit primary key to set
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * @return the clientId of this visit's client.
     */
    public Long getClientId()
    {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(Long clientId)
    {
        this.clientId = clientId;
    }

    /**
     * @return the dogs
     */
    public List<Dog> getDogs()
    {
        return dogs;
    }

    /**
     * @param dogs the dogs to set
     */
    public void setDogs(List<Dog> dogs)
    {
        this.dogs = dogs;
    }

    /**
     * @return the visitDate
     */
    public LocalDate getVisitDate()
    {
        return visitDate;
    }
    
    /**
     * @return the visitDate as a String
     */
    public String getVisitDateStr()
    {
        return visitDateStr;
    }

    /**
     * @param visitDate the visitDate to set
     */
    public void setVisitDate(LocalDate visitDate)
    {
        this.visitDate = visitDate;
    }

    /**
     * @return the visitTime
     */
    public LocalTime getVisitTime()
    {
        return visitTime;
    }
    
    /**
     * @return the visitTime as a String
     */
    public String getVisitTimeStr()
    {
        return visitTimeStr;
    }
    /**
     * @param visitTime the visitTime to set
     */
    public void setVisitTime(LocalTime visitTime)
    {
        this.visitTime = visitTime;
    }

    /**
     * @return the clientNotes
     */
    public String getClientNotes()
    {
        return clientNotes;
    }

    /**
     * @param clientNotes the clientNotes to set
     */
    public void setClientNotes(String clientNotes)
    {
        this.clientNotes = clientNotes;
    }

    /**
     * @return the report
     */
    public String getReport()
    {
        return report;
    }

    /**
     * @param report the report to set
     */
    public void setReport(String report)
    {
        this.report = report;
    }

}
