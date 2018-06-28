import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javafx.scene.Node;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ordered_Set {
	
	static ArrayList<Integer> NoList ;
	/*static Node node;*/
    public static boolean contains(int[] a, int n) {
    	int min = 0;
    	int max = a.length;
    	if (max == 0)
    	{
    		return false;
    	}
    	while(min < max)
    	{
    		System.out.println(min +" "+ max);
    		int mid = (min+max)/2;
    		int val = a[mid];
    		if(val == n)
    		{
    			return true;
    		}
    		if(val > n)
    		{
    			max = mid -1;
    		}else
    		{
    			min = mid+1;
    		}
    		
    	}
		return false;	
    } 





    // tests

   /* @Test
    public void emptyArrayTest() {
        final boolean result = contains(new int[] {}, 1);
        assertFalse(result);
    }

    @Test
    public void oneItemArrayNumberPresentTest() {
        final boolean result = contains(new int[] {1}, 1);
        assertTrue(result);
    }

    @Test
    public void oneItemArrayNumberAbsentTest() {
        final boolean result = contains(new int[] {1}, 2);
        assertFalse(result);
    }

    @Test
    public void smallArrayNumberPresentTest() {
        final boolean result = contains(new int[] {2, 4, 6}, 4);
        assertTrue(result);
    }

    @Test
    public void smallArrayNumberAbsentTest() {
        final boolean result = contains(new int[] {2, 4, 6}, 5);
        assertFalse(result);
    }*/

    @Test
    public void largeArrayNumberPresentTest() {
        final boolean result = contains(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 8);
        assertTrue(result);
    }
/*
    @Test
    public void largeArrayNumberAbsentTest() {
        final boolean result = contains(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0);
        assertFalse(result);
    }

    @Test
    public void largeArrayNumberFirstTest() {
        final boolean result = contains(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1);
        assertTrue(result);
    }

    @Test
    public void largeArrayNumberLastTest() {
        final boolean result = contains(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10);
        assertTrue(result);
    }*/

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Ordered_Set.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}