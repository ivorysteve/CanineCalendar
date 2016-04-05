package com.stephengilbane;

/**
 * Enumeration describing states a visit can go through.
 * @author stephengilbane
 *
 */
public enum VisitState
{
    /** Initial created state */
    NEW(0),
    /** Confirmed by dog provider. **/
    PENDING(1),
    /** Dogs have been assigned, waiting for date. **/
    ASSIGNED(2),
    /** Visit completed and reported. **/
    REPORTED(3),
    /** Cancelled by the Visit Client.  */
    CANCELLED_BY_CLIENT(4),
    /** Cancelled by Dog Provider (due to lack of available dogs). */
    CANCELLED_NO_DOGS(5);
    
    /**
     * Constructor
     * @param val Database integer value for this enumeration value.
     */
    VisitState(int val)
    {
        dbValue = val;
    }
    
    /**
     * @return Database value used to represent this enumeration.
     */
    public int getDbValue()
    {
        return this.dbValue;
    }
    
    /**
     * Translate from database value to VisitState enum.
     * @param v database value.
     * @return VisitState enum.
     * @throws IllegalArgumentException if value is invalid.
     */
    public static VisitState fromDbValue(int v)
    {
        for (VisitState vt : VisitState.values())
        {
            if (vt.dbValue == v)
            {
                return vt;
            }
        }
        throw new IllegalArgumentException("Invalid VisitState value " + v);
    }
    
    /** Value stored in database */
    private final int dbValue;

}
