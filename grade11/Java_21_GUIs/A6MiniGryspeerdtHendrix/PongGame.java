
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.ArrayList;

/**
 * <h1>PONG - GAME INSTRUCTIONS</h1>
 * <p>
 * The objective of the game is to score points on your opponet. You score a
 * point if the opponent fails to redirect the ball before it bounces off their
 * side of the screen.
 * </p>
 * <p>
 * PLAYER 1 CONTROLS THE LEFT PADDLE USING THE "Q" (UP) AND "Z" (DOWN) KEYS
 * </p>
 * <p>
 * PLAYER 2 CONTROLS THE RIGHT PADDLE USING THE "KEY UP" (UP) AND "KEY DOWN"
 * (DOWN) KEYS
 * </p>
 * <p>
 * FIRST PLAYER TO 5 POINTS WINS THE GAME.
 * </p>
 * <h3>CLICK START/RESTART TO PLAY - PRESS ENTER TO PAUSE</h3>
 * 
 * @author Hendrix Gryspeerdt
 * 
 * @see also Online version :
 *      <a href="https://www.ponggame.org/">ponggame.org</a>
 */
public class PongGame extends JFrame implements ActionListener, KeyListener {
  
  public static final int CANVAS_WIDTH = 800;                     // game panel width
  public static final int CANVAS_HEIGHT = 400;                    // game panel height
  public static final Color CANVAS_BACKGROUND = Color.BLACK;      // background color
  public static final int PADDLE_WIDTH = 10, PADDLE_HEIGHT = 100; // paddle dimensions
  public static final int BALL_RADIUS = 20;                       // ball radius
  public static final double BALL_SPEED = 5, PADDLE_SPEED = 5;    // ball speed and paddle speed
  
  private Gamecanvas gamePanel; // A custom JPanel on which to draw the paddles, ball and in-game messages
  private JPanel btnPanel; // A JPanel that contains the exit and restart buttons
  
  private Container content; // contains the gamePanel and the buttons
  
  JButton restartBtn, exitBtn; // restart and exit buttons
  
  JLabel howTo; // how to play instructions
  
  ArrayList<Integer> keyList; // list to store pressed keys
  
  int scoreP1, scoreP2; // player scores
  boolean started; // keeps track of is the game is playing
  boolean paused; // keeps track of the paused state of the game
  double ballDirection; // the direction of the ball as an angle in radians
  double startAngle;
  
  private Rectangle2D.Double paddle1, paddle2; // paddles
  private Ellipse2D.Double ball; // ball
  
  Timer timer; // timer object to refresh the screen in regular intervals
  
  public PongGame() {
    timer = new Timer(1, this);
    
    // Initialize the keyList ArrayList
    keyList = new ArrayList<Integer>();
    
    // Initialize paddles
    paddle1 = new Rectangle2D.Double(10, CANVAS_HEIGHT / 2 - PADDLE_HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT);
    paddle2 = new Rectangle2D.Double(780, CANVAS_HEIGHT / 2 - PADDLE_HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT);
    
    ball = new Ellipse2D.Double(CANVAS_WIDTH / 2 - BALL_RADIUS, CANVAS_HEIGHT / 2 - BALL_RADIUS, 2 * BALL_RADIUS,
                                2 * BALL_RADIUS);
    
    // Setting up the button panel of the JFrame
    btnPanel = new JPanel();
    btnPanel.setBackground(Color.WHITE);
    btnPanel.setLayout(new FlowLayout());
    // restart button
    restartBtn = new JButton("Start/Restart"); 
    btnPanel.add(restartBtn);
    restartBtn.addActionListener(this);
    // exit button
    exitBtn = new JButton("Exit"); 
    btnPanel.add(exitBtn);
    exitBtn.addActionListener(this);
    
    // Setting up the game panel of the JFrame
    gamePanel = new Gamecanvas();
    gamePanel.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
    // game instructions
    howTo = new JLabel("<html><h1 style='color:white; text-align: center; font-size: 20px'>PONG - HOW TO PLAY</h1><p style='color:white; text-align: center; font-size: 12px;'>The objective of the game is to score points on your opponet. <br></br>You score a point if the opponent fails to redirect the ball <br></br>before it bounces off their side of the screen.</p><p style='font-size: 5px;'></p><p style='color:white; text-align: center; font-size: 16px;'>- PLAYER 1 CONTROLS THE LEFT PADDLE USING <br></br>THE \"Q\" (UP) AND \"Z\" (DOWN) KEYS<br><p style='font-size: 5px;'></p><p style='color:white; text-align: center; font-size: 16px;'>- PLAYER 2 CONTROLS THE RIGHT PADDLE USING <br></br>THE \"KEY UP\" (UP) AND \"KEY DOWN\" (DOWN) KEYS</p><p style='color:white; text-align: center; font-size: 16px;'><br></br>THE FIRST PLAYER TO 5 POINTS WINS THE GAME.<br></br></p><h3 style='color:white; text-align: center; font-size: 18px'>CLICK START/RESTART TO PLAY <br></br>PRESS ENTER TO PAUSE</h3></html>");
    gamePanel.add(howTo);
    
    // Adding the button panel and game panel to this JFrame
    content = getContentPane();
    content.setLayout(new BorderLayout());
    content.add(btnPanel, BorderLayout.SOUTH);
    content.add(gamePanel, BorderLayout.CENTER);
    
    // detect player key presses
    addKeyListener(this);

    // make sure the program ends when window is closed
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // set the title, pack the components, make window visible and have the window in focus
    setTitle("Pong Game");
    pack();
    setVisible(true);
    requestFocus();
  }
  
