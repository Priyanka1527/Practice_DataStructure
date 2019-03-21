/* Print all distinct characters of a string in order */

/* Time Complexity: First approach O(n) with 2 traversal
					Second one O(n) with 1 traversal */

import java.util.*;
import java.util.Map.Entry;
class DistinctLettersInString
{
	public static void main(String args[])
	{
		String str = "Hello Geeks";
		countLetter1(str);
		System.out.println();
		countLetter2(str);
		System.out.println();
	}

	//Using extra Traversal of the string
	static void countLetter1(String str)
	{
		char[] count = new char[256];

		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i) != ' ')
				count[str.charAt(i)] ++;
		}

		for(int i=0; i<str.length(); i++)
		{
			if(count[str.charAt(i)] == 1)
				System.out.print(str.charAt(i));
		}
	}

	//Using HashMap
	static void countLetter2(String str)
	{
		//HashMap doesn't preserve the order, hence used LinkedHashMap
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();

		for(int i=0; i<str.length(); i++)
		{
			Character ch = str.charAt(i);
			if(ch != ' ')
			{
				if(!map.containsKey(ch))
				map.put(ch,1);
			else
				map.put(ch,map.get(ch)+1);
			}
			
		}

		for(Entry entry: map.entrySet())
		{
			Character ch = (Character)entry.getKey();
			int value = (Integer)entry.getValue();

			if(value == 1)
				System.out.print(ch);
		}
	}
}

