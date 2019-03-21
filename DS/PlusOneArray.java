/* Given an array representing a non-negative integer 
(ex: 123 represented as [1,2,3]), return the next integer (output: [1,2,4]). 
run through all edge cases (ex: [9,9,9,9,9,9,9,9] etc) */

import java.lang.*;
import java.util.*;

class PlusOneArray
{
	int[] plusOne(int[] number)
	{
		int carry =1 , sum;

		for(int i=number.length-1; i >=0; i--)
		{
			sum = number[i] + carry;
			carry = sum > 9 ? 1 : 0;
			number[i] = sum%10;
		}

		if(carry == 0)
			return number;
		else
		{
			int[] res = new int[number.length + 1];
			res[0] = carry;
			System.arraycopy(number, 0, res, 1, number.length);
			return res;
		}
	}
	
	public static void main(String args[])
	{
		PlusOneArray obj = new PlusOneArray();
		int[] number = {1, 0, 5};
		System.out.println("Actual Number Array: " + Arrays.toString(number));

		int[] result = obj.plusOne(number);
		System.out.println("Next Integer Array: " + Arrays.toString(result));
	}
}