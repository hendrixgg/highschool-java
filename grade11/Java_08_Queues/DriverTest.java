/*
 * This Program tests the ArrayListQueue.java class.
 * 
 * */
public class DriverTest {
  
  
  public static void main(String[] args) { 
    // the assumption is the Queue can hold 10 
    // interger elements 
    ArrayListQueue q = new ArrayListQueue();
    
    // TEST 1 enqueue elements until full and tries 
    // to enqueue 5 elements
    for (int i = 100; i < 250; i+=10){
      
      System.out.print ("Trying to enqueue :" + i);
      if (q.enqueue(i)){
        System.out.print ("... success");
      }
      else{
        System.out.print ("... failed");
      }
      System.out.println ();
    }
    System.out.println ();
    System.out.println("TEST 1:");
    System.out.println("The elements in queue according to Mr. Corea:");
    System.out.println("100 110 120 130 140 150 160 170 180 190");
    System.out.println("The elements in queue according to You:");
    System.out.println(q);
    System.out.println ();
    
    // TEST 2 add 5 elements, dequeues 4, prints them out, dequeues 3
    // and prints it out
    
    // resent the queue
    q = new ArrayListQueue();

    // insert 5 elements 1000 900 800 700 600
    for (int i = 1000; i > 500; i-=100){
      
      System.out.print ("Trying to enqueue :" + i);
      if (q.enqueue(i)){
        System.out.print ("... success");
      }
      else{
        System.out.print ("... failed");
      }
      System.out.println ();
    }
    System.out.println ();
    System.out.println("TEST 2:");
    System.out.println("The elements in queue according to Mr. Corea:");
    System.out.println("1000 900 800 700 600");
    System.out.println("The elements in queue according to You:");
    System.out.println(q);
    System.out.println ();
    
    // dequeue four elements and compare them with the expected value
    for (int i = 1000; i > 600; i-=100){
      if (i == q.dequeue()){
        System.out.println("Dequeued expected element");
      }
      else{
        System.out.println("The element expected was not what was recieved");
      }
    }
    System.out.println("After dequeue-ing four elements");
    System.out.println("The elements in queue according to Mr. Corea:");
    System.out.println("600");
    System.out.println("The elements left in queue according to You:");
    System.out.println(q);
    
    // dequeues the last element plus dequeues two more elements
    for (int i = 600; i > 300; i-=100){
      int temp = q.dequeue();
      if (i == temp){
        System.out.println("Dequeued expected element");
      }
      else if(temp == -9999){
        System.out.println("Queue is empty, cannot dequeue");
      }
      else{
        System.out.println("The element expected was not what was recieved");
      }
    }
    System.out.println("After dequeue-ing twice elements");
    System.out.println("The elements in queue according to Mr. Corea:");
    System.out.println("[empty]");
    System.out.println("The elements left in queue according to You:");
    System.out.println(q);
    
       
    // TEST 3 
    // enqueue 10 elements, dequeues 5, prints them out
    // enqueues 3 more, prints them out, dequeue 2, prints them out
    // enqueue 1, print them out.
    
    // reset the queue
    q = new ArrayListQueue();

    // insert 10 elements 50 51 52 53 54 55 56 57 58 59
    for (int i = 50; i < 60; i+=1){
      
      System.out.print ("Trying to enqueue :" + i);
      if (q.enqueue(i)){
        System.out.print ("... success");
      }
      else{
        System.out.print ("... failed");
      }
      System.out.println ();
    }
    
    
    // dequeue 5 elements
    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.dequeue();
    
    System.out.print ("");
    System.out.println("TEST 3:");
    System.out.println("After deque-ing five elements");
    System.out.println("The elements in queue according to Mr. Corea:");
    System.out.println("55 56 57 58 59");
    System.out.println("The elements in queue according to You:");
    System.out.println(q);
    System.out.println();
    
    //enqueueing 3 more
    q.enqueue(60);
    q.enqueue(61);
    q.enqueue(62);
    
    
    System.out.println("After enqueue-ing five elements");
    System.out.println("The elements in queue according to Mr. Corea:");
    System.out.println("55 56 57 58 59 60 61 62");
    System.out.println("The elements in queue according to You:");
    System.out.println(q);
    System.out.println();
    
    // dequeue 2 elements
    q.dequeue();
    q.dequeue();
    
    System.out.println("After dequeue-ing two elements");
    System.out.println("The elements in queue according to Mr. Corea:");
    System.out.println("57 58 59 60 61 62");
    System.out.println("The elements in queue according to You:");
    System.out.println(q);
    System.out.println ("");
    
    
    //enqueueing 1 more
    q.enqueue(63);
    
    System.out.println("After enqueue-ing one element");
    System.out.println("The elements in queue according to Mr. Corea:");
    System.out.println("57 58 59 60 61 62 63");
    System.out.println("The elements in queue according to You:");
    System.out.println(q);
    System.out.println();    
  }
  
  
}
