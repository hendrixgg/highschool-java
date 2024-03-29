class TeacherDriver {

  public static void main(String[] args) {
    A2LastNameFirstNameQueue q;
    int myMark = 0, sum = 0;
    int myPeek, myDequeue, mySize;
    boolean myIsEmpty, myEnqueue, myEnqueue2, myBoolResult;

    /*
     * Test case number: 1 Test case values: enqueue 5, 6, 7, 8 to the queue, then
     * peek Expected output (Post-state): return 8 and queue is not empty, and size
     * is 4
     * 
     */
    System.out.println("Test 1");
    q = new A2LastNameFirstNameQueue();
    q.enqueue(5);
    q.enqueue(6);
    q.enqueue(7);
    q.enqueue(8);

    myPeek = q.peek();
    myIsEmpty = q.isEmpty();
    mySize = q.size();
    System.out.println("Expecting: 5 \nReceived: " + myPeek);
    System.out.println("Expecting: false \nReceived: " + myIsEmpty);
    System.out.println("Expecting: 4 \nReceived: " + mySize);

    if (myPeek == 5)
      myMark++;
    if (myIsEmpty == false)
      myMark++;
    if (mySize == 4)
      myMark++;
    sum = sum + 3;
    System.out.println("Test 1 mark tally " + myMark + "/" + sum);

    System.out.println();

    /*
     * Test case number: 2 Test case values: enqueue 1 the queue, then peek and then
     * dequeue Expected output (Post-state): return 1 and queue is empty
     * 
     */
    System.out.println("Test 2");
    q = new A2LastNameFirstNameQueue();
    q.enqueue(1);

    myPeek = q.peek();
    myDequeue = q.dequeue();
    myIsEmpty = q.isEmpty();
    System.out.println("Expecting: 1 \nReceived: " + myPeek);
    System.out.println("Expecting: 1 \nReceived: " + myDequeue);
    System.out.println("Expecting: true \nReceived: " + myIsEmpty);

    if (myPeek == 1)
      myMark++;
    if (myIsEmpty == true)
      myMark++;
    sum = sum + 2;
    System.out.println("Test 2 mark tally " + myMark + "/" + sum);
    System.out.println();

    /*
     * Test case number: 3 Test case values: initialize a new queue, check if the
     * queue is empty, number of elements, dequeue and peek Expected output
     * (Post-state): return true, the queue is empty Expected output (Post-state):
     * return 0, the number of elements is 0 Expected output (Post-state): return
     * null on peek Expected output (Post-state): return null on dequeue
     * 
     */
    System.out.println("Test 3");
    q = new A2LastNameFirstNameQueue();
    myIsEmpty = q.isEmpty();
    mySize = q.size();
    myPeek = q.peek();
    myDequeue = q.dequeue();
    System.out.println("Expecting: true \nReceived: " + myIsEmpty);
    System.out.println("Expecting: 0 \nReceived: " + mySize);
    System.out.println("Expecting: -9999 \nReceived: " + myPeek);
    System.out.println("Expecting: -9999 \nReceived: " + myDequeue);

    if (myDequeue == -9999)
      myMark++;
    if (myPeek == -9999)
      myMark++;
    if (myIsEmpty == true)
      myMark++;
    if (mySize == 0)
      myMark++;
    sum = sum + 4;
    System.out.println("Test 3 mark tally " + myMark + "/" + sum);
    System.out.println();

    /*
     * Test case number: 4 Test case values: initialize a new queue, enqueue 1 and 2
     * into queue, dequeue 3 times Expected output (Post-state): return null and
     * queue is empty
     */
    System.out.println("Test 4");
    q = new A2LastNameFirstNameQueue();
    q.enqueue(1);
    q.enqueue(2);
    q.dequeue();
    q.dequeue();
    myDequeue = q.dequeue();
    myIsEmpty = q.isEmpty();
    System.out.println("Expecting: -9999 \nReceived: " + myDequeue);
    System.out.println("Expecting: true \nReceived: " + myIsEmpty);
    if (myDequeue == -9999)
      myMark++;
    if (myIsEmpty == true)
      myMark++;
    sum = sum + 2;
    System.out.println("Test 4 mark tally " + myMark + "/" + sum);
    System.out.println();

    /*
     * Test case number: 5 Test case values: enqueue values from 1 to 10 into empty
     * queue then dequeue 10 times Expected output (Post-state): values returned are
     * from 1 to 10, queue empty and size 0
     */
    System.out.println("Test 5");
    q = new A2LastNameFirstNameQueue();
    for (int i = 1; i <= 10; i++) {
      q.enqueue(i);
    }
    myEnqueue = (1 == q.dequeue() && 2 == q.dequeue() && 3 == q.dequeue() && 4 == q.dequeue() && 5 == q.dequeue()
        && 6 == q.dequeue() && 7 == q.dequeue() && 8 == q.dequeue() && 9 == q.dequeue() && 10 == q.dequeue());
    myIsEmpty = q.isEmpty();
    mySize = q.size();
    System.out.println("Expecting: true \nReceived: " + myEnqueue);
    System.out.println("Expecting: true \nReceived: " + myIsEmpty);
    System.out.println("Expecting: 0 \nReceived: " + mySize);
    if (myEnqueue == true)
      myMark++;
    if (myIsEmpty == true)
      myMark++;
    if (mySize == 0)
      myMark++;
    sum = sum + 3;
    System.out.println("Test 5 mark tally " + myMark + "/" + sum);
    System.out.println();

    /*
     * Test case number: 6 Test case values: enqueue elements until full Expected
     * output (Post-state): true when enqueue 1 2 3 4 5 6 7 8 9 10 and false when
     * enqueue 11 number of elements is 10
     */
    System.out.println("Test 6");
    q = new A2LastNameFirstNameQueue();
    myEnqueue = q.enqueue(1) && q.enqueue(2) && q.enqueue(3) && q.enqueue(4) && q.enqueue(5) && q.enqueue(6)
        && q.enqueue(7) && q.enqueue(8) && q.enqueue(9) && q.enqueue(10);
    myEnqueue2 = q.enqueue(11);
    mySize = q.size();
    System.out.println("Expecting: true \nReceived:" + myEnqueue);
    System.out.println("Expecting: false \nReceived: " + myEnqueue2);
    System.out.println("Expecting: 10 \nReceived: " + mySize);
    if (myEnqueue == true)
      myMark++;
    if (myEnqueue2 == false)
      myMark++;
    if (mySize == 10)
      myMark++;
    sum = sum + 3;
    System.out.println("Test 6 mark tally " + myMark + "/" + sum);
    System.out.println();

    /*
     * Test case number: 7 Test case values: enqueue elements until full, dequeue 8
     * elements, and enqueue 5 elements resulting in front < rear, then dequeue all
     * remaing elements in the queue Expected output (Post-state): values returned
     * are from 9 to 15 Expected output (Post-state): size is 0
     */
    System.out.println("Test 7");
    q = new A2LastNameFirstNameQueue();

    for (int i = 1; i <= 10; i++) {
      q.enqueue(i);
    }
    for (int i = 1; i <= 8; i++) {
      q.dequeue();
    }
    for (int i = 11; i <= 15; i++) {
      q.enqueue(i);
    }
    myBoolResult = (9 == q.dequeue() && 10 == q.dequeue() && 11 == q.dequeue() && 12 == q.dequeue() && 13 == q.dequeue()
        && 14 == q.dequeue() && 15 == q.dequeue());
    mySize = q.size();
    System.out.println("Expecting: true \nReceived: " + myBoolResult);
    System.out.println("Expecting: 0 \nReceived: " + q.size());
    if (myBoolResult == true)
      myMark++;
    if (mySize == 0)
      myMark++;
    sum = sum + 2;
    System.out.println("Test 7 mark tally " + myMark + "/" + sum);
    System.out.println();
    /*
     * Test case number: 8 Test case values: enqueue 1,2,3,4,5,6 then dequeue all
     * Expected output (Post-state): [] Expected output (Post-state): empty queue
     * Expected output (Post-state): size is 0
     */
    System.out.println("Test 8");
    q = new A2LastNameFirstNameQueue();
    A2LastNameFirstNameQueue qT8 = q;
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(4);
    q.enqueue(5);
    q.enqueue(6);
    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.dequeue();

    myIsEmpty = q.isEmpty();
    mySize = q.size();
    System.out.println("Expecting: true \nReceived: " + myIsEmpty);
    System.out.println("Expecting: 0 \nReceived: " + mySize);
    if (myIsEmpty == true)
      myMark++;
    if (mySize == 0)
      myMark++;
    sum = sum + 2;
    System.out.println("Test 8 mark tally " + myMark + "/" + sum);
    System.out.println();

    /*
     * Test case number: 9 Test case values: enqueue elements until full, dequeue 5
     * elements, and enqueue 5 elements resulting in front = rear + 1 Expected
     * output (Post-state): return true for enqueue 10 elements, dequeue 5 enqueue 5
     * elements return false when enqueue 1 more than capaicty Expected output
     * (Post-state): [6,7,8,9,10,11,12,13,14,15] Expected output (Post-state): size
     * is 10
     */
    System.out.println("Test 9");
    q = new A2LastNameFirstNameQueue();
    A2LastNameFirstNameQueue qT9 = q;
    boolean result2;
    boolean result = true;

    for (int i = 1; i <= 10; i++) {
      result = result && q.enqueue(i);
    }
    for (int i = 1; i <= 5; i++) {
      q.dequeue();
    }
    for (int i = 11; i <= 15; i++) {
      result = result && q.enqueue(i);
    }
    result2 = result;
    result2 = result2 && q.enqueue(16);
    mySize = q.size();
    System.out.println("Expecting: true \nReceived: " + result);
    System.out.println("Expecting: false \nReceived: " + result2);
    System.out.println("Expecting: 10 \nReceived: " + mySize);
    if (result == true)
      myMark++;
    if (result2 == false)
      myMark++;
    if (mySize == 10)
      myMark++;
    sum = sum + 3;
    System.out.println("Test 9 mark tally " + myMark + "/" + sum);
    System.out.println();
    /*
     * Test case number: 10 Test case values: enqueue elements until full, dequeue 8
     * elements, and enqueue 5 elements resulting in front > rear and display
     * contents of queue Expected output (Post-state): [9,10,11,12,13,14,15]
     * Expected output (Post-state): size is 7
     */

    System.out.println("Test 10");
    q = new A2LastNameFirstNameQueue();
    A2LastNameFirstNameQueue qT10 = q;
    for (int i = 1; i <= 10; i++) {
      q.enqueue(i);
    }
    for (int i = 1; i <= 8; i++) {
      q.dequeue();
    }
    for (int i = 11; i <= 15; i++) {
      q.enqueue(i);
    }
    mySize = q.size();
    System.out.println("Expecting: 7 \nReceived: " + mySize);
    if (mySize == 7)
      myMark++;
    sum = sum + 1;
    System.out.println("Test 10 mark tally " + myMark + "/" + sum);
    System.out.println();

    /*
     * Test case number: 11 Test case values: enqueue 1 and 2 into the queue, then
     * dequeue the first item Expected output (Post-state): [2]
     */
    System.out.println("Test 11");
    q = new A2LastNameFirstNameQueue();
    A2LastNameFirstNameQueue qT11 = q;
    q.enqueue(1);
    q.enqueue(2);
    q.dequeue();
    System.out.println("Test 11 mark tally " + myMark + "/" + sum);
    System.out.println();

    /*
     * Test case number: 12 Test case values: enqueue 5 elements, dequeue 3
     * elements, and enqueue 4 elements resulting in front > rear and display
     * contents of queue Expected output (Post-state): [4,5,11,12,13,14] Expected
     * output (Post-state): size is 6
     */
    System.out.println("Test 12");
    q = new A2LastNameFirstNameQueue();
    A2LastNameFirstNameQueue qT12 = q;
    for (int i = 1; i <= 5; i++) {
      q.enqueue(i);
    }
    for (int i = 1; i <= 3; i++) {
      q.dequeue();
    }
    for (int i = 11; i <= 14; i++) {
      q.enqueue(i);
    }
    mySize = q.size();
    System.out.println("Expecting: 6 \nReceived: " + mySize);
    if (mySize == 6)
      myMark++;
    sum = sum + 1;
    System.out.println("Test 12 mark tally " + myMark + "/" + sum);
    System.out.println();

    /*
     * Test 13 Test case values: Enqueue 5 elements with value of 0 Expected output
     * (Post-state): [0,0,0,0,0] Expected output (Post-state): size is 5 Expected
     * output (Post-state): return 0 on peek Expected output (Post-state): return
     * false on isEmpty
     */
    System.out.println("Test 13");
    q = new A2LastNameFirstNameQueue();
    A2LastNameFirstNameQueue qT13 = q;
    for (int i = 1; i <= 5; i++) {
      q.enqueue(0);
    }
    mySize = q.size();
    myPeek = q.peek();
    myIsEmpty = q.isEmpty();
    System.out.println("Expecting: 5 \nReceived: " + q.size());
    System.out.println("Expecting: 0 \nReceived: " + q.peek());
    System.out.println("Expecting: false \nReceived: " + q.isEmpty());
    if (myPeek == 0)
      myMark++;
    if (myIsEmpty == false)
      myMark++;
    if (mySize == 5)
      myMark++;
    sum = sum + 3;
    System.out.println("Test 13 mark tally " + myMark + "/" + sum);
    System.out.println();

    System.out.println("Expecting: [] \nReceived:  " + qT8.toString());
    System.out.println("Expecting: [6, 7, 8, 9, 10, 11, 12, 13, 14, 15] \nReceived:  " + qT9.toString());
    System.out.println("Expecting: [9, 10, 11, 12, 13, 14, 15] \nReceived:  " + qT10.toString());
    System.out.println("Expecting: [2] \nReceived:  " + qT11.toString());
    System.out.println("Expecting: [4, 5, 11, 12, 13, 14] \nReceived:  " + qT12.toString());
    System.out.println("Expecting: [0, 0, 0, 0, 0] \nReceived:  " + qT13.toString());
  }
}