  /**
   * Update the position of the ball and refresh the screen.
   */
  public void updateScreen() {
    // only update the location of objects if the game is not paused
    if (!paused) {
      // change paddle location if movement keys are pressed
      for (int i = 0; i < keyList.size(); i++) {
        if (keyList.get(i) == KeyEvent.VK_Q)
          paddle1.y = Math.max(0, paddle1.y - PADDLE_SPEED); // left paddle up
        else if (keyList.get(i) == KeyEvent.VK_Z)
          paddle1.y = Math.min(CANVAS_HEIGHT - PADDLE_HEIGHT, paddle1.y + PADDLE_SPEED); // left paddle down
        else if (keyList.get(i) == KeyEvent.VK_UP)
          paddle2.y = Math.max(0, paddle2.y - PADDLE_SPEED); // right paddle up
        else if (keyList.get(i) == KeyEvent.VK_DOWN)
          paddle2.y = Math.min(CANVAS_HEIGHT - PADDLE_HEIGHT, paddle2.y + PADDLE_SPEED); // right paddle down
      }
      
      // change ball direction if it bounces off the borders or paddles
      
      // top border contact
      if (ball.y <= 0 && Math.sin(ballDirection) > 0) {
        ballDirection = 2 * Math.PI - ballDirection; // flip the angle of the ball trajectory
      }
      // bottom border contact
      if (ball.y >= CANVAS_HEIGHT - 2 * BALL_RADIUS && Math.sin(ballDirection) < 0) {
        ballDirection = 2 * Math.PI - ballDirection; // flip the angle of the ball trajectory
      }
      // left side border contact
      if (ball.x <= 0 && Math.cos(ballDirection) < 0) {
        ballDirection = Math.PI - ballDirection; 
        scoreP2++; // player 2 gets a point
      }
      // right side border contact
      if (ball.x >= CANVAS_WIDTH - 2 * BALL_RADIUS && Math.cos(ballDirection) > 0) {
        ballDirection = Math.PI - ballDirection;
        scoreP1++; // player 1 gets a point
      }
      // paddle 1 contact (left)
      if (testIntersection(ball, paddle1) && Math.cos(ballDirection) < 0) {
        ballDirection = Math.PI - ballDirection;
      }
      // paddle 2 contact (right)
      if (testIntersection(ball, paddle2) && Math.cos(ballDirection) > 0) {
        ballDirection = Math.PI - ballDirection;
      }
      
      // if somebody won the game don't move the ball
      if (Math.max(scoreP1, scoreP2) < 5) {
        // change ball location
        ball.x += BALL_SPEED * Math.cos(ballDirection);
        ball.y -= BALL_SPEED * Math.sin(ballDirection);
      }else {
        // make sure the ball is not off the edge of the game panel when the game stops
        while (ball.x < 0)
          ball.x++;
        while (ball.x > CANVAS_WIDTH - 2 * BALL_RADIUS)
          ball.x--;
      }
    }
    
    // repaint the game panel
    gamePanel.repaint();
  }
  
