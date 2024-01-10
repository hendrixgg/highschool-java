import java.awt.*;
import hsa_ufa.Console;

public class PixelGraphics
{
  static Console c; 
  
  public static void main (String[] args) throws InterruptedException // for the pause times
  {
   
    // console creation (0, 0) is in the top left corner
    c = new Console (600, 500, "Testing");
    
    c.drawLine(10, 20, 100, 200);    
    
    c.drawStar(200, 200, 50, 50);
        String s = "hello world - in default font";
   c.drawString(s, 100,50);
    
    Font f1 = new Font("Jokerman", Font.PLAIN, 20);
    Font f2 = new Font("Serif", Font.ITALIC, 16);
    Font f3 = new Font ("Garamond", Font.BOLD, 11);
    
    c.setFont(f1);
    String s1 = "hello world - in Jokerman font";
    c.drawString(s1, 100,100);
    
    c.setFont(f2);
    String s2 = "hello world - in Serif font";
    c.drawString(s2, 100,200);
    c.setFont(f3);
    
    String s3 = "hello world - in Garamond font";
    c.drawString(s3, 100,300);    


  } 
}