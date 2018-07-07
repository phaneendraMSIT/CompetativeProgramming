import java.util.*;
public class Couple_Holding_Hands {
	public static void main(String[] args) {
		
		int[] Test1= new int[] {1,3,4,0,2,5};		
		System.out.println("Test 1: "+minmumswap(Test1));
		int[] Test2= new int[] {3,2,0,1};
		System.out.println("Test 2: "+minmumswap(Test2));
		int[] Test3= new int[] {3,30,50,90,16,91,65,18,61,58};
		System.out.println("Test 3: "+minmumswap(Test3));
		int[] Test4= new int[] {3,1,5,4,6,2};
		System.out.println("Test 4: "+minmumswap(Test4));
		int[] Test5= new int[] {55,37,19,46,66,32,07,81,33,76,00,28,92,26,99,06,56,29,17,52,90,79,91,83,12,40,82,84,02,21,11,68,98,34,73,10,57,58,64,36};
		System.out.println("Test 5: "+minmumswap(Test5));
		int[] Test6= new int[] {1,0};
		System.out.println("Test 6: "+minmumswap(Test6));
		int[] Test7=new int[] {50,23,76,19,16,70,35,68,41,49,99,71,59,95,89,33,22,07,54,83,24,0, 18,64,11,14,77,26,42,21,82,1,97,52,65,79,37,62,60,91,98,4,88,36,51,20,85,90,29,84,93,13,80,6,55,48,2,40,46,81,30,3,94,38,27,31,53,86,32,96,8,58,73,5};
		System.out.println("Test 7: "+minmumswap(Test7));
		
	}

	private static int minmumswap(int[] input) {
		// TODO Auto-generated method stub
		int temp =0;
		int n = input.length;
		for (int i = 0; i < input.length; i+=2) {
			if ((input[i+1]^input[i]) == 1 ) {
				
				continue;
			}
			++temp ;
			for(int j = i+1;j<n;++j)
			{
				if(input[j]== (input[i+1]^1))
				{
					input[j] = input[i+1];
					input[i+1]= input[i]^1;
					break;
				}
			}
			
		}
		System.out.println(Arrays.toString(input));;
		return temp;
	}
	
}
