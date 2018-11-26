package ch02;

public class UseStringLog
{
	public static void main(String[] args)
	{
		StringLogInterface sample = new ArrayStringLog("Example Use");
		
		sample.insert("Elvis");
		sample.insert("King Louis X");
		sample.insert("Captain Kirk");
		
		System.out.println(sample);
		System.out.println("The sixe of the log is " + sample.size());
		System.out.println("Elvis is in the log: " + sample.contains("Elvis"));
		System.out.println("Santa is in the log: " + sample.contains("Santa"));
		
	}
}
