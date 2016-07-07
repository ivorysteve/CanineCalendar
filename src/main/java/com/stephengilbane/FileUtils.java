package com.stephengilbane;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * General File utilities.
 * @author stephen.gilbane
 */
public class FileUtils
{
    private FileUtils() {}
    
    
    /**
     * Get image bytes for an image file.
     * @param fullPathName
     * @return byte array
     * @throws IOException
     */
    public static  byte[] getImageBytes(String fullPathName)
    throws IOException
    {
        if (isBlank(fullPathName))
        {
            throw new IllegalArgumentException("Invalid empty file path");
        }
        File f = new File(fullPathName);
        if (!f.exists() || !f.canRead())
        {
            throw new IllegalArgumentException("Invalid file path does not exist or is not readable.");            
        }
        byte[] rtnArr = Files.readAllBytes(f.toPath());
        return rtnArr;
    }
    
    public static String toImageType(String fname)
    {
        if (fname.endsWith(".jpg"))
        {
            return "image/jpeg";
        }
        return null;
    }

}
