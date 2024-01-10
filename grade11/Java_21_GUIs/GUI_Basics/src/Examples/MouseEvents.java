package Examples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEvents extends JFrame implements MouseListener {
    
    /**
     *
     */
    private static final long serialVersionUID = 4493858772979229272L;
    private int x;
    private int y;
    
    public MouseEvents(){
        
        addMouseListener(this);
        setSize(600,600);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void mouseClicked (MouseEvent e){
        x = e.getX();
        y = e.getY();
        System.out.println("Circle drwan at: " + x + ", " + y);
        repaint();
    }
    
    public void mousePressed (MouseEvent e){
        //Pressed
    }
    
    public void mouseReleased (MouseEvent e){
        //Released
    }
    
    public void mouseEntered (MouseEvent e){
        //Entered
    }
    
    public void mouseExited (MouseEvent e){
        //Exited
    }
    
    public void paint (Graphics g){
        System.out.println(x + ", " + y);
        g.fillOval(x-10,y-10,20,20);
    }
    
    public static void main(String [] args){
        new MouseEvents();
    }
    
}
