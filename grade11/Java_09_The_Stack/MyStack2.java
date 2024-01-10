import java.util.ArrayList;
public class MyStack2 implements Stack_Interface{
  
  private ArrayList<Object> myList;
  
  // Contructor, initate the instance variables
  // The stack can grow to a max size of 25 elements
  public MyStack2() { 
    myList = new ArrayList<Object>();   
  }
  
  // Returns true if stack is empty, false otherwise
  public boolean isEmpty(){
    return (myList.isEmpty());
  }
  
  // push num to the top of the stack
  public boolean push(Object obj){
    if (myList.size() > -1){
      myList.add(0, obj);
      return true;
    }
    return false;
  }
  
  // returns the top value of the stack
  public Object peek(){
    if (!isEmpty()){
      return  myList.get(0);
    }
    else{
      return null; 
    }
    
  }
  
  // returns the top value of the stack and removes it from the stack
  public Object pop(){
    if (!isEmpty()){
      return  myList.remove(0);
    }
    else{
      return null; 
    }
    
  }
  
  // returns a String representation of the elements of the stack
  public String toString(){
    return myList.toString(); 
  }
}
