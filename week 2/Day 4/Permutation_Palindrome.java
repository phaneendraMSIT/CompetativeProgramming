import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.Arrays;

public class Permutation_Palindrome {
	
	static int chars = 250;

    public static boolean hasPalindromePermutation(String theString) {

        // check if any permutation of the input is a palindrome
    	
    	int count[]= new int[chars];
    	Arrays.fill(count, 0);
    	for (int i = 0; i < theString.length(); i++) {
			count[(int)theString.charAt(i)]++;
		}
    	int temp = 0;
    	
    	for(int i=0; i<chars;i++)
    	{
    		if ((count[i]&1)==1) {
				temp++;
			}
    		if (temp >1 ) {
				return false;
			}
    	}
        return true;
    }


















    // tests

    @Test
    public void permutationWithOddNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabcbcd");
        assertTrue(result);
    }

    @Test
    public void permutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabccbdd");
        assertTrue(result);
    }

    @Test
    public void noPermutationWithOddNumberOfChars() {
        final boolean result = hasPalindromePermutation("aabcd");
        assertFalse(result);
    }

    @Test
    public void noPermutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabbcd");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = hasPalindromePermutation("");
        assertTrue(result);
    }

    @Test
    public void oneCharacterStringTest() {
        final boolean result = hasPalindromePermutation("a");
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Permutation_Palindrome.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}