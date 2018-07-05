import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Reverse_String {

    public static void reverse(char[] arrayOfChars) {

        // reverse input array of characters in place

    	reverse(arrayOfChars,0,arrayOfChars.length-1);
    }

    private static void reverse(char[] arrayOfChars, int i, int length) {
		// TODO Auto-generated method stub
		char temp;
		if(i >= length)
		{
			return ;
		}
		temp = arrayOfChars[i];
		arrayOfChars[i] = arrayOfChars[length];
		arrayOfChars[length] = temp;
		reverse(arrayOfChars,i+1,length-1);
	}


















	// tests

    @Test
    public void emptyStringTest() {
        final char[] expected = "".toCharArray();
        final char[] actual = "".toCharArray();
        reverse(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void singleCharacterStringTest() {
        final char[] expected = "A".toCharArray();
        final char[] actual = "A".toCharArray();
        reverse(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void longerStringTest() {
        final char[] expected = "EDCBA".toCharArray();
        final char[] actual = "ABCDE".toCharArray();
        reverse(actual);
        assertArrayEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Reverse_String.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}