/* Given a string baaabab, check if a wildcard pattern e.g. ba*b matches" */
/*  Use DP programming approach */

/*Time Complexity: O(m*n) where m is pattern length and n is string */

class WildcardRegexMatch
{
	public static void main(String args[])
	{
		String str = "mississippi";
		String pat = "mis*is*p*";

		if(isMatch(str,pat))
			System.out.println("yes");
		else
			System.out.println("No");
	}

	static boolean isMatch(String s,String p)
	{
		if(s==null || p==null)
			return false;

		boolean[][] dp = new boolean[s.length()+1][p.length()+1];

		//empty pattern can match with empty string
		dp[0][0] = true;

		for(int i=0; i<p.length(); i++)
		{
			if(p.charAt(i) == '*' && dp[0][i-1])
				dp[0][i+1] = true;
		}

		for(int i =0; i<s.length(); i++)
		{
			for(int j=0; j<p.length(); j++)
			{
				if(p.charAt(j) == '.')
					dp[i+1][j+1] = dp[i][j];

				if(p.charAt(j) == s.charAt(i))
					dp[i+1][j+1] = dp[i][j];

				if(p.charAt(j) == '*')
				{
					if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.')
                    	dp[i+1][j+1] = dp[i+1][j-1];
                	else
                    	dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                
				}
			}
		}
		return dp[s.length()][p.length()];
 	}
}
