/*
 * This class performs test cases for queue
 * 
 * */
class StudentDriver {

  public static void main(String[] args) {
    int myMark = 0;

    // TEST 1
    // (1 mark) A queue is empty on construction
    A2LastNameFirstNameQueue q = new A2LastNameFirstNameQueue();

    if (q.isEmpty()) {
      System.out.println("\nTest 1 successfull: +1");
      myMark = myMark + 1;
    } else {
      System.out.println("\nTest 1 failed********************");
    }

    // TEST 2
    // (1 mark) A queue has size 0 on construction

    if (q.size() == 0) {
      System.out.println("\nTest 2 successfull: +1");
      System.out.println();
      myMark = myMark + 1;
    } else {
      System.out.println("\nTest 2 failed********************");
      System.out.println();
    }

    // TEST 3
    // (3 mark)After n enqueues to an empty queue, n > 0,
    // the queue is not empty and its size is n
    q = new A2LastNameFirstNameQueue(); // reset queue

    for (int i = 100; i < 150; i += 10) {
      System.out.print("enqueuing " + i);
      if (q.enqueue(i)) {
        System.out.print("... success");
      } else {
        System.out.print("... failed");
      }
      System.out.println();
    }

    if (!q.isEmpty() && q.size() == 5) {
      System.out.println("\nTest 3 successfull: +3");
      System.out.println();
      myMark = myMark + 3;
    } else {
      System.out.println("\nTest 3 failed********************");
      System.out.println();
    }

    // TEST 4
    // (2 mark) If one enqueues x then peeks, the value returned is x, but the size
    // stays the same
    q = new A2LastNameFirstNameQueue(); // reset queue
    // insert 5 elements 1000 900 800 700 600
    for (int i = 1000; i > 500; i -= 100) {

      System.out.print("Trying to enqueue :" + i);
      if (q.enqueue(i)) {
        System.out.print("... success ");
      } else {
        System.out.print("... failed");
      }
      System.out.println();
    }

    q.enqueue(100);

    int myPeek = q.peek();

    if (q.size() == 6) {
      System.out.println("\nTest 4 part 1 successfull: +1");
      System.out.println();
      myMark = myMark + 1;
    } else {
      System.out.println("\nTest 4 part 1 failed********************");
      System.out.println();
    }
    if (myPeek == 1000) {
      System.out.println("\nTest 4 part 2 successfull: +1");
      System.out.println();
      myMark = myMark + 1;
    } else {
      System.out.println("\nTest 4 part 2 failed********************");
      System.out.println(myPeek);
    }

    // TEST 5
    // If one enqueues x then dequeues, the value dequeued
    // is x.
    q = new A2LastNameFirstNameQueue(); // reset queue

    q.enqueue(3);
    int temp = q.dequeue();

    if (temp == 3) {
      System.out.println("\nTest 5 successfull: +1");
      System.out.println();
      myMark = myMark + 1;
    } else {
      System.out.println("\nTest 5 failed********************");
      System.out.println();
    }

    // TEST 6
    // (2 mark) If the size is n, then after
    // n dequeues, the stack is empty and has a size 0

    // reset the queue
    q = new A2LastNameFirstNameQueue();

    // insert 5 elements 1000 900 800 700 600
    for (int i = 1000; i > 500; i -= 100) {

      System.out.print("Trying to enqueue :" + i);
      if (q.enqueue(i)) {
        System.out.print("... success");
      } else {
        System.out.print("... failed");
      }
      System.out.println();
    }
    for (int i = 0; i < 5; i++) {
      q.dequeue();
    }
    if (q.size() == 0) {
      System.out.println("\nTest 6 successfull: +2");
      System.out.println();
      myMark = myMark + 2;
    } else {
      System.out.println("\nTest 6 failed********************");
      System.out.println();
    }

    // TEST 7
    // (1 mark) call peek() with one item
    // reset the queue
    q = new A2LastNameFirstNameQueue();
    q.enqueue(50);
    int temp7 = q.peek();
    if (temp7 == 50) {
      System.out.println("\nTest 7 successfull: +1");
      System.out.println();
      myMark = myMark + 1;
    } else {
      System.out.println("\nTest 7 failed********************");
      System.out.println();
    }

    // TEST 8
    // (1 mark) call peek() from an empty queue
    // returns -9999 representing no such element
    q = new A2LastNameFirstNameQueue();
    int temp8 = q.peek();
    if (temp8 == -9999) {
      System.out.println("\nTest 8 successfull: +1");
      System.out.println();
      myMark = myMark + 1;
    } else {
      System.out.println("\nTest 8 failed********************");
      System.out.println();
    }

    // TEST 9
    // (1 mark) call dequeue() from an empty queue
    // returns -9999 representing no such element
    q = new A2LastNameFirstNameQueue();
    int temp9 = q.dequeue();
    if (temp9 == -9999) {
      System.out.println("\nTest 9 successfull: +1");
      System.out.println();
      myMark = myMark + 1;
    } else {
      System.out.println("\nTest 9 failed********************");
      System.out.println();
    }

    // TEST 10
    // (1 mark) call dequeue() on an queue with one item.
    q = new A2LastNameFirstNameQueue();
    q.enqueue(50);
    int temp10 = q.dequeue();
    if (temp10 == 50) {
      System.out.println("\nTest 10 successfull: +1");
      System.out.println();
      myMark = myMark + 1;
    } else {
      System.out.println("\nTest 10 failed********************");
      System.out.println();
    }

    q = new A2LastNameFirstNameQueue(); // reset queue
    // TEST 11 enqueue elements until full plus one more element
    boolean t11 = false;
    for (int i = 100; i < 200; i += 10) {

      System.out.print("\nTrying to enqueue :" + i);
      if (q.enqueue(i)) {
        System.out.print("... success");
      }
    }
    if (!q.enqueue(210)) {
      System.out.println();
      System.out.println("... failed");
      System.out.println("\nTest 11 successfull: +1");
      System.out.println();
      t11 = true;
      myMark = myMark + 1;
    }
    if (!t11) {
      System.out.println("\nTest 11 failed********************.");
      System.out.println();
    }

    // TEST 12
    // (2 mark) If one enqueues the values 1 through 10, in order,
    // into an empty queue, then if 10 dequeues are done the values
    // dequeues are 1 through 10.

    // reset the queue
    System.out.println("\nTest 12.");
    q = new A2LastNameFirstNameQueue();
    int i;
    // insert 10 elements 1 through 10
    for (i = 1; i <= 10; i++) {

      System.out.print("Trying to enqueue :" + i);
      if (q.enqueue(i)) {
        System.out.print("... success");
      } else {
        System.out.print("... failed");
      }
      System.out.println();
    }
    boolean t12 = true;
    for (i = 1; i < 10; i++) {
      if (i == q.dequeue()) {
        System.out.println("Dequeued expected element");
      } else {
        System.out.println("The element expected was not what was recieved");
        t12 = false;
      }
    }
    if (t12) {
      System.out.println("\nTest 12 successfull: +2");
      System.out.println();
      myMark = myMark + 2;
    } else {
      System.out.println("\nTest 12 failed********************");
      System.out.println();
    }

    // TEST 13
    // (1 mark) print all elements in queue when front < rear

    // reset the queue
    q = new A2LastNameFirstNameQueue();

    // insert 7 elements 50 51 52 53 54 55
    for (i = 50; i < 56; i += 1) {

      System.out.print("Trying to enqueue :" + i);
      if (q.enqueue(i)) {
        System.out.println("... success");
      } else {
        System.out.println("... failed");
      }

    }
    int stringOutput = 0;
    System.out.println("\nTEST 13"); // (1 mark)
    String myQ, yourQ;
    System.out.println("The elements in queue according to Mr. Corea:");
    myQ = "[50, 51, 52, 53, 54, 55]";
    yourQ = q.toString();
    System.out.println(myQ);
    System.out.println("The elements in queue according to You:");
    System.out.println(yourQ);
    System.out.println("MATCH: " + myQ.equals(yourQ));
    if (myQ.equals(yourQ)) {
      System.out.println("\nTest 13 successfull: +1");
      System.out.println();
      stringOutput += 1;
    } else {
      System.out.println("Test 13 failed********************");
      System.out.println();
    }

    // TEST 14 print all elements in queue when rear < front
    // reset the queue
    q = new A2LastNameFirstNameQueue();

    // insert 10 elements 50 51 52 53 54 55 56 57 58 59
    for (i = 50; i < 60; i += 1) {

      System.out.print("Trying to enqueue :" + i);
      if (q.enqueue(i)) {
        System.out.print("... success");
      } else {
        System.out.print("... failed");
      }
      System.out.println();
    }

    // dequeue 5 elements
    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.dequeue();

    // enqueueing 3 more
    q.enqueue(60);
    q.enqueue(61);
    q.enqueue(62);

    System.out.println("\nTEST 14"); // (2 mark)
    System.out.println("The elements in queue according to Mr. Corea:");

    myQ = "[55, 56, 57, 58, 59, 60, 61, 62]";
    yourQ = q.toString();
    System.out.println(myQ);
    System.out.println("The elements in queue according to You:");
    System.out.println(yourQ);
    System.out.println("MATCH: " + myQ.equals(yourQ));

    if (myQ.equals(yourQ)) {
      System.out.println("\nTest 14 successfull: +2");
      System.out.println();
      stringOutput += 2;
    } else {
      System.out.println("Test 14 failed********************");
      System.out.println();
    }

    // dequeue 2 elements
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());

    System.out.println("\nTEST 15"); // (2 mark) print an empty queue
    System.out.println("The elements in queue according to Mr. Corea:");
    myQ = "[]";
    yourQ = q.toString();
    System.out.println(myQ);
    System.out.println("The elements in queue according to You:");
    System.out.println(yourQ);
    System.out.println("MATCH: " + myQ.equals(yourQ));
    if (myQ.equals(yourQ)) {
      System.out.println("\nTest 15 successfull: +2");
      System.out.println();
      stringOutput += 2;
    } else {
      System.out.println("Test 15 failed********************");
      System.out.println();
    }

    System.out.println("TEST RESULTS: " + myMark + " /17 plus " + stringOutput + "/5 for correct toString()");
  }

}