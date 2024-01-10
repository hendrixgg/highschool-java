package Examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Custom Graphics Example: Using key/button to move a line left or right.
 */

public class CGMoveALine extends JFrame implements ActionListener, KeyListener{
    /**
     *
     */
    private static final long serialVersionUID = -2204050825361515854L;
    // Name-constants for the various dimensions
    public static final int CANVAS_WIDTH = 400;
    public static final int CANVAS_HEIGHT = 140;
    public static final Color LINE_COLOR = Color.BLACK;
    public static final Color CANVAS_BACKGROUND = Color.CYAN;
    
    // The line from (x1, y1) to (x2, y2), initially position at the center
    private int x1 = CANVAS_WIDTH / 2;
    private int y1 = CANVAS_HEIGHT / 8;
    private int x2 = x1;
    private int y2 = CANVAS_HEIGHT / 8 * 7;
    
    private DrawCanvas canvas; // the custom drawing canvas (extends JPanel)
    
    JButton btnLeft, btnRight;
    
    /** Constructor to set up the GUI */
    public CGMoveALine() {
        // Set up a panel for the buttons
        JPanel btnPanel = new JPanel(new FlowLayout());
        btnLeft = new JButton("Move Left ");
        btnPanel.add(btnLeft);
        btnLeft.addActionListener(this);
        
        btnRight = new JButton("Move Right");
        btnPanel.add(btnRight);
        btnRight.addActionListener(this);            
        
        // Set up a custom drawing JPanel
        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        
        // Add both panels to this JFrame
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(canvas, BorderLayout.CENTER);
        cp.add(btnPanel, BorderLayout.SOUTH);
        
        // "this" JFrame fires KeyEvent
        addKeyListener(this);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        // Handle the CLOSE button
        setTitle("Move a Line");
        pack();           // pack all the components in the JFrame
        setVisible(true); // show it
        requestFocus();   // set the focus to JFrame to receive KeyEvent
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btnLeft)
        {
            x1 -= 10;
            x2 -= 10;
            canvas.repaint();
            requestFocus(); // change the focus to JFrame to receive KeyEvent
        }
        
        else if (e.getSource()==btnRight)
        {
            x1 += 10;
            x2 += 10;
            canvas.repaint();
            requestFocus(); // change the focus to JFrame to receive KeyEvent
        }
    }
    
    public void keyPressed(KeyEvent evt) {
        switch(evt.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                x1 -= 10;
                x2 -= 10;
                repaint();
                break;
            case KeyEvent.VK_RIGHT:
                x1 += 10;
                x2 += 10;
                repaint();
                break;
        }
    }
    public void keyReleased(KeyEvent evt) {}
    public void keyTyped(KeyEvent evt) {}
    
    
    
    /** The entry main() method */
    public static void main(String[] args) {
        
        new CGMoveALine(); // Let the constructor do the job
        
    }
    
    /**
     * DrawCanvas (inner class) is a JPanel used for custom drawing
     */
    class DrawCanvas extends JPanel {
        
        /**
         *
         */
        private static final long serialVersionUID = -8872703864434430817L;

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(CANVAS_BACKGROUND);
            g.setColor(LINE_COLOR);
            g.drawLine(x1, y1, x2, y2); // draw the line
        }
    }
}
