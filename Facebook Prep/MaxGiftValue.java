/* Given a 2D array of gifts, find path from top left to bottom right corner with greatest aggregated gift values.
 Time Complexity: O(m*n) where m and n are row and column of 2D Matrix 
 Approach: DP */

 class MaxGiftValue
 {
 	public static void main(String args[])
 	{
 		int[][] M = {
 			{2, 3, 1, 4},
 			{1, 3, 2, 1},
 			{4, 5, 3, 1},
 			{7, 1, 4, 1}
 		};

 		System.out.println("Max Gift Value: " + findMax(M));
 	}

 	static void printMatrix(int [][] P) {
		for (int i=0; i<P.length; i++) {
			for (int j=0; j<P[0].length; j++) {
				System.out.print(P[i][j] + " ");
			}
			System.out.println();
		}
	}

 	static int findMax(int[][] M)
 	{
 		int row = M.length;
 		int col = M[0].length;

 		int[][] dp = new int[row][col];

 		for(int i=0; i<row; i++)
 		{
 			System.out.println();
 			printMatrix(dp);

 			for(int j=0; j<col; j++)
 			{
 				if(i==0 && j==0)
 					dp[i][j] = M[i][j];

 				else if(i==0)
 					dp[i][j] = dp[i][j-1] + M[i][j];

 				else if(j==0)
 					dp[i][j] = dp[i-1][j] + M[i][j];
 				else
 					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]) + M[i][j];
 			}
 		}
 		System.out.println();
 		printMatrix(dp);
 		return dp[row-1][col-1];
 	}
 }