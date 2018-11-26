package stacks;

public class ArrayStack<T> implements BoundedStackInterface<T>
{
	protected final int DEFCAP = 100;	// default capacity
	protected T[] stack;				// created the stack object to hold elements
	protected int topIndex = -1;		// index of top element in stack
	
	public ArrayStack()
	{
		stack = (T[]) new Object[DEFCAP];
	}
	
	public ArrayStack(int maxSize)
	{
		stack = (T[]) new Object[maxSize];
	}
	
	public boolean isEmpty()
	{
		return (topIndex == -1);
	}
	
	public boolean isFull()
	{
		return (topIndex == (stack.length - 1));
	}
	
	public void push(T element)
	// Throws StackOverflowException if stack is full, else puts element at top of the stack
	{
		if (!isFull())
		{
			topIndex++;
			stack[topIndex] = element;
		}
		else
			throw new StackOverflowException("Maverick: Tower, this is Ghost Rider requesting a flyby. Air Boss Johnson: Negative, Ghost Rider, the pattern is full.");
	}
	
	public void pop()
	// Throws StackUnderflowException is the stack is empty, else removes top element of the stack
	{
		if (!isEmpty())
		{
			stack[topIndex] = null;
			topIndex--;
		}
		else
			throw new StackUnderflowException("Let go your earthly tether. Enter the void. Empty, and become wind. \nThe stack was already empty.)");
	}
	
	public T top()
	// Throws StackUnderflowException is the stack is empty, else returns top element of the stack
	{
		T topOfStack = null;
		if (!isEmpty())
		{
			topOfStack = stack[topIndex];
		}
		else
			throw new StackUnderflowException("Can't top an empty stack, my man! Move along; there's nothing to see here.");
		return topOfStack;
	}
}
