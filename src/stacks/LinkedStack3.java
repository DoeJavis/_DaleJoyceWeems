package stacks;
import support.LLNode;

public class LinkedStack3<T> extends LinkedStack<T>
{
	public void printReversed()
	{
		UnboundedStackInterface<T> stack = new LinkedStack<T>();
		LLNode<T> listNode;
	
		listNode = top;
		
		while (listNode != null)		// put references onto the stack
		{
			stack.push(listNode.getInfo());
			listNode = listNode.getLink();
		}
		
		while (!stack.isEmpty())		// retrieve references in reverse order and print the elements
		{
			System.out.println(" " + stack.top());
			stack.pop();
		}
	}
	
	
}
