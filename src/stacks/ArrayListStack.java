package stacks;
import java.util.*;
public class ArrayListStack<T> implements UnboundedStackInterface<T>
{
	protected ArrayList<T> stack;		// ArrayList that hold the stack elements
	
	public ArrayListStack()
	// Constructor
	{
		stack = new ArrayList<T>();
	}
	
	public void push(T element)
	// This will not throw any exception because the ArrayList will continue to grow in size as you keep adding elements to the ArrayList
	{
		stack.add(element);
	}
	
	public void pop()
	// Throws StackUnderflowException if this stack is empty, else returns element on top of the stack
	{
		if (!isEmpty())
		{
			stack.remove(stack.size() - 1);		// removes the element at location size - 1
		}
		else 
			throw new StackUnderflowException("Can't pop an empty stack, bruh! Ya got nothin' left to give.");
	}
	
	public T top()
	// Throws StackUnderflowException is the stack is empty, else returns top element of the stack
	{
		T topOfStack = null;
		if (!isEmpty())
		{
			topOfStack = stack.get(stack.size() - 1);
		}
		else
			throw new StackUnderflowException("Can't top an empty stack, my man! Move along; there's nothing to see here.");
		return topOfStack;
	}
	
	public boolean isEmpty()
	{
		return (stack.size() == 0);
	}
}
