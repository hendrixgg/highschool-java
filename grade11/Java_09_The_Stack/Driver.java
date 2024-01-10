public class Driver {
 
  public static void main(String[] args) { 
    MyStack s = new MyStack();
    System.out.println("Pushing three values!");
    s.push("Hello");
    
    s.push("There");
    s.push("how");
    
    System.out.println(s);
    System.out.println();
    
    System.out.println("Popping one value!");
    System.out.println(s.pop() + " was removed");
    System.out.println(s);
    System.out.println();
    
    System.out.println("Pushing one value!");
    s.push(5);
    System.out.println(s);
    System.out.println();
    
    System.out.println("Pushing five values!");
    s.push(100);
    s.push("ICS3U");
    s.push("Wow");
    s.push(true);
    s.push(3.1415);
    System.out.println(s);
    System.out.println();
        
    System.out.println("Popping two value!");
    System.out.println(s.pop() + " was removed");
    System.out.println(s.pop() + " was removed");
    System.out.println(s);
    System.out.println();
    
    System.out.println("Popping all the values!");
    System.out.println(s.pop() + " was removed");
    System.out.println(s.pop() + " was removed");
    System.out.println(s.pop() + " was removed");
    System.out.println(s.pop() + " was removed");
    System.out.println(s.pop() + " was removed");
    System.out.println(s.pop() + " was removed");
    System.out.println(s);
    System.out.println();
    
    System.out.println("Popping out from an empty stack");
    System.out.println(s.pop() + " was removed");
    System.out.println(s);
    System.out.println();
  }
 }
