package postfix;
import java.util.Scanner;

public class PFixConsole
{
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		String line = null;
		String more = null;
		
		long result;
		long count = 0;
		
		do
		{
			if (count == 0)		System.out.println("*PFixConsole*");
			System.out.println("Enter a postfix expression to be evaluated: ");
			line = input.nextLine();
			
			try
			{
				result = PostFixEvaluator.evaluate(line);
				
				System.out.println("\nResult = " + result);
				
			}
			catch (PostFixException ex)
			{
				System.out.println("Error in expression: " + ex.getMessage() + "\n");
			}
			
			System.out.println("\nEvaluate another expression? (Y = Yes): ");
			more = input.nextLine();
			System.out.println();
			count++;
		}
		while (more.equalsIgnoreCase("y"));
		System.out.println("Program completed.");
	}

}
