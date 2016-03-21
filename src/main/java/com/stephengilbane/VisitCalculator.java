package com.stephengilbane;

import org.jacop.core.*;
import org.jacop.constraints.*;
import org.jacop.search.*;

/**
 * Engine that determines which dogs go on a visit.
 * Uses the Java Constraint Program Solver (JaCoP) library.
 * @author stephengilbane
 *
 */
public class VisitCalculator
{
    public static void main(String[] args)
    {
        VisitCalculator vc = new VisitCalculator();
        vc.test(null);
    }
    
    public void test(VisitClient client)
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

}
