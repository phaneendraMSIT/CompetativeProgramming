import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.Arrays;

public class Single_Shuffle {

    public static boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffledDeck) {

        // check if the shuffled deck is a single riffle of the halves
    	int i=0;
    	int j=0;
    	int k=0;
    	int [] newshuffled=new int[half1.length+half2.length];
    	while (i<half1.length && j<half2.length) {
			if(half1[i] < half2[j])
			{
				newshuffled[k]= half1[i];
				k++;
				i++;
			}else if (half2[j]<half1[i]) {
				newshuffled[k] = half2[j];
				k++;
				j++;
			}else {
				newshuffled[k]= half1[i];
				i++;
				j++;
				k++;
			}
		}
    	while (i<half1.length) {
			newshuffled[k]=half1[i];
			i++;
			k++;
		}
    	while (j<half2.length) {
			newshuffled[k]=half2[j];
			j++;
			k++;
		}
    	
    	if (Arrays.equals(newshuffled,shuffledDeck)) {
			return true;
		}
    	return false;
    }


















    // tests

    @Test
    public void bothHalvesAreTheSameLengthTest() {
        final int[] half1 = {1, 4, 5};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 2, 3, 4, 5, 6};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertTrue(result);
    }

    @Test
    public void halvesAreDifferentLengthsTest() {
        final int[] half1 = {1, 5};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 2, 6, 3, 5};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertFalse(result);
    }

    @Test
    public void oneHalfIsEmptyTest() {
        final int[] half1 = {};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {2, 3, 6};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertTrue(result);
    }

    @Test
    public void shuffledDeckIsMissingCardsTest() {
        final int[] half1 = {1, 5};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 6, 3, 5};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertFalse(result);
    }

    @Test
    public void shuffledDeckHasExtraCards() {
        final int[] half1 = {1, 5};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 2, 3, 5, 6, 8};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertFalse(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Single_Shuffle.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}