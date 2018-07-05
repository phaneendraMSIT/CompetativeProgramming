import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.Stack;

public class Matching_Parenthesis {

	static Stack<String> parenthesis;
    public static int getClosingParen(String sentence, int openingParenIndex) {

        // find the position of the matching closing parenthesis
    	parenthesis = new Stack<>();
    	int count=0;
    	String[] strings = sentence.split("");
    	for (int i = openingParenIndex; i < strings.length; i++) {
			if(strings[i].equals( "(") )
			{
				parenthesis.push(strings[i]);
				count += 1;
			}
			if (strings[i].equals(")")) {
				parenthesis.pop();
				count -= 1;
				if (count == 0) {
					return i;
				}
			}
		}
    	if(count != 0)
    	{
    		throw new IllegalArgumentException();
    	}
    	
    	return 0;
    	
       
    }


















    // tests

    @Test
    public void allOpenersThenClosersTest() {
        final int expected = 7;
        final int actual = getClosingParen("((((()))))", 2);
        assertEquals(expected, actual);
    }

    @Test
    public void mixedOpenersAndClosersTest() {
        final int expected = 10;
        final int actual = getClosingParen("()()((()()))", 5);
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void noMatchingCloserTest() {
        getClosingParen("()(()", 2);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Matching_Parenthesis.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}