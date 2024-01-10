// import(s) at top of program b4 class line

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAdder2  extends JFrame implements ActionListener{
    
    // global components
    JLabel firstNum;
    JTextField value1;
    
    JLabel secondNum;
    JTextField value2;
    
    JLabel result;
    JTextField value3;
    
    JButton addB;
    JButton clearB;
    
    public static void main(String[ ] args) 
    {
        SwingAdder2 g = new  SwingAdder2();       
    }  
    
    public SwingAdder2 (){
        
        // get the content of the frame and set layout        
        Container content = getContentPane();
        content.setLayout(new GridLayout(4, 2));
        
        // initialize the components
        firstNum = new JLabel("First Number");
        value1 = new JTextField("0", 5);
        secondNum = new JLabel("Second Number");
        value2 = new JTextField("0", 5);
        result =  new JLabel("Result");
       
        value3 = new JTextField("0", 5);
         value3.setEditable(false);
        
        addB = new JButton("Add");
        clearB = new JButton("Clear");
        
        content.add(firstNum);
        content.add(value1);
        content.add(secondNum);
        content.add(value2);
        content.add(result);
        content.add(value3);
        
        content.add(addB);
        content.add(clearB);
        
        addB.addActionListener(this);
        clearB.addActionListener(this);
        
        pack();
        setVisible(true);      
        
    } 
    
    public void actionPerformed(ActionEvent e)
    {
        int num1, num2;
        
        if (e.getSource()==addB)
        {
            try{
                // get the value of textboxes and convert them to int to add them up
                num1 = Integer.parseInt(value1.getText());
                num2 = Integer.parseInt(value2.getText());
                // set result to textfield
                value3.setText((num1+num2)+"");
            }
            catch(Exception excep){
                System.out.println("Invalid input");
            }      
            
        }
        else if (e.getSource()==clearB)
        {
            value3.setText("");
        }
        
    }
}


