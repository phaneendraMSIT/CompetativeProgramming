import java.util.Random;

class SevenSide_Dice {

    private static final Random rnd = new Random();

    private static int rand5() {
        return rnd.nextInt(5) + 1;
    }

    public static int rand7() {

        // implement rand7() using rand5()
        int v = 21;
        while (v>20) {
			v = rand5()+rand5()*5-6;			
		}
    	
        return 1+v%7;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 14; i++) {
            System.out.printf("%d ", rand7());
        }
        System.out.println();
    }
}