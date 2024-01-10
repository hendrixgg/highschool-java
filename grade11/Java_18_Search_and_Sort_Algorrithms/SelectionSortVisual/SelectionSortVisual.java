
import java.awt.*;
import hsa_ufa.Console;
import java.util.Random;
public class SelectionSortVisual
{
    static Console c;           // The output console
    static Random generator;
    
    
    public static void main (String [] args)  throws Exception
    {
        c = new Console ();
        generator = new Random ();
        int [] num = new int [20];
        for (int i = 0 ; i < num.length ; i++)
        {
            num [i] = 0;
        }
        
        
        for (int i = 0 ; i < num.length ; i++)
        {
            num [i] = (getNextRandInt (70));
        }
        selectionSort (num);
        
    } // main method
    
    
    public static void selectionSort (int list []) throws Exception
    
    {
        int top;
        int largeLoc;
        int i;
        int temp;
        for (top = list.length - 1 ; top > 0 ; top--)
        {
            largeLoc = 0;
            for (i = 1 ; i <= top ; i++)
            {
                if (list [i] > list [largeLoc])
                {
                    largeLoc = i;                   
                }
            }
            temp = list [top];
            list [top] = list [largeLoc];
            list [largeLoc] = temp;
           
            
            //Visually depicts the sort using the "*" symbol to represent the number.
            for (int k = 0 ; k < list.length ; k++)
            {
                
                for (int j = 0 ; j < list [k] ; j++)
                {
                    if (k == i-1){
                        c.setColor(Color.RED);
                        c.print ("*");
                    }
                    else{
                        c.print ("*");
                    }
                }
                c.setColor(Color.BLACK);
                c.println ("");
            }            
           Thread.sleep (1500);
           c.clear();
        }
    } // SelectionSort class
    public static int getNextRandInt (int MAX)
    {
        return (int) (generator.nextDouble () * (MAX) + 1);
    }
}

