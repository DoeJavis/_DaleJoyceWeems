package stacks;
import support.LLNode;

public class LinkedStack<T> implements UnboundedStackInterface<T>
{
	protected LLNode<T> top;	// reference to the top of this stack
	int size;
	
	public LinkedStack()
	{
		this.top = null;
		this.size = 0;
	}

	public void push(T element)
	{
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(top);
		top = newNode;
		size++;
	}
	
	public void pop()
	{
		if (!isEmpty())
		{
			top = top.getLink();
			size--;
		}
		else
			throw new StackUnderflowException("Can't pop an empty stack, my man! Move along; there's nothing to see here.");
	}
	
	public T top()
	{
		if (!isEmpty())
		{
			return top.getInfo();
		}
		else
			throw new StackUnderflowException("Can't top an empty stack, my man! Move along; there's nothing to see here.");
	}
	
	public boolean isEmpty()
	{
		return (top == null && size == 0);
	}
}
