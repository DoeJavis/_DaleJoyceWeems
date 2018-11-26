package ch02;

public class LinkedStringLog implements StringLogInterface
{
	protected LLStringNode log;	// reference to the first node of linked list that holds the StringLog strings
	protected String name;		// name of this particular StringLog
	
	public LinkedStringLog (String name)
	{
		log = null;
		this.name = name;
	}
	
	
	public void insert(String element)
	{
		LLStringNode newNode = new LLStringNode (element);
		newNode.setLink(log);
		log = newNode;
	}
	
	public boolean isFull()
	{
		return false;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int size()
	{
		int count = 0;
		LLStringNode node;
		node = log;
		while (node != null)
		{
			count++;
			node = node.getLink();
		}
		return count;
	}
	
	public String toString()
	{
		String logString = "Log: " + name + "\n\n";
		LLStringNode node;
		node = log;
		int count = 0;
		
		while (node != null)
		{
			count++;
			logString = logString + count + ". " + node.getInfo() + "\n";
			node = node.getLink();
		}
		return logString;
	}
	
	public boolean contains(String element)
	{
		LLStringNode node;
		node = log;
		
		while (node != null)
		{
			if (element.equalsIgnoreCase(node.getInfo()))
				return true;
			else
				node = node.getLink();
		}
		return false;
	}
	
	public void clear()
	{
		log = null;
	}
	
	
	
	
	
}
