//Hendrix Gryspeerdt
//date created (dd/mm/yyyy): 23/04/2020

/* This program is a scenery on the Console window using a variety of shapes and colors.
 * This scenery will include at least 3 different animation elements, 5 different
 * draw commands and 2 different fonts. The message will be at least 2 lines long and
 * include my name.
 */

// Console Consolename = new Console(width,heigh,fontsize,"Title")

import hsa_ufa.Console;
//import java.util.*;

class AnimationAssignment_GryspeerdtHendrix
{
  
  
  public static void main(String []args)
  {
    Console c1 = new Console(650,500,11,"Animated Scenery");
    
    c1.print("testing... testing... 1 2 3");
    
    
    try
    {
      Thread.sleep(10000); // 10 seconds
      
      System.exit(0);
    }
    catch(InterruptedException e)
    {
     System.err.println(e.getMessage()); 
    }
    
  }
  
}