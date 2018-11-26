package stacks;
import java.util.*;


public class ReverseStrings
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		BoundedStackInterface<String> stack;
		stack = new ArrayStack<String>(3);
		
		String line;
		
		for (int i = 1; i <= 3; i++)
		{
			System.out.println("Enter a line of text ==> ");
			line = input.nextLine();
			stack.push(line);
		}
		
		System.out.println("\nThe reverse order of the lines you typed is: \n");
		
		while (!stack.isEmpty())
		{
			line = stack.top();
			stack.pop();
			System.out.println(line);
		}
	}
}
