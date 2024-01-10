package Examples;

// Starter Template 
// import(s) at top of program b4 class line

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIwithButtons extends JFrame implements ActionListener {
    // Variable and GUIObject Declaration area

    /**
     *
     */
    private static final long serialVersionUID = 4539145115731951300L;
    JButton b1, b2;

    public static void main(String[] args) {
        new GUIwithButtons();
    }

    public GUIwithButtons() {
        // Create object and your code goes here

        Container content = getContentPane();
        content.setLayout(new FlowLayout());

        b1 = new JButton("Button 1");
        b2 = new JButton("Button 2");
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setSize(500, 500);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            System.out.println("it was button one");
        } else if (e.getSource() == b2) {
            System.out.println("it was button two");
        }
    }
}