import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.geom.*; 
import java.util.*;

class CollisionGame extends JFrame implements ActionListener, KeyListener{
  
  /**
	 *
	 */
	private static final long serialVersionUID = -1344440407499683564L;
// Name-constants for the various dimensions
  public static final int CANVAS_WIDTH = 400;
  public static final int CANVAS_HEIGHT = 800;
  public static final Color CANVAS_BACKGROUND = Color.CYAN;
  
  // the custom drawing canvas (extends JPanel)
  private DrawCanvas canvas; 
  
  JButton btnRestart, btnExit;
  
  int dx;
  int dy;
  
  int paddleWidth;
  int paddleHeight;
  
  int score;
  int lives;
  
  boolean started;
  
  // array of shapes
  Shape shapes[];
  // array of speeds related to the array of shapes
  int speeds[];
  
  //makle a rectangle
  private Rectangle2D.Double paddle; 
  
  Random rand;
  Timer timer;
  
  /** Constructor to set up the GUI */
  public CollisionGame() {
    timer =  new Timer(20, this);
    score=0;
    
    rand = new Random();
    paddleWidth = 50;
    paddleHeight=10;
    
    
    shapes = generate2DShapes();
    speeds = generateSpeeds();  
    
    paddle = new Rectangle2D.Double(CANVAS_WIDTH/ 2- paddleWidth/2, CANVAS_HEIGHT-paddleHeight-5, paddleWidth, paddleHeight);
    // paddle = new Rectangle2D.Double(CANVAS_WIDTH/ 2- paddleWidth/2, CANVAS_HEIGHT-paddleHeight-5 , paddleWidth, paddleHeight);
    
    // Set up a panel for the buttons
    JPanel btnPanel = new JPanel(null);
    btnPanel.setBackground(Color.WHITE);
    
    btnPanel.setPreferredSize(new Dimension(160, CANVAS_HEIGHT));
    btnRestart = new JButton("Start/Restart");
    btnPanel.add(btnRestart);
    btnRestart.addActionListener(this);
    btnRestart.setBounds(5, 300, 150, 30);
    
    
    btnExit = new JButton("Exit");
    btnPanel.add(btnExit);
    btnExit.addActionListener(this); 
    btnExit.setBounds(5, 350, 150, 30);
    
    // Set up a custom drawing JPanel
    canvas = new DrawCanvas();
    canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
    
    // Add both panels to this JFrame
    Container cp = getContentPane();
    cp.setLayout(new BorderLayout());
    cp.add(canvas, BorderLayout.CENTER);
    cp.add(btnPanel, BorderLayout.EAST);
    
    // "this" JFrame fires KeyEvent
    addKeyListener(this);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    // Handle the CLOSE button
    setTitle("Collision Avoidance Game");
    pack();           // pack all the components in the JFrame
    setVisible(true); // show it
    requestFocus();
  }
  // generate a random integer relating the shape at that index with the a speed at that same index
  public int[] generateSpeeds(){
    int[] speeds = new int[10];
    
    for(int i=0; i<speeds.length; i++){
      speeds[i]= rand.nextInt(3)+1;
    }
    return speeds;        
  }
  // create an array of 2d shapes
  public Shape[] generate2DShapes(){
    
    Shape[] shapes = new Shape[10];
    
    int rectangleOrEllipse, locX, locY, width, height;
    int minWidth = 10;
    int maxWidth = 50;
    int minHeight = 10;
    int maxHeight = 50;
    
    for (int i=0; i<shapes.length;i++){
      // randomize creating a rectangle or ellipse
      rectangleOrEllipse = rand.nextInt(2);
      // specify the width and height of shape
      width = rand.nextInt(maxWidth - minWidth) + minWidth;
      height = rand.nextInt(maxHeight - minHeight) + minHeight;
      //randomize the location of the shape
      locX = rand.nextInt(CANVAS_WIDTH - width);
      locY = rand.nextInt(100)-200;           
      
      // add the rectangle or ellipse to the array of shapes
      if (rectangleOrEllipse == 0){
        
        shapes[i]= new Ellipse2D.Double(locX,locY, width, height);
      }
      else{
        shapes[i]= new Rectangle2D.Double(locX,locY, width, height);
      }            
    }
    return shapes;        
  }
  // update the coordinates of the shapes and refresh the screen.    
  public void updateScreen(){
    
    for(int i=0; i<shapes.length; i++){
      // update the rectangle
      if (shapes[i] instanceof Rectangle2D.Double){
        Rectangle2D.Double temp = (Rectangle2D.Double)shapes[i];
        // check if its off the screen at the bottom
        if (temp.y > CANVAS_HEIGHT){
          score++;
          speeds[i]++;
          temp.y = rand.nextInt(100)-200;  
          temp.x = rand.nextInt(CANVAS_WIDTH - (int)temp.width);
        }
        // check if it hit the paddle
        else if(temp.y >= paddle.y && testIntersection(temp,paddle) == true){
          // update state of game. Set it as not started
          started = false;
          break;
        }
        // update location of shape
        temp.y = temp.y + speeds[i];
        
      }
      else{
        // update ellipse
        Ellipse2D.Double temp = (Ellipse2D.Double)shapes[i];
        // check if its off the screen at the bottom
        if (temp.y > CANVAS_HEIGHT){
          score++;
          speeds[i]++;
          temp.y = rand.nextInt(100)-200;  
          temp.x = rand.nextInt(CANVAS_WIDTH - (int)temp.width);
        }
        // check if it hit the paddle
        else if(temp.y >= paddle.y && testIntersection(temp,paddle) == true){
          // update state of game. Set it as not started
          started = false;
          break;
        }
        // update location of shape
        temp.y = temp.y + speeds[i];
      }        
    }
    // repaint the canvas
    canvas.repaint();
  }
  
