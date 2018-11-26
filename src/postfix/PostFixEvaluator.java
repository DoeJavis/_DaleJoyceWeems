package postfix;
import stacks.*;
import java.util.*;


/////// negative output from Q??? absolute value or leave negative?


public class PostFixEvaluator
{
	public static long evaluate(String expression)
	{
		BoundedStackInterface<Long> stack = new ArrayStack<Long>();
		
		long value;
		String operator;
		long operand1;
		long operand2;
		
		long result = 0;
		
		Scanner input = new Scanner (expression);
		
		while (input.hasNext())				// while the expression has more characters to be evaluated, do this
		{	// this first if statement will fire if the current character being evaluated in the expression is an operand
			if (input.hasNextLong())			// if the current character is an long
			{
				value = input.nextLong();	// assign the value of that long to the variable named value
				if (stack.isFull())			// and if the stack is full
					throw new PostFixException("Stack full | stack overflow!\n");
				stack.push(value);	// and if the stack is not full, then push the value of the current character onto the stack
			}
			// the else clause will fire if the current character being evaluated in the expression is an operator
			else
			{
				operator = input.next();	// if the current character is an operator
				if (stack.isEmpty())		// and if the stack is empty
					throw new PostFixException("Extra operator | not enough operands(1) | stack underflow!\n");
				
				operand2 = stack.top();		// take the value at the top of the stack an assign it to the operand2 variable
				stack.pop();				// and remove the value from the top of the stack
				
				if (stack.isEmpty())
					throw new PostFixException("Extra operator | not enough operands(2) | stack underflow!\n");
				
				operand1 = stack.top();		// take the value at the top of the stack an assign it to the operand2 variable
				stack.pop();				// and remove the value from the top of the stack
				
				// and perform the mathematical operation dictated by the operator
				if (operator.equals("+"))								result = operand1 + operand2;
				
				else if (operator.equals("-"))							result = operand1 - operand2;
				
				else if (operator.equals("*") || operator.equals("x"))	result = operand1 * operand2;
				
				else if (operator.equals("/"))
				{
					if (operand2 == 0)
						throw new PostFixException("Amigo, are you trying to end the universe? You know you can't divide by 0! Try again!\n");
					else												result = operand1 / operand2;
				}
				
				else if (operator.equals("^"))							result = (long) Math.pow(operand1, operand2);		// will result = operand1 ^ operand 2; work?
				
				else if (operator.equalsIgnoreCase("Q"))				result = (long) Math.floor(Math.sqrt(operand2));		// operand2 ^ (1/2)
				
				else if (operator.equalsIgnoreCase("C"))				result = (long) Math.floor(Math.cbrt(operand2));		// operand2 ^ (1/3);
				
				else if (operator.equals("<"))							result = operand1 << operand2;	// found on p.199 in the 1510 Java textbook
				
				else if (operator.equals(">"))							result = operand1 >> operand2;	// ?????????
				
				else if (operator.equals("%"))							result = operand1 % operand2;	
				
				// if the symbol entered is not any of the above listed, then throw 
				else
					throw new PostFixException("Danger, Will Robinson! Danger! You have an illegal symbol: " + operator + "\n");
				
				stack.push(result);		
			}
		}
		
		// Now run the final check to make sure the stack is cleared out after the entire expression has been evaluated. If
		// we had a solid expression at the beginning, we should have an empty stack after we pop the last entry of the stack
		// and assign it to our result.
		
		// We need to first check if the stack is currently empty before we try popping anything off. If it's empty when we
		// try to pop, we will get an underflow message.
		
		// if the stack is empty then tell the user they don't have enough operands to perform the expression b/c it's unbalanced
		if (stack.isEmpty())
			throw new PostFixException("Unable to finish. The expression is not balanced; not enough operands in relation to"
									+ " operators!\n");
		
		// If we pass that test, then take that value and assign it to result and pop it off
		result = stack.top();
		stack.pop();
		
		// And if the stack still contains some value after popping off (what should be) the last value, then alert the user
		
		if (!stack.isEmpty())
			throw new PostFixException("Unable to complete. The expression is not balanced; there are too many operands in"
									+ " relation to operators!");
		return result;
	}
}
