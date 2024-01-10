package Examples;

import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

class MultiKeyPress extends JFrame implements ActionListener, KeyListener{ 
       
    // set the canvas dimentions
    public static final int CANVAS_WIDTH = 800;
    public static final int CANVAS_HEIGHT = 800;
    
    DrawCanvas canvas;
    
    ArrayList<String> keyList;
    Timer timer;
    public MultiKeyPress(){    
        // make the timer to call the actionPerformed method every 20 milliseconds
        timer = new Timer(20, this);   
        keyList = new ArrayList<String>();
        // initialize the canvas and dimensions
        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        
        Container content = getContentPane();
        content.add(canvas);
        
        // add a keylistener to the frame
        addKeyListener(this);
        
        pack();
        setVisible(true);     
    }
    
    public void keyPressed(KeyEvent evt) {
        // check if key presses is in the list, if not add it to the list of currently pressed keys
        if (!keyList.contains(evt.getKeyCode()+"")){
            keyList.add(evt.getKeyCode()+"");
        }       
    }
    public void keyReleased(KeyEvent evt) {
        // remove from list of it exists
         if (keyList.contains(evt.getKeyCode()+"")){
             int index = keyList.indexOf(evt.getKeyCode()+"");
             keyList.remove(index);
        }   
    }
    public void keyTyped(KeyEvent evt) {}
        
    public void actionPerformed(ActionEvent evt){
 
        canvas.repaint();
    }    
    public static void main(String[] ars){
        MultiKeyPress prog = new MultiKeyPress();     
        prog.timer.start();
    }  
    
    /**
     * DrawCanvas (inner class) is a JPanel used for custom drawing
     */
    class DrawCanvas extends JPanel {
        public void paintComponent(Graphics g) {
            // erase the screen
            super.paintComponent(g);
            g.drawString(keyList.toString(), 100, 100);
            // see what is in the list of keys and make the necessary coordinate changes here
            // and draw the shapes.
        }   
    }
}