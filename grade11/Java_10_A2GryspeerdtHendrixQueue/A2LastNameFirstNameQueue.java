public class A2LastNameFirstNameQueue implements DynamicArrayQueue {

    private int capacity = 10;
    int front;
    int rear;
    int[] myArray;
    int currentSize;

    public A2LastNameFirstNameQueue() {
        // the default size of the queue is 10
        myArray = new int[capacity];
        currentSize = 0;
        front = 0;
        rear = 0;
    }

    // Adds one element to the rear of the queue.
    // Returns true if successful, false otherwise
    public boolean enqueue(int element) {
        if (isFull())
            return false;
        myArray[rear] = element;
        ++currentSize;
        rear = (rear + 1) % myArray.length;
        return true;
    }

    // Removes and returns the element at the front of the queue
    public int dequeue() {
        if (isEmpty())
            return -9999;
        int output = myArray[front];
        myArray[front] = 0;
        currentSize--;
        front = (front + 1) % myArray.length;
        return output;
    }

    // Returns without removing the element at the front of the queue
    public int peek() {
        if (isEmpty())
            return -9999;

        return myArray[front];
    }

    // Returns true if the queue contains no elements
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Returns the number of elements in the queue
    public int size() {
        return currentSize;
    }

    // Returns a string representation of the queue
    public String toString() {
        String ret = "[";
        for (int i = 0; i < currentSize - 1; ++i) {
            ret += myArray[(i + front) % 10] + ", ";
        }
        return ret + (isEmpty()? "]" : myArray[(rear - 1) % 10] + "]");
    }

    //
    // additional methods of my own:
    //

    // Returns true if numItems equals myArray.length-1
    public boolean isFull() {
        return currentSize == myArray.length;
    }

}