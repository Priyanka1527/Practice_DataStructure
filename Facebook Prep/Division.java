/* Perform division without using Division/Multiplication operator */
/* Time complexity : O(a) where a is the dividend */

class Division
{
	public static void main(String args[])
	{
		int a = 10;
		int b = -5;

		int result = divide(a,b);
		System.out.println("Result: " + result);
	}

	static int divide(int a,int b)
	{
		int res=0, sign=1;
		if(a<0)
		{
			a = -a;
			sign = -sign;
		}

		if(b<0)
		{
			b = -b;
			sign = -sign;
		}

		while(a>=0)
		{
			a = a-b;
			res ++;
		}

		return((res-1)*sign);
	}
}