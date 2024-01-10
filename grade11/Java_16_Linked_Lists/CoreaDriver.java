import java.applet.Applet; 
import java.awt.*; 
import java.awt.event.*; 

/** 
* Demonstrates use of a Singly-linked list 
* 
*/
public class CoreaDriver extends Applet implements ActionListener 
{ 
  private SLL myList;
  
   // GUI objects 
   private TextField name = new TextField("           "); 
   private Button addF = new Button("Add Front"); 
   private Button addL = new Button("Add End");
   
   private Button removeF = new Button("Remove Front"); 
   private Button removeL = new Button("Remove End"); 
   
   private Button contain = new Button("Contains");   
   private Button size = new Button("Size"); 
   private Button clear = new Button("Clear"); 
   
   private Button removeFO = new Button("Remove First Hit"); 
   private Button removeLO = new Button("Remove Last Hit"); 
  
   
   private Button printF = new Button("PrintForwards"); 
      
   private TextArea display = new TextArea(10, 40); 
   
   private Label messages = new Label("Messages will appear here");

   /** 
   * Add objects to the Applet 
   */ 
   public void init() 
   { 
     myList = new SLL();
      
     add(name); 
     add(addF); 
     add(addL);
     
     add(removeF); 
     add(removeL); 
     add(contain);
     add(size); 
     add(clear);
     add (removeFO);
     add (removeLO);
        
     add(printF); 
          
     add(display); 
     add(messages); 
         
      
     // Causes button presses to be detected 
     addF.addActionListener(this); 
     addL.addActionListener(this);  
     removeF.addActionListener(this); 
     removeL.addActionListener(this); 
     contain.addActionListener(this);
     size.addActionListener(this); 
     clear.addActionListener(this); 
     removeFO.addActionListener(this); 
     removeLO.addActionListener(this); 
     
     printF.addActionListener(this); 
     
     name.setText("Type Here");
   } 
   /** 
   * When an event occurs on an object with an ActionListener attached, this 
   * method is carried out. 
   * 
   * @param e carries details about the event that occurred 
   */ 
   public void actionPerformed(ActionEvent e) 
   { 
     messages.setText("");      
     
     // Check the button presses 
     if (e.getSource() == addF) 
     { 
       addNameFirst(); 
     } 
     else if (e.getSource() == addL) 
     { 
       addNameLast(); 
     } 
     else if(e.getSource() == removeF){
       removeFirst();
     }
     else if(e.getSource() == removeL){
       removeLast();
     }
     else if(e.getSource() == size){
       displaySize();
     }
     else if(e.getSource() == clear){
       clear();
     }
     else if(e.getSource() == contain){
       contains();
     }     
     else if(e.getSource() == removeFO){
       removeFO();
     }
     else if(e.getSource() == removeLO){
       removeLO();
     }
                   
     else if(e.getSource() == printF){
       printForwards();
     }
   
     
     name.setText("");
   } 
   
  
   
   
   public void removeFO(){
     boolean b = myList.removeFirstOccurrence(name.getText());
     displayList(); 
     if(b){
        messages.setText("Successfully Removed");
      }
      else{
       messages.setText("Unsuccessfully Removed");
     }
     
   }
    public void removeLO(){
      boolean b = myList.removeLastOccurrence(name.getText());
      displayList(); 
      if(b){
        messages.setText("Successfully Removed");
      }
      else{
       messages.setText("Unsuccessfully Removed");
     }
   } 
   
   
   public void printForwards(){
     myList.printFirstToLast();
     messages.setText("Check the output below");
   }
   public void contains(){
     if (myList.contains(name.getText()) ){
       messages.setText(name.getText() + " was found");
     }
     else{
        messages.setText(name.getText() + " was not found");
     }   
   }
   
   
   public void removeFirst(){
     Node n = myList.removeFirst();
     displayList(); 
     if (n !=null){
        messages.setText("\"" + n.getData() + "\" removed");
     }
     else{
        messages.setText("Nothing to remove");
     }
     
   }
   public void removeLast(){
     Node n = myList.removeLast();
     displayList(); 
     if (n !=null){
        messages.setText("\"" + n.getData() + "\" removed");
     }
     else{
        messages.setText("Nothing to remove");
     }
   }
   
   
   public void clear(){
     myList.clear();
     displayList(); 
   }
   
   public void displaySize(){
     messages.setText("The size is " + myList.size()); 
   }
   
   
   public void addNameFirst() 
   { 
     // get the name and create a new node at the head 
     String theName = name.getText(); 
     Node newOne = new Node(theName);
     myList.addFirst(newOne);
     displayList(); 
   } 
   public void addNameLast() 
   { 
     // get the name and create a new node at the head 
     String theName = name.getText(); 
     Node newOne = new Node(theName);
     myList.addLast(newOne);
     displayList(); 
   } 
   
   public void displayList() 
   { 
     display.setText("Start \n-------\n");
         
     Node temp = myList.peekFirst(); 
     // "walk" down the list, using the temp pointer 
     while (temp != null) 
     { 
       display.append(temp.getData());
       if (temp == myList.peekFirst()) 
       { 
         display.append("  << front"); 
       } 
       if (temp == myList.peekLast()) 
       { 
         display.append("  << end"); 
       } 
       display.append("\n");
       
       temp = temp.getNext(); 
     } 
   } 
}