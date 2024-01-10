import java.applet.*;
import java.net.*;
import java.util.ArrayList;
import java.awt.*; 
import java.awt.event.*;

public class AppletDriver2 extends Applet implements ActionListener 
{
  ArrayList<Node> myCardsLeft;  
  int buttonW = 120;
  int buttonH = 20;
  int buttonSpaceX = 10;
  int buttonSpaceY = 10;
  int buttonXoffSet = 700;
  int buttonYoffSet = 120;
    
  int xOffSet=10;
  int yOffSet=10;
  int dx = 40;
  int dy = 120;
  
  Button reset = new Button("RESET"); 
  
  Button addF = new Button("Insert at FRONT"); 
  Button addE = new Button("Insert at END"); 
  Button removeF = new Button("Remove FRONT"); 
  Button removeE = new Button("Remove at END"); 
  Button printF = new Button("Print FORWARDS"); 
  Button printB = new Button("Print BACKWARDS"); 
  
  Button size = new Button("Size"); 
  Button clear = new Button("Clear"); 
  
  Button delete = new Button("Delete");
  Button deleteAtIndex = new Button("Delete at Index");
  
  Button contains = new Button ("Contains");
  Button insertAfter = new Button ("Insert AFTER");
  Button insertBefore = new Button ("Insert BEFORE");
    
 
  TextField input = new TextField(""); 
  
  TextArea output = new TextArea(10, 40); 
  
  DLL myList = new DLL();
   
  public void init()
  {         
     resetApplet();
     
    // add the buttons
    add(addF); 
    add(addE); 
    
    add(reset); 
    
    add(removeF);
    add(removeE);
    
    add(input);
    add(contains);
    add(delete);
    add(deleteAtIndex);
    add(insertAfter);
    add(insertBefore);
    add(clear);
    
    add(size); 
    add(printF); 
    add(printB); 
    add(output);
    
    setLayout(null);
    
    addF.setBounds(0,0,buttonW,buttonH);
    addF.setLocation(xOffSet+buttonXoffSet,yOffSet+buttonYoffSet);    
    
    addE.setBounds(0,0,buttonW,buttonH);
    addE.setLocation(xOffSet+buttonXoffSet+buttonW+buttonSpaceY,yOffSet+buttonYoffSet);    
    
    reset.setBounds(0,0,buttonW,5*buttonH);
    reset.setLocation(xOffSet+buttonXoffSet+buttonW+buttonSpaceY,yOffSet+buttonYoffSet-5*buttonH-buttonSpaceY);    
    
    
    removeF.setBounds(0,0,buttonW,buttonH);
    removeF.setLocation(xOffSet+buttonXoffSet,yOffSet+buttonYoffSet+buttonH + buttonSpaceY);    
    
    removeE.setBounds(0,0,buttonW,buttonH);
    removeE.setLocation(xOffSet+buttonXoffSet+buttonW+buttonSpaceY,yOffSet+buttonYoffSet+buttonH + buttonSpaceY);    
    
    size.setBounds(0,0,buttonW,buttonH);
    size.setLocation(xOffSet+buttonXoffSet,yOffSet+buttonYoffSet+3*buttonH + 3*buttonSpaceY);    
        
    clear.setBounds(0,0,buttonW,buttonH);
    clear.setLocation(xOffSet+buttonXoffSet+buttonW+buttonSpaceY,yOffSet+buttonYoffSet+3*buttonH + 3*buttonSpaceY);    
    
    printF.setBounds(0,0,buttonW,buttonH);
    printF.setLocation(xOffSet+buttonXoffSet,yOffSet+buttonYoffSet+2*buttonH + 2*buttonSpaceY);    
    
    printB.setBounds(0,0,buttonW,buttonH);
    printB.setLocation(xOffSet+buttonXoffSet+buttonW+buttonSpaceY,yOffSet+buttonYoffSet+2*buttonH + 2*buttonSpaceY);    
    
    input.setBounds(0,0,buttonW,buttonH);    
    input.setLocation(xOffSet+buttonXoffSet,yOffSet+buttonYoffSet+5*buttonH + 5*buttonSpaceY);    
    
    deleteAtIndex.setBounds(0,0,buttonW,buttonH);
    deleteAtIndex.setLocation(xOffSet+buttonXoffSet+buttonW+buttonSpaceX,yOffSet+buttonYoffSet+5*buttonH + 5*buttonSpaceY);    
    
    contains.setBounds(0,0,buttonW,buttonH);
    contains.setLocation(xOffSet+buttonXoffSet,yOffSet+buttonYoffSet+6*buttonH + 6*buttonSpaceY);    
    
    delete.setBounds(0,0,buttonW,buttonH);
    delete.setLocation(xOffSet+buttonXoffSet+buttonW+buttonSpaceX,yOffSet+buttonYoffSet+6*buttonH + 6*buttonSpaceY);    
    
    insertAfter.setBounds(0,0,buttonW,buttonH);
    insertAfter.setLocation(xOffSet+buttonXoffSet,yOffSet+buttonYoffSet+7*buttonH + 7*buttonSpaceY);    
   
    insertBefore.setBounds(0,0,buttonW,buttonH);
    insertBefore.setLocation(xOffSet+buttonXoffSet+buttonW+buttonSpaceX,yOffSet+buttonYoffSet+7*buttonH + 7*buttonSpaceY);    
    
    output.setBounds(0,0,buttonW*2+buttonSpaceX,150);
    output.setLocation(xOffSet+buttonXoffSet,yOffSet+buttonYoffSet+8*buttonH + 8*buttonSpaceY);
    
    addF.addActionListener(this);     
    addE.addActionListener(this);
    reset.addActionListener(this);
    removeF.addActionListener(this);
    removeE.addActionListener(this);
    contains.addActionListener(this);   
    delete.addActionListener(this);
    deleteAtIndex.addActionListener(this);
    insertAfter.addActionListener(this);     
    insertBefore.addActionListener(this);     
    clear.addActionListener(this);     
    size.addActionListener(this);   
    printF.addActionListener(this);   
    printB.addActionListener(this);  
    
    
  }
  
