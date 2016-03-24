package com.stephengilbane;

import java.util.ArrayList;
import java.util.List;

import org.jacop.constraints.Alldifferent;
import org.jacop.constraints.Constraint;
import org.jacop.constraints.Sum;
import org.jacop.constraints.XgteqC;
import org.jacop.constraints.XlteqC;
import org.jacop.core.Domain;
import org.jacop.core.IntVar;
import org.jacop.core.Store;
import org.jacop.search.DepthFirstSearch;
import org.jacop.search.IndomainMin;
import org.jacop.search.InputOrderSelect;
import org.jacop.search.Search;
import org.jacop.search.SelectChoicePoint;

/**
 * Engine that determines which dogs go on a given visit.
 * Uses the Java Constraint Program Solver (JaCoP) library.
 * @author stephengilbane
 *
 */
public class SchedulingEngine
{
    /**
     * Main entry point into this class.  Given a visit and a list of dogs, calculate who will attend.
     * @param vc Client info
     * @param dogList Dogs.
     */
    public void calculateSchedule(VisitClient vc, List<Dog> dogList)
    {
        Store store = new Store();

        int dogCount = dogList.size();
        ArrayList<IntVar> allVars = new ArrayList<IntVar>();
        
        IntVar dogs[] = new IntVar[dogCount];
        for (int j = 0; j < dogCount; j++) 
        {
            Dog d = dogList.get(j);
            dogs[j] = new IntVar(store, d.getName(), 0, 1); 
            allVars.add(dogs[j]);
        }
        
        constrainDogCount(store, vc, dogs, allVars);
        
        doSearch(store, allVars);
    }
    
    /**
     * Solve and print solution set up in the Store.
     * @param store JaCoP Store.
     * @param allVars List of constraint variables.
     */
    private Search<IntVar> doSearch(Store store, List<IntVar> allVars)
    {
        IntVar[] allVarsArr = allVars.toArray(new IntVar[1]);
        SelectChoicePoint<IntVar> select = 
                new InputOrderSelect<IntVar> (store,
                        allVarsArr,
                        new IndomainMin<IntVar> ()
                );
        Search<IntVar> searchRes = new DepthFirstSearch<IntVar>(); 
        searchRes.getSolutionListener().searchAll(true);
        searchRes.getSolutionListener().recordSolutions(true);
        boolean result = searchRes.labeling(store, select);
        
        printSolution(searchRes, result, allVarsArr);
        
        return searchRes;
    }
    
    /**
     * Print solution set up in the Store.
     * @param searchRes Search results.
     * @param isSuccess Was the search a success?
     * @param allVars List of constraint variables.
     */
    private void printSolution( Search<IntVar> searchRes, boolean isSuccess, IntVar[] allVarsArr)
    {
        if ( isSuccess ) 
        {
            int numSolutions = searchRes.getSolutionListener().solutionsNo();
            System.out.println("There are " + numSolutions + " solutions");
            for (int s = 1; s <= numSolutions; s++) 
            {
                Domain [] res = searchRes.getSolutionListener().getSolution(s);
                int len = res.length;

                // print the result
                System.out.println("Solution #" + s);
                for (int i = 0; i < len; i++) 
                {
                    Domain d = res[i];
                    System.out.print(allVarsArr[i].id + ":" + d.toString() + " ");
                }
                System.out.println();
            }
        } 
        else 
        {
            System.out.println("*** No"); 
        }
    }
    

    /**
     * Establish constraints for minimum and maximum number of
     * dogs on this visit.
     * @param store JaCoP Store.
     * @param vc Visit info.
     * @param dogs List of dogs.
     * @param allVars Constraint variables.
     */
    private void constrainDogCount(Store store, VisitClient vc, IntVar dogs[],  ArrayList<IntVar> allVars)
    {
        int minDogs = vc.getMinDogs();
        int maxDogs = vc.getMaxDogs();

        IntVar sumOfDogs = new IntVar(store, "a_sum", 0, 1000);
        store.impose(new Sum(dogs, sumOfDogs));
        store.impose(new XlteqC(sumOfDogs, maxDogs));
        store.impose(new XgteqC(sumOfDogs, minDogs));
        
        // Add new variables to our list.
        allVars.add(sumOfDogs);
    }
    
    /**
     * JaCoP test
     */
    public void test()
    {
        Store store = new Store();
        IntVar a = new IntVar(store, "a", 3, 4); 
        IntVar b = new IntVar(store, "b", 1, 3); 
        IntVar c = new IntVar(store, "c", 2, 3); 
        IntVar[] v = {a, b, c}; 
        Constraint ctr = new Alldifferent(v); 
        store.impose(ctr);
        
        // search for a solution and print results 
        Search<IntVar> search = new DepthFirstSearch<IntVar>(); 
        SelectChoicePoint<IntVar> select = 
            new InputOrderSelect<IntVar>(store, v, 
                                         new IndomainMin<IntVar>()); 
        boolean result = search.labeling(store, select);
        if ( result ) 
            System.out.println("Solution: " + a +", " + b + ", "+ c); 
        else 
            System.out.println("*** No"); 
    }
    
    /**
     * MAIN
     * @param args
     */
    public static void main(String[] args)
    {
        SchedulingEngine sched = new SchedulingEngine();

        VisitClient vc = new VisitClient();
        vc.setMaxDogs(4);
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
