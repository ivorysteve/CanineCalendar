package com.stephengilbane.builder;

import java.util.concurrent.atomic.AtomicLong;

import com.stephengilbane.DogBreed;
import com.stephengilbane.entity.Dog;

/**
 * Test Dog builder.
 * @author stephengilbane
 *
 */
public class DogBuilder
{
    private Dog myDog;
    private AtomicLong myIdCount = new AtomicLong(0);
    
    /**
     * Constructor.
     * @param nm Dog name.
     */
    public DogBuilder(String nm)
    {
        this();
        myDog.setName(nm);
    }
    /**
     * Empty constructor.
     */
    public DogBuilder()
    {
        myDog = new Dog();
        Long id = myIdCount.incrementAndGet();
        myDog.setId(id);
        myDog.setName("TestDog_" + myDog.getId());
    }
    
    public DogBuilder setIsReadyToVisit(boolean isReady)
    {
        myDog.setIsReadyToVisit(isReady);
        return this;
    }
    
    public DogBuilder setBreed(DogBreed b)
    {
        myDog.setBreed(b);
        return this;
    }
    
    public Dog build()
    {
        return myDog;
    }

}
