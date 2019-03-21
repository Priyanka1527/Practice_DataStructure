/* Find the smallest window in a string containing 
all characters of another string

Input :  string = "this is a test string"
         pattern = "tist"
Output :  Minimum window is "t stri"

Use 2 pointers for linear time complexity

1: Start with left and right pointers in the beginning
2: Move right forward and continue till a statisfied window is found
3: Whenever window found, move left pointer forward to minimize
4: keep on doing that until shortest windows is found
*/

import java.util.*;
import java.lang.*;

class SmallestWindowString
{
	public static void main(String args[])
	{
		String str = "this is a test string";
		String pat = "tist";

		System.out.println("Smallest Window: " + findWindow(str,pat));
	}

	//Function to track the characters and their frequencies to be covered
	static Map<Character,Integer> buildMapping(String s)
	{
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0; i<s.length(); i++)
		{
			int frequency = map.getOrDefault(s.charAt(i),0);
			map.put(s.charAt(i),frequency+1);
		}

		return map;
	}

	static void addCharacterToHashtableMapping(Map<Character, Integer> map, Character c)
	{
		int occurrences = map.getOrDefault(c, 0);
  		map.put(c, occurrences + 1);
	}
  
	static String findWindow(String str, String pat)
	{
		Map<Character,Integer> required = buildMapping(pat);
		Map<Character,Integer> windowsMapping = new HashMap<Character,Integer>();

		int left=0, right=0;

		//These need to be equal later on for a perfect match to get
		int totalFrequencyToMatch = required.size();
		int totalFrequencyMatched = 0;

		int minWindowSize = Integer.MAX_VALUE;
		String minWindow = "";

		while(right < str.length())
		{
			//Store the character at right pointer to windowsMapping
			char charAtRight = str.charAt(right);
			addCharacterToHashtableMapping(windowsMapping,charAtRight);

			//Check if this character is required
			if(required.containsKey(charAtRight))
			{
				//Check if the frequency of this character is same as what required
				if(required.get(charAtRight).intValue() == windowsMapping.get(charAtRight).intValue())
				{
					totalFrequencyMatched ++;
				}
			}

			//Now check if this window satisfies the pattern requirement, if so, move left pointer
			while(totalFrequencyMatched == totalFrequencyToMatch && left <= right)
			{
				char charAtLeft = str.charAt(left);
				int windowSize = right - left + 1;

				if(windowSize < minWindowSize)
				{
					minWindowSize = windowSize;
					minWindow = str.substring(left,right+1);
				}

				//If window shrinks, this frequency will be reduced
				windowsMapping.put(charAtLeft, windowsMapping.get(charAtLeft).intValue()-1);

				//check if this is required character and the reduction affects our criteria, if so, then back to square one
				if(required.containsKey(charAtLeft))
				{
					if(windowsMapping.get(charAtLeft).intValue() < required.get(charAtLeft).intValue())
					{
						totalFrequencyMatched --;
					}
				}

				left++;
			}
			right++;
		}

		return minWindow;
	}
}

