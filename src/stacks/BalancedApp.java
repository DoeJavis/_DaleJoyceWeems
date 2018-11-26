package stacks;
import java.util.*;

public class BalancedApp
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		Balanced bal = new Balanced("([{", ")]}");
		
		long result;
		long count = 0;
		
		String expression = null;
		String more = null;
		
		do
		{
			// Get next expression to be processed
			if (count == 0)		System.out.println("*BalancedApp*");
			
			System.out.println("Enter an expression to be evaluated: ");
			expression = input.nextLine();
			
			// Run the test method and output the result
			result = bal.test(expression);
			if (result == 1)		System.out.println("Expression ended | stack empty | unbalanced with too many close characters");
			else if (result == 2)	System.out.println("Expression ended | stack not empty | unbalanced with too many open characters");
			else 					System.out.println("Expression ended | stack empty | balanced");
			
			count++;
			// See if there is another expression to evaluate
			System.out.println("\nEvaluate another expression? (Y=Yes): ");
			more = input.nextLine();
			System.out.println();
		}
		while (more.equalsIgnoreCase("y"));
	}
}
