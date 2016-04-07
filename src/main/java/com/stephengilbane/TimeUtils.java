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

    // Class is not instantiatable.
    private TimeUtils(){};
}
