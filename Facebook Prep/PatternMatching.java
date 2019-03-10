/* Find a needle in haystack: given two c-strings (null terminated), 
return a pointer to the location of where the needle occurs in the haystack, 
NULL otherwise. 

Naive Approach: O(m*(n-m + 1)) where m - pattern and n - string
KMP Approach : O(n) 

Reference: https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/ */

class PatternMatching
{
	public static void main(String args[])
	{
		String txt = "AABAACAADAABAABA";
		String pat = "AABA";

		findMatch(txt,pat);
		System.out.println("Using KMP: ");
		matchKMP(txt,pat);
	}

	static void computerTrack(String pat, int m, int[] track)
	{
		int len = 0;
		int i = 1;
		track[0] = 0;

		while(i<m)
		{
			if(pat.charAt(i) == pat.charAt(len))
			{
				len++;
				track[i] = len;
				i++;
			}
			else
			{
				if(len != 0)
					len = track[len-1];
				else
				{
					track[i] = len;
					i++;
				}
				
			}
		}
	}

	static void matchKMP(String txt, String pat)
	{
		int n = txt.length();
		int m = pat.length();

		int track[] new int[m];
		int j=0;

		computeTrack(pat,m,trac);

		int i=0;
		while(i<n)
		{
			if(pat.charAt[j] == txt.charAt[i])
			{
				j++;
				i++;
			}

			if(j==m)
			{
				System.out.println("Pattern found at: " + (i-j));
				j = track[j-1];
			}

			else if(i<n && pat.charAt(j) != txt.charAt(i))
			{
				if(j != 0)
					j = track[j-1];
				else
					i++;
			}
		}
	}

	static void findMatch(String txt, String pat)
	{
		int n = txt.length();
		int m = pat.length();

		for(int i=0; i<=n-m; i++)
		{
			int j;
			for(j=0; j<m; j++)
			{
				if(txt.charAt(i+j) != pat.charAt(j))
					break;

			}

			if(j == m)
				System.out.println("Pattern found at: " + i);
		}
	}
}