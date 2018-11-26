package stacks;

public class Balanced
{
//	private String openSet;
//	private String closeSet;
//	
	public Balanced(String openSet, String closeSet)
	{
		this.openSet = openSet;
		this.closeSet = closeSet;
	}
	
	public static String openSet;
	public static String closeSet;
	
	public static long test(String expression)
	// Returns 0 for balanced
	// Returns 1 for unbalanced symbols
	// Returns 2 for uneven number of open and close characters
	{
		char currChar;			// current character being examined
		long currCharIndex;		// index of current character
		long lastCharIndex;		// index of last character in expression
		
		long openIndex;			// index of current character in openSet
		long closeIndex;		// index of current character in closeSet
		
		boolean stillBalanced = true;
		
		BoundedStackInterface<Long> stack;	// stack to hold the open symbols until they can be matched and popped off
		stack = new ArrayStack<Long> (expression.length());	// initialize the stack as type ArrayStack with parameter of Integer with size equal to the length of the expression
		
		currCharIndex = 0;		// set the current character index at the beginning of the expression
		lastCharIndex = expression.length() - 1;
		
		while (stillBalanced && (currCharIndex <= lastCharIndex))
		// While expression is still balanced and not at the end of the expression
		{
			currChar = expression.charAt((int) currCharIndex);
			openIndex = openSet.indexOf(currChar);
			
			if (openIndex != -1)		// if the current character is part of the openSet
			{
				stack.push(openIndex);	// push the location index onto the stack
			}
			else
			{
				closeIndex = closeSet.indexOf(currChar);	// 
				if (closeIndex != -1)	// if the current character is in the closeSet
				{
					try					// try to pop the topMost openIndex off the stack
					{
						openIndex = stack.top();
						stack.pop();
						
						if (openIndex != closeIndex)	stillBalanced = false;	// if the openIndex doesn't match the closeIndex, set stillBalanced to false b/c the expression isn't balanced
					}
					catch (StackUnderflowException ex)	// if the stack was empty
					{
						stillBalanced = false;			// keep the expression as unbalanced
					}
				}
			}
			currCharIndex++;		// move to the next character
		}
		
		if (!stillBalanced)			return 1;		// expression ended, stack empty, is unbalanced 
		else
			if (!stack.isEmpty())	return 2;		// expression ended, stack still had elements, and needed more close characters to be balanced
			else					return 0;		// expression ended, stack empty, is balanced
	}
}