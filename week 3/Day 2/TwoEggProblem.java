import java.util.Scanner;

public class TwoEggProblem {

    public static int myFunction(int n, int k) {

        // write the body of your function here
    	int eggFloor[][] = new int[n+1][k+1];
    	int res;
    	int i,j,x;
    	for (i = 1; i < n; i++) {
			eggFloor[i][1] = 1;
			eggFloor[i][0] = 0;
		}
    	
    	for(j=1;j<=k;j++)
    	{
    		eggFloor[1][j]=j;
    	}
    	
    	for(i=2;i<=n;i++)
    	{
    		for(j=2;j<=k;j++)
    		{
    			eggFloor[i][j] = Integer.MAX_VALUE;
    			for(x = 1; x <= j;x++)
    			{
    				res = 1+Math.max(eggFloor[i-1][x-1],eggFloor[i][j-x]);
    				if (res<eggFloor[i][j]) {
						eggFloor[i][j]=res;
					}
    			}
    		}
    	}
        return eggFloor[n][k];
    }

    public static void main(String[] args) {

        // run your function through some test cases here
        // remember: debugging is half the battle!
//        String testInput = "test input";
    	@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	int k = in.nextInt();
        System.out.println(myFunction(n,k));
    }
}