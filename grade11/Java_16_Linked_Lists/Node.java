/** 
 * Node.java 
 */ 
class Node {
  // data member 
  private String element;
  
  // The fields that links nodes together. 
  private Node next; 
  
  public Node(String val) {
    element = val;
    next = null; 
  } 
  
  // accessor methods 
  public String getData() {
    return element;
  } 
  
  public Node getNext() {
    return next;
  }   
  // mutator methods 
  public void setData( String nm ) {
    element = nm;
  } 
  public void setNext( Node n) {
    next = n;
  } 
}