  public void resetApplet(){
    myCardsLeft = new ArrayList<Node>();
    clear();
    Image temp1, temp2, temp3, temp4;
    setBackground(Color.GREEN);  
    URL codeBase = getCodeBase();
    
   // String cardName;
    for (int i = 1; i <= 13; i++){
      temp1 = getImage(codeBase, String.valueOf(i)+"s.png");
      temp2 = getImage(codeBase, String.valueOf(i)+"d.png");
      temp3 = getImage(codeBase, String.valueOf(i)+"c.png");
      temp4 = getImage(codeBase, String.valueOf(i)+"h.png");
      myCardsLeft.add(new Node(temp1, String.valueOf(i)+"s"));
      myCardsLeft.add(new Node(temp2, String.valueOf(i)+"d"));
      myCardsLeft.add(new Node(temp3, String.valueOf(i)+"c"));
      myCardsLeft.add(new Node(temp4, String.valueOf(i)+"h"));
    }    
  }
  
  public void paint(Graphics g)
  {
    int i=0;
    int row = -1;
    int col = 1;
    
    
    
    Node current = myList.peekFirst();
    // display in order
    while (current !=null) {
      if (i%13==0){
        row++;
        col = 1;
      }    
      g.drawImage(current.getImage(), xOffSet + col*dx, row*dy + yOffSet, 75, 109, this);
      current = current.getNext();
      col++;
      i++;
    }
    if (myCardsLeft.size() > 0 ){
      g.drawImage(myCardsLeft.get(0).getImage(), xOffSet + buttonXoffSet, yOffSet, 75, 109, this);
    }
    
    // display in reverse'
    i = 0;
    row = -1;
    col = 1;
    current = myList.peekLast();
    while (current !=null) {
      if (i%13==0){
        row++;
        col = 1;
      }    
      g.drawImage(current.getImage(), (xOffSet+930) + col*dx, row*dy + yOffSet, 75, 109, this);
      current = current.getPrevious();
      col++;
      i++;
    }
    
    Font temp =g.getFont();
    
    Font myFont = new Font("Courier", Font.BOLD, 18);
    g.setFont(myFont);
    
    g.drawString("FORWARD from Front to End.", 200, 500);
     g.drawString("REVERSE from End to Front.", 1200, 500);
   
    g.setFont(temp);
    
  }
  
