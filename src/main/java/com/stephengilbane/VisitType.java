package com.stephengilbane;

/**
 * Clients may specify that their visits have special requirements.
 * This enumerates these types of visit requirements.
 * 
 * @author stephengilbane
 */
public enum VisitType
{
    /** Not yet determined */
    UNKNOWN(0),
    /** General purpose **/
    GP(1),
    /** Special purpose **/
    SP(2),
    /** Secure visit type **/
    SVT(3);
    
    /**
     * Constructor
     * @param val Database integer value for this enumeration value.
     */
    VisitType(int val)
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
     * Translate from database value to VisitType enum.
     * @param v value
     * @return VisitType
     * @throws IllegalArgumentException if value is invalid.
     */
    public static VisitType fromDbValue(int v)
    {
        for (VisitType vt : VisitType.values())
        {
            if (vt.dbValue == v)
            {
                return vt;
            }
        }
        throw new IllegalArgumentException("Invalid VisitType value " + v);
    }
    
    private final int dbValue;

}
