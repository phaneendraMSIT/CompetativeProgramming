import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.Arrays;

public class Duplicate_BeastMode {

    public static int findDuplicate(int[] theArray) {

        // find a number that appears more than once ... in O(n) time
        for (int i = 0; i < theArray.length; i++) {
        	
			if (theArray[Math.abs(theArray[i])] >= 0) {
				theArray[Math.abs(theArray[i])] = -theArray[Math.abs(theArray[i])];
			}else {
				//System.out.println(Math.abs(theArray[i]));
				return Math.abs(theArray[i]);
			}
			//System.out.println(Arrays.toString(theArray));
		}
        return 0;
    }
    




    // tests

    @Test
    public void justTheRepeatedNumberTest() {
        final int[] numbers = {1, 1};
        final int expected = 1;
        final int actual = findDuplicate(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void shortArrayTest() {
        final int[] numbers = {1, 2, 3, 2};
        final int expected = 2;
        final int actual = findDuplicate(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int[] numbers = {1, 2, 5, 5, 5, 5};
        final int expected = 5;
        final int actual = findDuplicate(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void longArrayTest() {
        final int[] numbers = {4, 1, 4, 8, 3, 2, 7, 6, 5};
        final int expected = 4;
        final int actual = findDuplicate(numbers);
        assertEquals(expected, actual);
    }
    
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Duplicate_BeastMode.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}