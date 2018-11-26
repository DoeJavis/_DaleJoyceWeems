package queues;
import support.LLNode;

public class LinkedUnbndQueue<T> implements UnboundedQueueInterface<T>	// p.331
{
	protected LLNode<T> front;	// reference to the front of this queue
	protected LLNode<T> rear;	// reference to the rear of this queue
	
	public LinkedUnbndQueue()
	{
		front = null;
		rear = null;
	}
	
	public void enqueue(T element)	// Adds element to the rear of this queue
	{
		LLNode<T> newNode = new LLNode<T>(element);
		if (rear == null)
			front = newNode;
		else
			rear.setLink(newNode);
		rear = newNode;
	}
	
	public T dequeue()	// Throws the QueueUnderflowException if this queue is empty; otherwise, it removes the front elements and returns it
	{
		if (isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on an empty queue.");
		else
		{
			T element = front.getInfo();
			front = front.getLink();
			if (front == null)
				rear = null;
			
			return element;
		}
	}
	
	public boolean isEmpty()	// Returns true if this queue is empty; otherwise, returns false
	{
		return (front == null);
			
	}
	
	
	
	
}
