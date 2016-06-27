package com.stephengilbane;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Time utilities.
 * @author stephengilbane
 *
 */
public class TimeUtils
{
    /**
     * Convert a legacy java.util.Date object to a Java 8 java.time.LocalDate object,
     * using the default system timezone.
     * @param date to be converted.
     * @return LocalDate or null if input was null.
     */
    public static LocalDate dateToLocalDate(Date date)
    {
        LocalDate locDate = null;
        if (date != null)
        {
            Instant instant = Instant.ofEpochMilli(date.getTime());
            LocalDateTime res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            locDate = res.toLocalDate();
        }
        return locDate;
    }

    /**
     * Convert Java 8 java.time.LocalDate to a legacy java.util.Date object,
     * using the default system timezone.
     * @param locDate to be converted.
     * @return Date or null if input was null.
     */
    public static Date localDateToDate(LocalDate locDate)
    {
        Date date = null;
        if (locDate != null)
        {
            Instant instant = locDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
            date = Date.from(instant);
        }
        return date;
    }
    
    /**
     * Convert a legacy java.util.Date object to a Java 8 java.time.LocalTime object,
     * using the default system timezone.
     * @param date to be converted.
     * @return LocalTime or null if input was null.
     */
    public static LocalTime dateToLocalTime(Date date)
    {
        LocalTime locTime = null;
        if (date != null)
        {
            Instant instant = Instant.ofEpochMilli(date.getTime());
            LocalDateTime res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            locTime = res.toLocalTime();
        }
        return locTime;
    }


    /**
     * Convert Java 8 java.time.LocalDateTime to a legacy java.util.Date object,
     * using the default system timezone.
     * @param locDateTime to be converted.
     * @return Date or null if input was null.
     */
    public static Date localDateTimeToDate(LocalDateTime locDateTime)
    {
        Date date = null;
        if (locDateTime != null)
        {
            Instant instant = locDateTime.atZone(ZoneId.systemDefault()).toInstant();
            date = Date.from(instant);
        }
        return date;
    }
    
    // Class is not instantiatable.
    private TimeUtils(){};
}
