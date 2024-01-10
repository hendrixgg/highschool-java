import java.awt.*;
import hsa_ufa.Console;

public class PicMove
{
  static Console c; 
  
  public static void main (String[] args) throws InterruptedException // for the pause times
  {
   
    // console creation
    c = new Console (600, 500, "Testing");
    
    // the input for the star image
    Image star;
    star = Toolkit.getDefaultToolkit ().getImage ("star.png"); 
    
    // player location and speed
    double imageX = 280, imageY = 410;
    double imageSpeed = 2;
        
    // variables to hold the player input
    int playerKeyCode;
    char playerKeyChar;
    
    // set to true to exit the game loop
    boolean done = false;    
    
    // background color
    c.setBackgroundColor (new Color (0, 128, 0));
    // set text color
    c.setColor (Color.white) ;
    
    // clear to set background
    c.clear() ;
    
    // The game loops until the variable "done" is set to true.
    while (!done)
    {
      // pause
     Thread.sleep (30);
      
      // the ascii code of the key currently held down   
      playerKeyCode = c.getKeyCode (); 
      
      // the character of the key currently held down
      playerKeyChar = c.getKeyChar (); 
      
      // takes inputs for left and right.
      if (playerKeyCode == Console.VK_RIGHT && !(imageX > 550))
      {
        imageX = imageX + imageSpeed;        
      }
      else if(playerKeyCode == Console.VK_LEFT && !(imageX < 0))
      {
        imageX = imageX - imageSpeed;        
      }
      // up and down
      else if(playerKeyCode == Console.VK_DOWN && !(imageY > 450))
      {
        imageY = imageY + imageSpeed;        
      }
      if (playerKeyCode == Console.VK_UP && !(imageY < 0))
      {
        imageY = imageY - imageSpeed;        
      }      
      
      // quit function
      else if (playerKeyChar == 'q'){
        done = true;
      }
      // draw the screen and stop it from flickering
      synchronized(c) 
      {
        c.clear ();
        c.setCursor(0,0);
        // title
        c.println ("Arrow keys to move, q to quit");
        // sets color
        c.setColor (Color.white);
        // draws star
        c.drawImage (star, (int)imageX, (int)imageY, 40, 40);        
      }
    }
    // quits game
    c.close ();    
  } 
}