  public void actionPerformed(ActionEvent e) 
  { 
    // Check the button presses 
    if (e.getSource() == addF) 
    { 
      addToFront(); 
    } 
    else if(e.getSource() == addE){
      addToEnd();
    }
    else if(e.getSource() == removeF){
      removeFirst();
    }
    else if(e.getSource() == removeE){
      removeEnd();
    }        
    else if(e.getSource() == contains){
      contains();
    }
    else if(e.getSource() == delete){
      delete();
    }
     else if(e.getSource() == deleteAtIndex){
      deleteAtIndex();
    }
    
    else if(e.getSource() == insertAfter){
      insertAfter();
    }
    else if(e.getSource() == insertBefore){
      insertBefore();
    }
    else if(e.getSource() == clear){
      clear();
    }   
    else if(e.getSource() == size){
      mySize();
    }   
    else if(e.getSource() == printF){
      printForwards();
    }    
    else if(e.getSource() == printB){
      printBackwards();
    } 
    else if(e.getSource() == reset){
      reset();
    } 
  } 
  public void reset(){
   resetApplet(); 
  }
  
  
  public void insertBefore(){
    if (myCardsLeft.size()>0){
       Node temp = myCardsLeft.get(0);
       String value = input.getText().trim();
       boolean b = myList.insertBefore(value, temp);  
       if(b){
         myCardsLeft.remove(0);
         output.setText("Successfully inserted item: " + value);
       }
       else{
         output.setText("List DOES NOT contains the value: " + value);
       }  
     }
     else{
         output.setText("No more cards to insert");
     }
       
     repaint(); 
  }
  
  public void printBackwards(){
    output.setText("Cards in reverse order: " + myList.toReverseString());    
  }
  
  public void printForwards(){
    output.setText("Cards in order: " +myList.toString());    
  }
  
  
  public void mySize(){
    output.setText("The size of the list is: " + myList.size()); 
    repaint();
  }
  
  public void clear(){
    myList.clear();
    output.setText("The size of the list is: " + myList.size()); 
    repaint();
  }
  
  public void addToFront() 
  { 
    if (myCardsLeft.size() > 0 ){
      myList.addFirst(myCardsLeft.remove(0));      
    }
    output.setText("The size of the list is: " + myList.size()); 
    repaint();        
  } 
  
  public void addToEnd() 
  { 
    if (myCardsLeft.size() > 0 ){
      myList.addLast(myCardsLeft.remove(0));      
    }    
    output.setText("The size of the list is: " + myList.size()); 
    repaint();     
  } 
  
  public void contains(){
    String value = input.getText().trim();
    boolean b = myList.contains(value);
    if(b){
       output.setText("List contains the value: " + value);
    }
    else{
      output.setText("List DOES NOT contains the value: " + value);
    }  
    repaint(); 
    
  }
  public void delete(){
     String value = input.getText().trim();
     boolean b = myList.delete(value);
     if(b){
       output.setText("Deleted item: " + value);
     }
    else{
      output.setText("List DOES NOT contains the value: " + value);
    }  
    repaint();    
  }
  public void deleteAtIndex(){
     String value = input.getText().trim();
     int index;
     try{
       index = Integer.parseInt(value);
     }
     catch (NumberFormatException e){
       output.setText("Cannot delete: Invalid input");
       return;
     }     
     boolean b = myList.deleteElementAt(index);
     if(b){
       output.setText("Item Deleted");
     }
    else{
      output.setText("Item not deleted: List DOES NOT contains the index: " + index);
    }  
    repaint();    
  } 
  
   public void insertAfter(){
     if (myCardsLeft.size()>0){
       Node temp = myCardsLeft.get(0);
       String value = input.getText().trim();
       boolean b = myList.insertAfter(value, temp);  
       if(b){
         myCardsLeft.remove(0);
         output.setText("Successfully inserted item: " + value);
       }
       else{
         output.setText("List DOES NOT contains the value: " + value);
       }  
     }
     else{
         output.setText("No more cards to insert");
     }
       
     repaint(); 
  }
  
  
  
  public void removeFirst(){
    Node temp = myList.removeFront();
    if (temp != null){
      output.setText("Removed card with value: " + temp.getData());
    }
    else{
      output.setText("Nothing to remove");
    }
    repaint();    
  }
  public void removeEnd(){
    Node temp = myList.removeEnd();
    if (temp != null){
      output.setText("Removed card with value: " + temp.getData());
    }
    else{
      output.setText("Nothing to remove");
    }
    repaint();    
  }  
}