  /**
   * Resets the positions of the paddles and the ball. Also generates a new
   * direction in which the ball will start moving.
   */
  public void restart() {
    started = true;
    paused = false;
    gamePanel.remove(howTo);// remove the menu screen
    
    // return the paddles to their starting positions
    paddle1.y = CANVAS_HEIGHT / 2 - PADDLE_HEIGHT / 2;
    paddle2.y = CANVAS_HEIGHT / 2 - PADDLE_HEIGHT / 2;
    
    // return the ball to the center
    ball.y = CANVAS_HEIGHT / 2 - BALL_RADIUS;
    ball.x = CANVAS_WIDTH / 2 - BALL_RADIUS;
    
    // gives the ball some random diagonal starting direction (45, 135, 225, or 315 degrees)
    ballDirection = (Math.PI / 4) + (Math.PI / 2) * ((int) (Math.random() * 4));
    startAngle = 2 * Math.PI - ballDirection;
    
    // reset the scores
    scoreP1 = 0;
    scoreP2 = 0;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    // update the screen if the timer was the source
    if (e.getSource() == timer && started)
      updateScreen();
    // check if restart button was preessed
    else if (e.getSource() == restartBtn) {
      restart();
    }
    // check if the exit button was pressed
    else if (e.getSource() == exitBtn)
      System.exit(0);
    
    requestFocus();
    
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    // if enter key is pressed, toggle paused
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      if (paused)
        paused = false;
      else    
        paused = true;
        // if key was not "ENTER", add it to the pressed keys list
    }else if (!keyList.contains(e.getKeyCode()))
      keyList.add(e.getKeyCode());
  }
  
  @Override
  public void keyReleased(KeyEvent e) {
    // removes key from the pressed keys list 
    if (keyList.contains(e.getKeyCode())) {
      int index = keyList.indexOf(e.getKeyCode());
      keyList.remove(index);
    }
  }
  
  @Override
  public void keyTyped(KeyEvent e) {}// do nothing
  
  /**
   * Tests the intersection of two shapes.
   * 
   * @param shapeA
   * @param shapeB
   * @return true if the areas of shapes A and B intersect, false otherwise.
   */
  public static boolean testIntersection(Shape shapeA, Shape shapeB) {
    Area areaA = new Area(shapeA);
    areaA.intersect(new Area(shapeB));
    return !areaA.isEmpty();
  }
  
  /**
   * Gamecanvas (inner class) is a JPanel used for custom drawing
   */
  class Gamecanvas extends JPanel {
    /**
     * override the default paintComponent method.
     */
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      setBackground(CANVAS_BACKGROUND);
      if (started) {
        g2d.setColor(Color.WHITE);// set draw color
        
        // draw mid line
        float dash1[] = {10.0f};
        BasicStroke dashed = new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1,0.0f);
        g2d.setStroke(dashed);
        g2d.drawLine(CANVAS_WIDTH / 2, CANVAS_HEIGHT, CANVAS_WIDTH / 2, 0);
        
        //turn on atialiasing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // draw scores
        g2d.setFont(new Font("Goudy Handtooled BT", Font.BOLD, 80));
        g2d.drawString(scoreP1 + "", 170, 100);
        g2d.drawString(scoreP2 + "", 570, 100);
        
        // draw paddles
        g2d.fill(paddle1);
        g2d.fill(paddle2);
        
        // draw ball
        g2d.fill(ball);
        
        // if a player gets 5 points, display game over message and stop the game
        if (scoreP1 == 5) {
          started = false;
          g2d.drawString("WIN", 120, CANVAS_HEIGHT / 2);
          g2d.setFont(new Font("Goudy Handtooled BT", Font.BOLD, 30));
          g2d.drawString("Click Start/Restart", 80, 2 * CANVAS_HEIGHT / 3);
          g2d.drawString("to play again", 80, 2 * CANVAS_HEIGHT / 3 + 40);
        } else if (scoreP2 == 5) {
          started = false;
          g2d.drawString("WIN", 520, CANVAS_HEIGHT / 2);
          g2d.setFont(new Font("Goudy Handtooled BT", Font.BOLD, 30));
          g2d.drawString("Click Start/Restart", CANVAS_WIDTH / 2 + 80, 2 * CANVAS_HEIGHT / 3);
          g2d.drawString("to play again", CANVAS_WIDTH / 2 + 80, 2 * CANVAS_HEIGHT / 3 + 40);
        }
        // if the game is paused, display the paused message
        if (paused) {
          g2d.drawString("GAME PAUSED", 131, CANVAS_HEIGHT / 2);
        }
      }
    }
  }
  
  public static void main(String[] args) {
    // run the game
    PongGame pg = new PongGame();
    pg.timer.start();
  }
}