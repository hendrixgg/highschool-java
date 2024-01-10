package Examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*; // For Ellipse2D, etc.

class ShapeExample extends JFrame implements KeyListener{ 
    
    // initialize
    Ellipse2D.Double circle;
    Rectangle2D.Double square; 
    
    // set the canvas dimentions
    public static final int CANVAS_WIDTH = 800;
    public static final int CANVAS_HEIGHT = 800;
    
    DrawCanvas canvas;
    
    public ShapeExample(){
        
        // initialize the shapes with their initial x ,y, w, h
        circle = new Ellipse2D.Double(10, 10, 350, 350);
        square = new Rectangle2D.Double(10, 10, 350, 350);
        
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
        // check for different keys
        switch(evt.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                circle.x -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                circle.x += 10;
                break;
            case KeyEvent.VK_UP:
                circle.y -= 10;
                break;
            case KeyEvent.VK_DOWN:
                circle.y += 10;
                break;                  
            case KeyEvent.VK_A:
                square.x -= 10;
                break;
            case KeyEvent.VK_D:
                square.x += 10;
                break;
            case KeyEvent.VK_W:
                square.y -= 10;
                break;
            case KeyEvent.VK_S:
                square.y += 10;
                break;
            case KeyEvent.VK_Z:
                square.width += 10;
                 square.x -= 5;
                break;  
            case KeyEvent.VK_X:
                square.width -= 10;
                square.x += 5;
                break;  
            case KeyEvent.VK_C:
                square.height += 10;
                square.y -= 5;
                break;  
            case KeyEvent.VK_V:
                square.height -= 10;
                square.y += 5;
                break;  
        }
        // update the canvas
        canvas.repaint();
    }
    public void keyReleased(KeyEvent evt) {}
    public void keyTyped(KeyEvent evt) {}
        
    public static void main(String[] ars){
        new ShapeExample();     
    }
        
    /**
     * DrawCanvas (inner class) is a JPanel used for custom drawing
     */
    class DrawCanvas extends JPanel {
        public void paintComponent(Graphics g) {
            // erase the screen
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D)g;
            // draw circle and draw square
            g2d.fill(circle);
            g2d.draw(square);
        }   
    }
}