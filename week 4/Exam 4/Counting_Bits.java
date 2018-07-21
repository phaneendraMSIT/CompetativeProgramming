import java.util.*;

public class Counting_Bits {
	public static void main(String[] args) {
		
		count(15);
		count(16);
		count(1);
		count(25);
		count(5);
		count(6);
	}

	private static void count(int n) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list= new ArrayList<>();
		for(int i=0;i<=n;i++ )
		{
			list.add(binary(i));
			
		}
		
		System.out.println(list);		
	}

	private static int binary(int i) {
		// TODO Auto-generated method stub
		String temp = Integer.toBinaryString(i);
		int count =0;
		for(int j =0;j<temp.length();j++)
		{
			if (temp.charAt(j)=='1') {
				count++;
			}
		}
		
		return count;
	}

}
