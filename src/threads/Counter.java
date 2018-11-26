package threads;

public class Counter
{
	private int count;
	
	public Counter()
	{
		count = 0;
	}
	
	public void increment()
	{
		count++;
	}
	
	public String toString()
	{
		return "Count is: \t " + count;
	}
	
	
	
	
}
