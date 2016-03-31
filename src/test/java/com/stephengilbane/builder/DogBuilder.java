package com.stephengilbane.builder;

import java.util.concurrent.atomic.AtomicLong;

import com.stephengilbane.Dog;

/**
 * Test Dog builder.
 * @author stephengilbane
 *
 */
public class DogBuilder
{
    private Dog myDog;
    private AtomicLong myIdCount = new AtomicLong(0);
    
    public DogBuilder()
    {
        myDog = new Dog();
        Long id = myIdCount.incrementAndGet();
        myDog.setId(id);
        myDog.setName("TestDog_" + id);
    }
    
    public DogBuilder setIsReadyToVisit(boolean isReady)
    {
        myDog.setIsReadyToVisit(isReady);
        return this;
    }
    
    public Dog build()
    {
        return myDog;
    }

}