  public void actionPerformed(ActionEvent e)
  {
    // check if restart button was pressed
    if (e.getSource()== btnRestart)
    {    
      shapes = generate2DShapes();
      speeds = generateSpeeds();      
      
      System.out.println("Start/Restart");
      started = true;
    }
    // check if exit button was pressed
    else if (e.getSource()==btnExit)
    { 
      System.exit(0);
    }
    else if (e.getSource()==timer &&  started == true){
      updateScreen();   
    }
    requestFocus(); // change the focus to JFrame to receive KeyEvent
  }
  
  public void keyPressed(KeyEvent evt) {
    //check for key press and update the position of the paddles
    switch(evt.getKeyCode()) {
      case KeyEvent.VK_LEFT:           
        paddle.x = Math.max(0, paddle.x - 5);             
        break;
      case KeyEvent.VK_RIGHT:
        paddle.x= Math.min(CANVAS_WIDTH - paddleWidth, paddle.x + 5);
        break;
        
      case KeyEvent.VK_UP:           
        paddle.y--;
        break;
      case KeyEvent.VK_DOWN:
        paddle.y++;
        break;                
    }
  }
  public void keyReleased(KeyEvent evt) {
    /* switch(evt.getKeyCode()) {
     case KeyEvent.VK_LEFT:           
     paddle.x = Math.max(0, paddle.x - 5);             
     break;
     case KeyEvent.VK_RIGHT:
     paddle.x= Math.min(CANVAS_WIDTH - paddleWidth, paddle.x + 5);
     break;
     case KeyEvent.VK_UP:           
     paddle.y--;
     break;
     case KeyEvent.VK_DOWN:
     paddle.y++;
     break;
     
     }*/
  }
  public void keyTyped(KeyEvent evt) {
    //check for key press and update the position of the paddles
    /*  switch(evt.getKeyCode()) {
     case KeyEvent.VK_LEFT:           
     paddle.x = Math.max(0, paddle.x - 5);             
     break;
     case KeyEvent.VK_RIGHT:
     paddle.x= Math.min(CANVAS_WIDTH - paddleWidth, paddle.x + 5);
     break;
     case KeyEvent.VK_UP:           
     paddle.y--;
     break;
     case KeyEvent.VK_DOWN:
     paddle.y++;
     break;
     
     }*/
  }
  
  
  
  
  
  public static boolean testIntersection(Shape shapeA, Shape shapeB) {
    Area areaA = new Area(shapeA);
    areaA.intersect(new Area(shapeB));
    return !areaA.isEmpty();
  }
  
  
  
  /**
   * DrawCanvas (inner class) is a JPanel used for custom drawing
   */
  class DrawCanvas extends JPanel {
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D)g;
      
      setBackground(CANVAS_BACKGROUND); 
      
      for(int i=0; i<shapes.length; i++){
        
        if (shapes[i] instanceof Rectangle2D.Double){
          Rectangle2D.Double temp = (Rectangle2D.Double)shapes[i];   
          g2d.fill(temp); 
        }
        else{
          Ellipse2D.Double temp = (Ellipse2D.Double)shapes[i];                    
          g2d.fill(temp); 
        }                
      }
      g2d.setPaint(Color.RED);  
      g2d.fill(paddle);
      
      // draw text   
      g2d.setFont(new Font("Goudy Handtooled BT", Font.PLAIN, 80));
      g2d.drawString(score+"", 10,100); 
      
      
    }  
  }
  
  /** The entry main() method */
  public static void main(String[] args) {
    
    CollisionGame cg = new CollisionGame(); // set up the game
    cg.timer.start();
    while (true){           
      if (cg.started){
        cg.updateScreen();                    
      }
      delay(10);             
    }
  }
  public static void delay(int milli){
    try{
      Thread.sleep(milli);
    }
    catch(Exception e){}
  }
  
}


