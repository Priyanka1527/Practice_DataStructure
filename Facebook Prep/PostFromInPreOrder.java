/* 19. Given a Pre-Order and In-Order string of a binary tree, 
can we and if we can, construct the "Post-Order" String.

Time Complexity: O(n) using hashmap */

import java.util.*;

class PostFromInPreOrder
{
	static int preIndex = 0;
	public static void main(String ars[])  
    {  
        int in[] = { 4, 2, 5, 1, 3, 6 };  
        int pre[] = { 1, 2, 4, 5, 3, 6 };  
    	printPostMain(in, pre);  
    	System.out.println();
    } 

    static void printPost(int[] in, int[] pre, int inStart, int inEnd, HashMap<Integer,Integer> map)
    {
    	if(inStart > inEnd)
    		return;

    	int inIndex = map.get(pre[preIndex++]);

    	//Recurse Left subtree
    	printPost(in,pre,inStart,inIndex-1,map);

    	//Recure Right Subtree
    	printPost(in,pre,inIndex+1,inEnd,map);

    	//Print the root in the end
    	System.out.print(in[inIndex] + " ");
    }

    static void printPostMain(int[] in, int[] pre)
    {
    	int n = in.length;
    	HashMap<Integer,Integer> map = new HashMap<>();

    	for(int i=0; i<n; i++)
    		map.put(in[i],i);

    	printPost(in, pre, 0, n-1, map);
    }
}