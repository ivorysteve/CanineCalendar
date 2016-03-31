package com.stephengilbane;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CanineCalendarApplication.class)
@WebAppConfiguration
public class SchedulingEngineTest
{
    public static final int MAX_TEST_DOGS = 5;
    
    @Test
    public void contextLoads() 
    {
        SchedulingEngine sched = new SchedulingEngine();

        VisitClient vc = new VisitClient();
        vc.setMaxDogs(MAX_TEST_DOGS);
        vc.setMinDogs(1);
        List<Dog> dogs = new ArrayList<>();
        for (int i = 0; i < 7; i++)
        {
            Dog dog = new Dog();
            dog.setName("Dog" + i);
            dogs.add(dog);
        }
        
        sched.calculateSchedule(vc, dogs);
    }
}
