package com.stephengilbane;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.*;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.stephengilbane.builder.DogBuilder;
import com.stephengilbane.builder.VisitClientBuilder;
import com.stephengilbane.entity.Dog;
import com.stephengilbane.entity.VisitClient;
import com.stephengilbane.scheduler.DogSchedule;
import com.stephengilbane.scheduler.SchedulingEngine;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CanineCalendarApplication.class)
@WebAppConfiguration
public class SchedulingEngineTest
{

    /** Not ready works */
    @Test
    public void testDogNotReady()
    {
        SchedulingEngine sched = new SchedulingEngine();

        VisitClient vc = new VisitClientBuilder().build();
        Dog dog = new DogBuilder().setIsReadyToVisit(false).build();
        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog);
        DogSchedule ds = sched.calculateSchedule(vc, dogs);
        assertThat(ds.hasAnswer(), is(false));
        System.out.println(ds);
        
    }
    
    /** Happy path **/
    @Test
    public void test3DogsOK()
    {
        SchedulingEngine sched = new SchedulingEngine();
        VisitClient vc = new VisitClientBuilder().maxDogs(3).minDogs(3).build();
        List<Dog> dogs = new ArrayList<>();
        for (int i = 0; i < 3; i++)
        {
            Dog d1 = new DogBuilder().setIsReadyToVisit(true).build();
            dogs.add(d1);
        }
        DogSchedule ds = sched.calculateSchedule(vc, dogs);
        assertThat(ds.hasAnswer(), is(true));
        System.out.println(ds);
    }
}
