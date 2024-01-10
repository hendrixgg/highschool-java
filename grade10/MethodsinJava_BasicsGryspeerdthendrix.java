//Hendrix Gryspeerdt
//Methods in Java - Basics
//Date: 06/01/2020

 import java.util.Scanner;
 import java.util.concurrent.ThreadLocalRandom;
 import java.text.DecimalFormat;
class MethodsinJava_Basics
{
    public static Scanner input = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("###,###.###");
    
  public static void diceRoll ()
    {
      int roll = ThreadLocalRandom.current().nextInt(1, 7); //simulate a dice roll
      System.out.println("\n\nA method that will simulate the results of rolling a single fair six sided dice");
      System.out.println("You rolled a " + roll + "!");
    }
  public static void twodiceRoll ()
    {
      int roll = ThreadLocalRandom.current().nextInt(1, 7); //simulate roll 1
     
      int roll2 = ThreadLocalRandom.current().nextInt(1, 7); //simulate dice roll 2
      int sum = roll + roll2;
      
      System.out.println("\n\nA method that will simulate the results of rolling two fair six sided dice");
      System.out.println("You rolled a " + roll + " and a " + roll2 + " for a total of " + sum + ".");
      
    }
  public static void printHeading ()
    {
      System.out.println();
      System.out.println("Ahmed's Video Wonderland");
      System.out.println("  123 Roehampton Avenue");
      System.out.println("     613-555-1212");
    }
  public static void printRoot ()
    {
      System.out.println("Please give a non-negative value");
      double x = input.nextDouble();
      
      if (x >= 0)
      {
       System.out.println("Square root is " + Math.sqrt(x)); 
      }
    }
  public static void Q1 ()
  {
    System.out.println();
    System.out.println("Question: What is the difference between a method definition and a method invocation?");
    System.out.println();
    System.out.println("The difference between method definition and method invocation is that method definition is the \ncode that makes up a specific method and a method invocation is a call to the output of a method in the main method.");  
  }
  public static void main(String []args)
    {
      printHeading();
      printHeading();
      printHeading();
      printRoot();
      printRoot();
    
      Q1();
      diceRoll();
      twodiceRoll();
      while (true)
      {
       System.out.println();
       System.out.println("Enter either 'printHeading', 'printRoot', 'Q1', 'diceRoll' or 'twodiceRoll' to repeat any methods or 'x' to end the program.");
       String method = input.next();
       
       if ( method.equals("printHeading"))
       {
        printHeading(); 
       }else if (method.equals("printRoot"))
       {
         printRoot();
       }else if (method.equals("Q1"))
       {
         Q1();
       }else if (method.equals("diceRoll"))
       {
        diceRoll(); 
       }else if (method.equals("twodiceRoll"))
       {
        twodiceRoll(); 
       }else if (method.equals("x"))
       {
        break; 
       }
       
      }
      
    }
  
}