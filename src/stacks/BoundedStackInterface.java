package stacks;

public interface BoundedStackInterface<T> extends StackInterface<T>
{
	void push(T element) throws StackOverflowException;
	// Throws if this stack is full, else puts element to the top of the stack
	
	boolean isFull();
	// Returns true is this stack is full, else returns false
}
