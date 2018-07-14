import java.util.*;


public class Hamming_Distance {
	public static void main(String[] args) {
		
		System.out.println(distance(1, 4));
		System.out.println(distance(25,30));
		System.out.println(distance(100, 250));
		System.out.println(distance(1, 30));
		System.out.println(distance(0, 255));
	}

	private static int distance(int i, int j) {
		// TODO Auto-generated method stub
		
		
		String[] biti = Converttobit(i); 				
		String[] bitj = Converttobit(j);
		System.out.println(Arrays.toString(biti));
		System.out.println(Arrays.toString(bitj));
		int count = 0;
		int k=0,n=0;
		while(k<biti.length && n<bitj.length)
		{
			if (!biti[k].equals(bitj[n])) {
				count++;
			}
			k++;
			n++;
		}
		return count;
	}

	private static String[] Converttobit(int i) {
		// TODO Auto-generated method stub
		String[] temp = Integer.toBinaryString(i).split("");
		StringBuilder builder = new StringBuilder();
		int k=0;
		if (temp.length<8) {
			for (int j = 0; j < 8-temp.length; j++) {
				builder.append("0");
			}
			while (k<temp.length) {
				builder.append(temp[k]);
				k++;				
			}
			temp = builder.toString().split("");
		}
		
		return temp;
	}

}
