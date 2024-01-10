import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
/**
 * Custom Graphics Example: Using key/button to move a line left or right.
 */
public class CGMoveABall extends JFrame implements ActionListener, KeyListener{
     // Name-constants for the various dimensions
    public static final int CANVAS_WIDTH = 400;
    public static final int CANVAS_HEIGHT = 140;
    public static final Color CIRCLE_COLOR = Color.RED;
    public static final Color CANVAS_BACKGROUND = Color.CYAN;
    
    // The line from (x1, y1) to (x2, y2), initially position at the center
     private int x1 = CANVAS_WIDTH / 2;
    private int y1 = CANVAS_HEIGHT / 2;
    
    private int ballWidth = 20;
    private int ballHeight = 20;
    
    
    private DrawCanvas canvas; // the custom drawing canvas (extends JPanel)
      JButton btnLeft, btnRight, btnUp, btnDown;
    
    /** Constructor to set up the GUI */
    public CGMoveABall() {
      // Set up a panel for the buttons
        JPanel btnPanel = new JPanel(new BorderLayout());
        
        btnPanel. setPreferredSize(new Dimension(50,200));
        
        btnLeft = new JButton("Left ");
        btnRight = new JButton("Right");
        btnUp = new JButton("Up ");
        btnDown = new JButton("Down");
                
        btnLeft.addActionListener(this);
        btnRight.addActionListener(this);            
        btnUp.addActionListener(this);
        btnDown.addActionListener(this);  
               
        btnPanel.add(btnUp,  BorderLayout.NORTH);
        btnPanel.add(btnLeft,  BorderLayout.WEST);
        btnPanel.add(btnRight,  BorderLayout.EAST) ;
        btnPanel.add(btnDown,  BorderLayout.SOUTH);
        
               
                     
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
        setTitle("Move a Ball");
        pack(); // pack all the components in the JFrame
        setVisible(true); // show it
        requestFocus(); // set the focus to JFrame to receive KeyEvent
    }
    public void actionPerformed(ActionEvent e)
    {
         if (e.getSource()==btnLeft)
        {
            x1 -= 10;   
            
        }
        
        else if (e.getSource()==btnRight)
        {
            x1 += 10;        
        }
         else if (e.getSource()==btnUp)
        {
            y1 -= 10;        
        }
          else if (e.getSource()==btnDown)
        {
            y1 += 10;        
        }
        canvas.repaint();
        requestFocus(); 
    }
    
    public void keyPressed(KeyEvent evt) {
         switch(evt.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                x1 -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                x1 += 10;
                break;
            case KeyEvent.VK_UP:
                y1 -= 10;
                break;
            case KeyEvent.VK_DOWN:
                y1 += 10;
                break;         
        }
        repaint();
    }
    public void keyReleased(KeyEvent evt) {}
    public void keyTyped(KeyEvent evt) {}
    
    /** The entry main() method */
    public static void main(String[] args) {
        new CGMoveABall(); // Let the constructor do the job
    }
    /**
     * DrawCanvas (inner class) is a JPanel used for custom drawing
     */
    class DrawCanvas extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(CANVAS_BACKGROUND);
            g.setColor(CIRCLE_COLOR);
            g.fillOval(x1, y1, ballWidth, ballHeight); // draw the line
        }   
    }
}