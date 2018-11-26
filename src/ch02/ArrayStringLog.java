package ch02;
// Implements StringLogInterface using an array to hold the strings
public class ArrayStringLog implements StringLogInterface
{
	protected String name;			// name of this log
	protected String[] log;			// array that holds log strings
	protected int lastIndex = -1;	// position of last string in the array
	
	public ArrayStringLog(String name, int maxSize)
	{
		log = new String[maxSize];
		this.name = name;
	}
	
	public ArrayStringLog(String name)
	{
		log = new String[100];
		this.name = name;
	}

	public void insert(String element)
	{
		lastIndex++;
		log[lastIndex] = element;
	}
	
	public void clear()
	{
		for (int i = 0; i <= lastIndex; i++)
		{
			log[i] = null;
		}
		lastIndex = -1;
	}
	
	public boolean isFull()
	{
		return (lastIndex == (log.length - 1));
	}
	
	public int size()
	{
		return (lastIndex + 1);
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		String logString = "Log: " + name + "\n\n";
		for (int i = 0; i <= lastIndex; i++)
		{
			logString = logString + (i + 1) + ". " + log[i] + "\n";
		}
		
		return logString;
	}
	
	public boolean contains(String element)
	{
		int location = 0;
		
		while (location < lastIndex)
		{
			if (element.equalsIgnoreCase(log[location]))	return true;
			else											location++;
		}
		
		return false;
	}
	
}
