package stacks;

public interface StackInterface<T>
{
	void pop() throws StackUnderflowException;
	// Throws StackUnderflowException if stack is empty, else removes top element
	
	T top() throws StackOverflowException;
	// Throws StackUnderflowException is stack is empty, else returns top element
	
	boolean isEmpty();
	// Returns true is stack is empty, else returns false
}
