import java.awt.*;
public class Node
{ 
  // data member 
  private Image myImage;
  private String element;
  
  // The fields that links nodes together. 
  private Node next; 
  private Node prev;
  
  
  public Image getImage(){
   return myImage;    
  }
  public Node(Image img, String value){
    myImage = img;
    element = value;
    next = null; 
    prev = null;
  }   
  // accessor methods 
  public String getData() 
  {
    return element;
  } 
  public Node getNext(){ 
    return next;
  }
  public Node getPrevious(){ 
    return prev;
  }
  
  // mutator methods 
  public void setData( String nm ) {
    element = nm;
  } 
  public void setNext( Node n){
    next = n;
  } 
  public void setPrevious( Node n){
    prev = n;
  } 
  
}