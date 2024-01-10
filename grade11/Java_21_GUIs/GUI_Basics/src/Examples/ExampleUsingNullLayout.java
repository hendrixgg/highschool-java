package Examples;

// Starter Template 
// import(s) at top of program b4 class line

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExampleUsingNullLayout extends JFrame implements ActionListener {
    // Variable and GUIObject Declaration area

    /**
     *
     */
    private static final long serialVersionUID = -2596079316420458340L;
    JPanel p1;
    JButton b1, b2, b3;

    public static void main(String[] args) {
        new ExampleUsingNullLayout();
    }

    public ExampleUsingNullLayout() {
        // Create object and your code goes here
        setTitle("Null Layout");
        // get a reference to the container in the frame
        Container content = getContentPane();
        content.setLayout(null);

        // create three buttons
        b1 = new JButton("Button 1");
        b2 = new JButton("Button 2");
        b3 = new JButton("Button 3");

        // set the x, y, w, h of the buttons
        b1.setBounds(50, 50, 100, 20);
        b2.setBounds(500, 250, 200, 200);
        b3.setBounds(250, 350, 100, 40);

        // set to respond when the button is clicked
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        // add the buttons to the content container
        content.add(b1);
        content.add(b2);
        content.add(b3);

        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            System.out.println("You pushed button 1");
        } else if (e.getSource() == b2) {
            System.out.println("You pushed button 2");
        } else if (e.getSource() == b3) {
            System.out.println("You pushed button 3");
        } else {
            System.out.println("unknown source of action");
        }
    }
}