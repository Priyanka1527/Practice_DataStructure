/* Given a friendship relationship matrix, count friend circle */
/* don't count friend circle if there is transitive relation,
as they would be counted as 1 circle with indirect frienship */

class FriendCircleCount
{
	static int[] visited;
	public static void main(String args[])
 	{
 		int[][] M = {
 			{1, 1, 0},
 			{1, 1, 0},
 			{0, 0, 1}
 		};

 		System.out.println("No. of Friend Circle: " + findCircle(M));
 	}

 	static void DFS(int[][] M, int i)
 	{
 		visited[i] = 1;

 		for(int j=0; j<M.length; j++)
 		{
 			if(M[i][j] == 1 && visited[j] == 0 && i != j)
 				DFS(M,j);
 		}
 	}

 	static int findCircle(int[][] M)
 	{
 		int count = 0;
 		visited = new int[M.length];

 		for(int i=0; i<M.length; i++)
 		{
 			for(int j=0; j<M.length; j++)
 			{
 				if(M[i][j] == 1 && visited[j] == 0)
 				{
 					count++;
 					DFS(M,j);
 				}
 			}
 		}
 		return count;
 	}
}