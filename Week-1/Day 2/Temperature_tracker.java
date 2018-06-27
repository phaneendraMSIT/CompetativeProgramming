import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Temperature_tracker {

    static class TempTracker {

        // fill in the TempTracker class methods below
        int[] tempList = new int[111];
        
        double sum = 0.0, mean = 0.0;
        int mini = 0, max = 0, numInsert = 0, mostSo = 0, mode =-1;  

        // records a new temperature
        public void insert(int temperature) {
        	tempList[temperature] += 1;
        	numInsert += 1;
        	mini = 110;
        	max  = 0;
        	sum =0;
        	
        	for(int i=0; i<111;i++)
        	{
        		int current = tempList[i];
        		if(current != 0)
        		{
        			sum += (i*current);
        			
        			if(i<mini)
        			{
        				mini =i;
        			}
        			if(i>max)
        			{
        				max =i;
        			}
        			if(current > mostSo)
        			{
        				mostSo = current;
        				mode = i;
        			}
        			
        		}
        	}
        	mean = sum/numInsert;
        }

        // returns the highest temp we've seen so far
        public int getMax() {
            return max;
        }

        // returns the lowest temp we've seen so far
        public int getMin() {
            return mini;
        }

        // returns the mean of all temps we've seen so far
        public double getMean() {
            return mean;
        }

        // return a mode of all temps we've seen so far
        public int getMode() {
            return mode;
        }
    }

    // tests

    @Test
    public void temperatureTrackerTest {
        final double precision = 1e-6;

        final TempTracker t = new TempTracker();

        t.insert(50);
        assertEquals("step 1: max:", 50, t.getMax());
        assertEquals("step 1: min:", 50, t.getMin());
        assertEquals("step 1: mean:", 50.0, t.getMean(), precision);
        assertEquals("step 3: mode:", 50, t.getMode());

        t.insert(80);
        assertEquals("step 2: max:", 80, t.getMax());
        assertEquals("step 2: min:", 50, t.getMin());
        assertEquals("step 2: mean:", 65.0, t.getMean(), precision);
        assertTrue("step 2: mode:", t.getMode() == 50 || t.getMode() == 80);

        t.insert(80);
        assertEquals("step 3: max:", 80, t.getMax());
        assertEquals("step 3: min:", 50, t.getMin());
        assertEquals("step 3: mean:", 70.0, t.getMean(), precision);
        assertEquals("step 3: mode:", 80, t.getMode());

        t.insert(30);
        assertEquals("step 4: max:", 80, t.getMax());
        assertEquals("step 4: min:", 30, t.getMin());
        assertEquals("step 4: mean:", 60.0, t.getMean(), precision);
        assertEquals("step 4: mode:", 80, t.getMode());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Temperature_tracker.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}