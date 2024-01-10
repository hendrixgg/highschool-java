import java.util.ArrayList;

public class ArrayListQueue implements Queue {

    ArrayList<Integer> myQueue;

    public ArrayListQueue() {
        // the default size of the queue is 10
        myQueue = new ArrayList<Integer>();
    }

    // Adds one element to the rear of the queue. Returns true if successful, false
    // otherwise
    public boolean enqueue(int element) {
        // insert code here... modify code
        if (myQueue.size() < 10) {
            myQueue.add(element);
            return true;
        }
        return false;
    }

    // Removes and returns the element at the front of the queue
    public int dequeue() {
        // insert code here... modify code
        if (myQueue.isEmpty())
            return -9999;

        return myQueue.remove(0);
    }

    // Returns without removing the element at the front of the queue
    public int peek() {
        // insert code here... modify code
        if (!myQueue.isEmpty())
            return myQueue.get(0);
        return -9999;
    }

    // Returns true if the queue contains no elements
    public boolean isEmpty() {
        // insert code here... modify code
        return myQueue.isEmpty();
    }

    // Returns the number of elements in the queue
    public int size() {
        // insert code here... modify code
        if (myQueue.isEmpty())
            return 0;
        return myQueue.size();
    }

    // Returns a string representation of the queue
    public String toString() {
        // insert code here
        if (myQueue.isEmpty())
            return "[empty]";
        return myQueue.toString();
    }
}