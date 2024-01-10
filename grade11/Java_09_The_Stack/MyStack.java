public class MyStack {
  
  private int myTop;
  private Object[] myArray;
  
  // Contructor, initate the instance variables
  // The stack can grow to a max size of 25 elements
  public MyStack() { 
    myArray = new Object[25];
    myTop = -1;   
  }
  
  // Returns true if stack is empty, false otherwise
  public boolean isEmpty(){
    return (myTop == -1);
    
  }
  
  // push num to the top of the stack
  public boolean push(Object obj){
    if (myTop < myArray.length-1){
      
      myTop = myTop+1;
      myArray[myTop]=obj;
      return true;
    }
    return false;
  }
  
  // returns the top value of the stack
  public Object peek(){
    if (!isEmpty()){
      return  myArray[myTop];
    }
    else{
      return null; 
    }
    
  }
  
  // returns the top value of the stack and removes it from the stack
  public Object pop(){
    if (!isEmpty()){
      myTop = myTop-1;
      return  myArray[myTop+1];
    }
    else{
      return null; 
    }
    
  }
  
  // returns a String representation of the elements of the stack
  public String toString(){    
    String output;
       
    output = "[";
    if (!isEmpty()){
      for (int i = myTop ; i > 0; i--){
        output = output + myArray[i]+", ";
      }
      // print the bottom element
      output = output + myArray[0]+ "]";
    }
    else{
      output = output + "]";
    }
    return output; 
  }
}
