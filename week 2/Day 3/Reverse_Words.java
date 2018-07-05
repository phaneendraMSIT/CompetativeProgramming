import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import javax.xml.ws.handler.MessageContext;

public class Reverse_Words {


	public static void reverse(char[] arrayOfChars) {

        // reverse input array of characters in place
	
		
    	reverse(arrayOfChars,0,arrayOfChars.length);
    	int temp =0;
    	for (int i = 0; i < arrayOfChars.length; i++) {
			if (arrayOfChars[i] == ' ') {
				reverse(arrayOfChars, temp, i);
				temp = i+1;
			}
		}
    	
       reverse(arrayOfChars, temp, arrayOfChars.length);
    	
       for(int i = 0;i<arrayOfChars.length;i++)
       {
    	   System.out.print(arrayOfChars[i]);
       }
       System.out.println();
    }

    private static void reverse(char[] arrayOfChars, int i, int length) {
		// TODO Auto-generated method stub
		char temp;
		if(i >= length-1)
		{
			return ;
		}
		temp = arrayOfChars[i];
		arrayOfChars[i] = arrayOfChars[length-1];
		arrayOfChars[length-1] = temp;
		reverse(arrayOfChars,i+1,length-1);
	}















    // tests

    @Test
    public void oneWordTest() {
        final char[] expected = "vault".toCharArray();
        final char[] actual = "vault".toCharArray();
        reverse(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoWordsTest() {
        final char[] expected = "cake thief".toCharArray();
        final char[] actual = "thief cake".toCharArray();
        reverse(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void threeWordsTest() {
        final char[] expected = "get another one".toCharArray();
        final char[] actual = "one another get".toCharArray();
        reverse(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void multipleWordsSameLengthTest() {
        final char[] expected = "the cat ate the rat".toCharArray();
        final char[] actual = "rat the ate cat the".toCharArray();
        reverse(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void multipleWordsDifferentLengthsTest() {
        final char[] expected = "chocolate bundt cake is yummy".toCharArray();
        final char[] actual = "yummy is cake bundt chocolate".toCharArray();
        reverse(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void emptyStringTest() {
        final char[] expected = "".toCharArray();
        final char[] actual = "".toCharArray();
        reverse(actual);
        assertArrayEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Reverse_Words.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}