import java.util.Arrays;
import java.util.Random;

public class Shuffle_Array {

    private static Random rand = new Random();

    private static int getRandom(int floor, int ceiling) {
        return rand.nextInt((ceiling - floor) + 1) + floor;
    }

    public static void shuffle(int[] theArray) {

        // shuffle the input in place
    	for (int i = 0; i < theArray.length; i++) {
			int RandPosition= rand.nextInt(theArray.length);
			int temp = theArray[i];
			theArray[i]= theArray[RandPosition];
			theArray[RandPosition]= temp;
		}   
    }

    public static void main(String[] args) {
        final int[] initial = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int[] shuffled = Arrays.copyOf(initial, initial.length);
        shuffle(shuffled);
        System.out.printf("initial array: %s\n", Arrays.toString(initial));
        System.out.printf("shuffled array: %s\n", Arrays.toString(shuffled));
    }
}