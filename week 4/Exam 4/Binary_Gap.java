import java.util.*;

@SuppressWarnings("unused")
public class Binary_Gap {
	public static void main(String[] args) {
		
//		System.out.println(maxConsecutiveOnes(0));
//		System.out.println(maxConsecutiveOnes(55));
//		System.out.println(Integer.toBinaryString(55));
		System.out.println(maxConsecutiveOnes(-5));
		System.out.println(Integer.toBinaryString(-5));
		System.out.println(maxConsecutiveOnes(12354));
		System.out.println(maxConsecutiveOnes(6));
		
		System.out.println(maxConsecutiveOnes(256));
	}
	
	private static int maxConsecutiveOnes(int x)
    {
       
        int count = 0;
 
        while (x!=0)
        {
            x = (x & (x << 1));
 
            count++;
        }
 
        return count;
    }

}
