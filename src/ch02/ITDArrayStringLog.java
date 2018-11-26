package ch02;
import java.util.*;

public class ITDArrayStringLog
{
	public static void main(String[] args)
	{
		ArrayStringLog test = new ArrayStringLog("Testing");
		Scanner input = new Scanner(System.in);
		
		String skip;		// skip end of the line after reading an integer
		boolean keepGoing;	// flag for "choose operation" loop
		int constructor; 	// indicates user's choice of constructor
		int operation;		// indicates user's choice of operation
		
		System.out.println("What is the name of this test?");
		String testName = input.nextLine();
		System.out.println("\nThis is test " + testName + "\n");
		
		System.out.println("Choose a constructor: ");
		System.out.println("1: ArrayStringLog(String name)");
		System.out.println("2: ArrayStringLog(String name, int maxSize");
		if (input.hasNextInt())
		{
			constructor = input.nextInt();
		}
		else
		{
			System.out.println("Error: you must enter an integer");
			System.out.println("Terminating test.");
			return;				
		}
		
		skip = input.nextLine();
		
		switch (constructor)
		{
		case 1:
			test = new ArrayStringLog(testName);
			break;
		
		case 2:
			System.out.println("Enter a maximum size: ");
			int maxSize;
			if (input.hasNextInt())	
			{
				maxSize = input.nextInt();
			}
			else
			{
				System.out.println("Error: you must enter an integer");
				System.out.println("Terminating test.");
				return;
			}
			skip = input.nextLine();
			test = new ArrayStringLog(testName, maxSize);
			break;
			
		default:
			System.out.println("Error in constructor choice. Terminating test");
			return;
		}
		
		keepGoing = true;
		while (keepGoing)
		{
			System.out.println("\nChoose an operation: ");
			System.out.println("1: insert(String element)");
			System.out.println("2: clear()");
			System.out.println("3: contains(String element)");
			System.out.println("4: isFull()");
			System.out.println("5: size()");
			System.out.println("6: getName()");
			System.out.println("7: show contents");
			System.out.println("8: stop testing");
			
			if (input.hasNextInt())
			{
				operation = input.nextInt();
			}
			else
			{
				System.out.println("Error: you must enter an integer.");
				System.out.println("Terminating test.");
				return;
			}
			
			skip = input.nextLine();
			
			switch (operation)
			{
				case 1:		// insert
					System.out.println("Enter a string to insert: ");
					String insertString = input.nextLine();
					test.insert(insertString);
					break;
				
				case 2:		// clear
					test.clear();
					break;
					
				case 3:		// contains
					System.out.println("Enter a string to search for: ");
					String searchString = input.nextLine();
					System.out.println("Result: " + test.contains(searchString));
					break;
					
				case 4:		// isFull
					System.out.println("Result: " + test.isFull());
					break;
					
				case 5:		// size
					System.out.println("Result: " + test.size());
					break;
					
				case 6:		// getName
					System.out.println("Result: " + test.getName());
					break;
					
				case 7:		// show contents
					System.out.println(test.toString());
					break;
					
				case 8:		// stop testing
					keepGoing = false;
					break;
					
				default:
					System.out.println("Error in operation choice. Terminating test.");
					return;
			}
		}
		System.out.println("End of Interactive Test Driver");
	}
}
