import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Rotating_Point {

    public static int findRotationPoint(String[] words) {

        // find the rotation point in the array
        int low = 0;
        int high = words.length - 1;
       
        return  rotations(words,low,high);
        
    }


    private static int rotations(String[] words, int low, int high)
    {
		// TODO Auto-generated method stub
    	
    	if(high < low)
    		return 0;
    	if(high == low)
    		return low;
    	int mid = (low+high)/2;
    	
    	if(mid < high && words[mid+1].compareTo(words[mid])< 0)
    	{
    		return mid+1;
    	}
    	if(mid>low && words[mid].compareTo(words[mid-1])<0)
    	{
    		return mid;
    	}
    	
    	if(words[high].compareTo(words[low])>0)
    	{
    		return rotations(words, low, mid -1);
    	}
		return rotations(words, mid+1, high);
		
	}





	// tests

    @Test
    public void smallArrayTest() {
        final int actual = findRotationPoint(new String[] {"cape", "cake"});
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int actual = findRotationPoint(new String[] {"grape", "orange", "plum",
            "radish", "apple"});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void largeArrayTest() {
        final int actual = findRotationPoint(
            new String[] {"ptolemaic", "retrograde", "supplant", "undulate", "xenoepist",
            "asymptote", "babka", "banoffee", "engender", "karpatka", "othellolagkage"});
        final int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void possiblyMissingEdgeCaseTest() {
        // are we missing any edge cases?
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Rotating_Point.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}