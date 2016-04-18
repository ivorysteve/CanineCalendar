package com.stephengilbane.builder;

import com.stephengilbane.entity.VisitClient;

public class VisitClientBuilder
{
    private VisitClient myVisitClient;
    public static int DEFAULT_MAX_DOGS = 5;
    public static int DEFAULT_MIN_DOGS = 1;
    
    public VisitClientBuilder()
    {
        myVisitClient = new VisitClient();
        myVisitClient.setMaxDogs(DEFAULT_MAX_DOGS);
        myVisitClient.setMinDogs(DEFAULT_MIN_DOGS);
    }
    
    public VisitClientBuilder maxDogs(int max)
    {
        myVisitClient.setMaxDogs(max);
        return this;
    }
    
    public VisitClientBuilder minDogs(int min)
    {
        myVisitClient.setMinDogs(min);
        return this;
    }

    public VisitClient build()
    {
        return myVisitClient;
    }
}
