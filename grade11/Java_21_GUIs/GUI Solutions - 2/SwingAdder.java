// import(s) at top of program b4 class line

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAdder  extends JFrame implements ActionListener{
        
    // global variables for the component
    JButton up, down, reset;
    JLabel counter;
    JTextField value;
    int count;
    
    public static void main(String[ ] args) 
    {
        SwingAdder g = new  SwingAdder();              
    }  
    
    public SwingAdder (){
        //Create object and your code goes here
        count = 0;
        
        // get the content of frame and set layout
        Container content = getContentPane();
        content.setLayout(new FlowLayout());
        
        // initialize the components
        counter = new JLabel("Counter");
        value = new JTextField("0",5);
          
        up = new JButton("Count Up");
        down = new JButton("Count Down");
        reset = new JButton("Reset");
        
        // add each component to the content of the frame
        content.add(counter);
        content.add(value);
        content.add(up);
        content.add(down);
        content.add(reset);
        
        // add the ActionListeners to the components
        up.addActionListener(this);
        down.addActionListener(this);
        reset.addActionListener(this);
        
        // pack up the frame
        pack();
        setVisible(true);  
              
    } 
    
    public void actionPerformed(ActionEvent e)
    {
        // check the source of the action
        if (e.getSource()==up)
        {
           count++;
        }
        else if (e.getSource()==down)
        {
            count--;
        }
        else if (e.getSource()==reset)
        {
            count=0;
        }
        // set textbox be value of count as a string
        value.setText(count+"");
    }
}


