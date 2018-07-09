import java.util.Random;


class FiveSide_Dice {

    private static final Random rnd = new Random();

    private static int rand7() {
        return rnd.nextInt(7) + 1;
    }

    public static int rand5() {

        // implement rand5() using rand7()
    	int x=rand7();
		if ( x <= 5) {
			return x;
		}
		else {
			rand5();
		}
        return 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d ", rand5());
        }
        System.out.println();
    }
}