/* Given a number of size <= 999 billion, return its String representation 
(for 123, return "One Hundred Twenty Three," not "123") */

import java.util.*;

class NumberToString
{
	static String[] placeValues = { "", "hundred", "thousand", "lakh", "crore" ,"billion"};

	static String[] uniPlaceValues = { "", "hundred", "thousand", "million", "billion" };

	static String[] tens = { "", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eigty", "nighty" };
	static String[] oneTo20 = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fournteen", "fifteen", "sixteen", "seventeen", "eighteen", "ninteen", "twenty" };
	
	public static void main(String args[])
	{
		String number = "999000600700";
		System.out.println("Number : " + number);
		printUniversalSystem(number);
	}

	static void printUniversalSystem(String number) {
		ArrayList<String> nums = getNumbers(number,3);
		System.out.println("Universal Standard");
		printUniversalWords(nums);
	}

	static void printUniversalWords(ArrayList<String> nums)
	{
		String word = "";
		for (int i = 0; i < nums.size(); i++) {
			int num = Integer.valueOf(nums.get(i));
			// if number at any place-value is 0 then no need to print
			if (num != 0) {
				word = getThreeDigitWord(num) + uniPlaceValues[i] + " " + word;
			}
		}
		System.out.println(word);
	}

	static String getThreeDigitWord(int num)
	{
		String word = "";
		if (num < 100) {
			word = getTwoDigitWord(num);
		} else {
			int rem = num % 100;
			int q = num / 100;
			word = oneTo20[q] +" hundred "+ getTwoDigitWord(rem);
		}
		return word;
	}

	static String getTwoDigitWord(int num)
	{
		String word = "";
		if (num <= 20) {
			word = oneTo20[num] + " " + word;
		} else {
			int first = num % 10;
			int second = num / 10;
			word = tens[second] + " " + oneTo20[first] + " " + word;
		}
		return word;
	}

	static ArrayList<String> getNumbers(String numberStr, int maxDigits)
	{
		numberStr = new StringBuilder(numberStr).reverse().toString();
		int length = numberStr.length();
		ArrayList<String> numbers = new ArrayList<>();
		int digits = 0;
		String num = "";

		for (int i = 0; i < length; i++) {
			if(i==0){
				num = String.valueOf(numberStr.charAt(i));
			}else if(i==1){
				num = String.valueOf(numberStr.charAt(i)) + num;
				digits=maxDigits;
			}
			else if (i == 2) {
				num = String.valueOf(numberStr.charAt(i));
				digits=maxDigits;
			} else {
				num = String.valueOf(numberStr.charAt(i)) + num;
				digits++;
			}
			if (digits == maxDigits || i == length - 1) {
				numbers.add(num);
				digits = 0;
				num="";
			}

		}
		return numbers;
	}
}