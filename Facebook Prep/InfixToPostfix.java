/* Convert infix to postfix and evaluate postfix expression.
Postfix expressions are evaluated faster compared to Infix */

import java.util.*;

class InfixToPostfix
{
	public static void main(String args[])
	{
		String exp = "t-g+t-w";
		String postFix = convert(exp);
		System.out.println("Postfix: " + postFix);

		System.out.println("Evaluated Result: " + evaluatePostfix(postFix));
	}

	static int evaluatePostfix(String postfix)
	{
		HashMap<Character,Integer> map = new HashMap<>();
		map.put('g', 2);
		map.put('p', 3);
		map.put('t', 1);
		map.put('w', 2);

		Stack<Integer> stack = new Stack<Integer>();
		//use 'C' - 'A' for alphabetical value

		for(int i=0; i<postfix.length(); i++)
		{
			char ch = postfix.charAt(i);

			if(Character.isLetterOrDigit(ch))
			{
				if(map.containsKey(ch))
				{
					int dig = map.get(ch);
					stack.push(dig);
				}
				else
				{
					System.out.println("Can't proceed...INVALID!");
					System.exit(0);
				}
			}
			else
			{
				int val1 = stack.pop();
				int val2 = stack.pop();

				switch(ch)
				{
					case '+':
						stack.push(val2+val1);
						break;

					case '-':
						stack.push(val2-val1);
						break;

					case '*':
						stack.push(val2*val1);
						break;

					case '/':
						stack.push(val2/val1);
						break;

					case '%':
						stack.push(val2%val1);
				}
			}
		}

		return stack.pop();

	}

	static int calcPrec(char ch)
	{
		switch(ch)
		{
			case '+':
			case '-':
				return 1;

			case '*':
			case '/':
			case '%':
				return 2;

			case '^':
				return 3;
		}

		return -1;
	}

	static String convert(String exp)
	{
		String res = "";
		Stack<Character> stack = new Stack<Character>();

		for(int i=0; i<exp.length(); i++)
		{
			char c = exp.charAt(i);

			if(Character.isLetterOrDigit(c))
				res += c;
			else if (c == '(')
				stack.push(c);

			else if(c == ')')
			{
				while(!stack.isEmpty() && stack.peek() != '(')
					res += stack.pop();

				if(!stack.isEmpty() && stack.peek() != '(')
					return "Invalid";
				else
					stack.pop();
			}
			else
			{
				while(!stack.isEmpty() && calcPrec(c) <= calcPrec(stack.peek()))
					res += stack.pop();

				stack.push(c);
			}
		}

		while(!stack.isEmpty())
			res += stack.pop();

		return res;
	}
}