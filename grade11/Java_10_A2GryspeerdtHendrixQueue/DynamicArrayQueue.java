public interface DynamicArrayQueue
{
   //  Adds one element to the rear of the queue. Returns true if successful, false otherwise
   public boolean enqueue (int element);
   
   //  Removes and returns the element at the front of the queue
   public int dequeue();
   
   //  Returns without removing the element at the front of the queue
   public int peek();   
   
   //  Returns true if the queue contains no elements
   public boolean isEmpty();
   
   //  Returns the number of elements in the queue
   public int size();
   
   //  Returns a string representation of the queue
   public String toString();
   
}
