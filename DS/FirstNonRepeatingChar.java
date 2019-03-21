/* Find the first letter in a string that does not have a pair. */
/* Time complexity: O(n) */

import java.util.*;

class FirstNonRepeatingChar
{
	public static void main(String args[])
	{
		String s = "abdccba";
		System.out.println("The first non-repeating character: " + nonRepeat(s));
	}

	static Character nonRepeat(String s)
	{
		Map<Character,Integer> map = new LinkedHashMap<>();

		for(int i=0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
			if(map.containsKey(ch))
				map.put(ch,map.get(ch)+1);
			else
				map.put(ch,1);
		
		}

		for(Map.Entry<Character,Integer> entry : map.entrySet())
		{
			if(entry.getValue() == 1)
				return entry.getKey();
		}

		return null;
	}

}