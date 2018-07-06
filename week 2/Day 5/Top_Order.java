import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.Arrays;



public class Top_Order {

    public static int[] sortScores(int[] unorderedScores, int highestPossibleScore) {
    	
    	int[] count= new int[highestPossibleScore];
    	Arrays.fill(count, 0);
    	for(int i=0;i<unorderedScores.length;i++)
    	{
    		count[unorderedScores[i]]++;
    		System.out.println(count[unorderedScores[i]]);
    	}
    	int temp = unorderedScores.length-1;
    	for(int i=0;i<count.length;i++)
    	{
    		while(count[i] !=0)
    		{
    			count[i] -= 1;
    			unorderedScores[temp]=i;
    			temp--;
    		}
    	}
		return unorderedScores;

       
    }


















	// tests

    @Test
    public void noScoresTest() {
        final int[] scores = {};
        final int[] expected = {};
        final int[] actual = sortScores(scores, 100);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneScoreTest() {
        final int[] scores = {55};
        final int[] expected = {55};
        final int[] actual = sortScores(scores, 100);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoScoresTest() {
        final int[] scores = {30, 60};
        final int[] expected = {60, 30};
        final int[] actual = sortScores(scores, 100);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void manyScoresTest() {
        final int[] scores = {37, 89, 41, 65, 91, 53};
        final int[] expected = {91, 89, 65, 53, 41, 37};
        final int[] actual = sortScores(scores, 100);
        assertArrayEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Top_Order.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}