
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Recursive_String_Permutations {

	static HashSet<String> wordlist;
    public static Set<String> getPermutations(String inputString) {

        // generate all permutations of the input string
    	wordlist = new HashSet<>();
    	getPermutations("",inputString);
    	
    	System.out.println(wordlist);
        return wordlist;
    }


    private static void getPermutations(String string, String input) {
		// TODO Auto-generated method stub
    	
    	if (input.isEmpty()) {
			wordlist.add(string+input);
		}else {
			for(int i=0; i<input.length();i++)
			{
				getPermutations(string+input.charAt(i), input.substring(0,i)+input.substring(i+1,input.length()));
			}
		}
	}


















	// tests

    @Test
    public void emptyStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList(""));
        final Set<String> actual = getPermutations("");
        assertEquals(expected, actual);
    }

    @Test
    public void oneCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("a"));
        final Set<String> actual = getPermutations("a");
        assertEquals(expected, actual);
    }

    @Test
    public void twoCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("ab", "ba"));
        final Set<String> actual = getPermutations("ab");
        assertEquals(expected, actual);
    }

    @Test
    public void threeCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca",
                                                                 "cab", "cba"));
        final Set<String> actual = getPermutations("abc");
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Recursive_String_Permutations.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}