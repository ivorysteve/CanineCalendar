package com.stephengilbane.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.jacop.core.Domain;
import org.jacop.core.IntVar;
import org.jacop.search.DepthFirstSearch;
import org.jacop.search.Search;

import com.stephengilbane.entity.Dog;

/**
 * Class that keeps each associated Dog object with its constraint variable.
 * @author stephengilbane
 *
 */
public class DogSchedule
{
    private final List<Dog> myDogs;
    private final List<IntVar> myVars;
    private final List<IntVar> myAllVars;
    private boolean myHasAnswer;
    private Search<IntVar> mySearchResult;
    
    /**
     * Constructor
     */
    public DogSchedule()
    {
        myDogs = new ArrayList<Dog>();
        myVars = new ArrayList<IntVar>();
        myAllVars = new ArrayList<IntVar>();
        myHasAnswer = false;
    }
    
    /**
     * Add a dog and its associated VarInt constraint.
     * @param dog
     * @param var
     */
    public void addDog(Dog dog, IntVar var)
    {
        myDogs.add(dog);
        myVars.add(var);
        myAllVars.add(var);
    }
    
    /**
     * Add a general constraint variable not associated
     * with a dog.
     * @param var
     */
    public void addConstraintVariable(IntVar var)
    {
        myAllVars.add(var);
    }
    
    /**
     * @return Total number of considered dogs.
     */
    public int size()
    {
        return myDogs.size();
    }
    
    /**
     * @param indx Index of Dog.
     * @return dog object.
     */
    public Dog getDog(int indx)
    {
        return myDogs.get(indx);
    }
    
    /**
     * @param indx Index of IntVar.
     * @return Constraint variable for this dog.
     */
    public IntVar getVar(int indx)
    {
        return myVars.get(indx);
    }
    
    /**
     * Get array of IntVars representing the dogs.
     * @return
     */
    public IntVar[] getDogVarArray()
    {
        return myVars.toArray(new IntVar[]{});
    }
    
    /**
     * Get array of all IntVars in this schedule.
     * This may include constraints not associated with a specific dog.
     * @return Array of IntVar objects.
     */
    public IntVar[] getAllVarArray()
    {
        return myVars.toArray(new IntVar[]{} );
    }
    
    public void setHasAnswer(boolean hasAnswer)
    {
        myHasAnswer = hasAnswer;
    }
    
    public boolean hasAnswer()
    {
        return myHasAnswer;
    }
    
    public Search<IntVar> getSearchResult()
    {
        return mySearchResult;
    }
    
    public void setSearchResult(Search<IntVar> sr)
    {
        mySearchResult = sr;
    }
    
    /**
     * @return Printable string version of this.
     */
    public String toString()
    {
        if (!myHasAnswer || mySearchResult == null)
        {
            return "No solution available";
        }
        
        StringBuilder sb = new StringBuilder();
        int numSolutions = mySearchResult.getSolutionListener().solutionsNo();
        sb.append("There are " + numSolutions + " solutions.");
        for (int s = 1; s <= numSolutions; s++) 
        {
            Domain[] res = mySearchResult.getSolutionListener().getSolution(s);
            int len = res.length;

            // print the result
            sb.append("Solution #" + s);
            for (int i = 0; i < len; i++) 
            {
                Domain d = res[i];
                sb.append(this.myAllVars.get(i).id + ":" + d.toString() + " ");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
