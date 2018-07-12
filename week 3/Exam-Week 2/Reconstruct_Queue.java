import java.awt.print.Printable;
import java.util.*;

import junit.framework.Test;


public class Reconstruct_Queue {
	
	public static void main(String[] args) 
	{
		int [][] queue1 = new int [][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		reconstruct(queue1);
		int[][] queue2 = new int [][] {{12,0},{6,3},{3,4},{9,2}, {11,1},{1,5}};
		reconstruct(queue2);
		int[][] queue3 = new int [][] {{2,4}, {5,1}, {3,3}, {1,5}, {4,2}, {6,0}};
		reconstruct(queue3);
	}
	
	private static void print(int[][] temp) {
		// TODO Auto-generated method stub
		for(int i=0; i<temp.length;i++)
		{
			System.out.print("{ "+temp[i][0] +","+ temp[i][1]+" }");
		}
		System.out.println();
	}

	public static void reconstruct(int[][] people) {
	    int[][] result = new int[people.length][];
	    Arrays.sort(people, new Comparator<int[]>(){
	        public int compare(int[] a1, int[] a2){
	            if(a1[0]!=a2[0]){
	                return a2[0]-a1[0];
	            }else{
	                return a1[1]-a2[1];
	            }
	        }
	    });
	    
	    ArrayList<int[]> list = new ArrayList<int[]>();
//	    int s = list.size();
	    for(int i=0; i<people.length; i++){
	        int[] arr = people[i];
	        list.add(arr[1],arr);
	    }
	 
	    for(int i=0; i<people.length; i++){
	        result[i]=list.get(i);
	    }
	 
	    print(result);
	}
}
