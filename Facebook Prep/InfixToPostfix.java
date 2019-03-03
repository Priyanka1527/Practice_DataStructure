/* Convert infix to postfix and evaluate postfix expression. */

import java.util.*;

class InfixToPostfix
{
	public static void main(String args[])
	{
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(convert(exp));
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