//Programming Exercise using Methods
//Hendrix Gryspeerdt
//Jan 14, 2020

import java.util.*;
import java.text.DecimalFormat;
class Methods_Exercise_Forthetest{
  public static Scanner input = new Scanner(System.in);
  public static DecimalFormat df = new DecimalFormat("###,###");
  public static DecimalFormat df1 = new DecimalFormat("##############.###");
  public static int choice;
  
  public static void main (String []args)
  {
    choice = 0;
    
    while (choice != 3)
     {
        choice = menu();
      if (choice == 1)
      {
          convert_days_to_hr_min_sec();
      
      }
      else if (choice == 2)
      {
          quadratic();
      
      }
    }
    
  }
  public static int menu()
  {
    System.out.println("---Main menu---");
    System.out.println("Choices: 1. Convert days into Hours, minutes and Seconds program");
    System.out.println("         2. Quadratic equation solution");
    System.out.println("         3. Quit");
    System.out.println();
    System.out.println("Choose 1, 2 or 3");
    choice = input.nextInt();
    
    return choice;
  }
  
  public static void convert_days_to_hr_min_sec()
  {
    System.out.println("\n\n\n#1. a java program that asks for number of days as a decimal and then converts this value into \nDays, Hours, Minutes, Seconds (round to the nearest second). The program keeps asking until the \nuser enters 0 at the prompt.");
    double userin = 0;
    do{
    System.out.println("Enter the amount of days, decimal values are accepted (enter 0 to go back to the menu):");
    userin = input.nextDouble();
    //System.out.println(Days);
    
    double days = userin - (userin%1);
    double hours = 24*(userin%1);
    double minutes = 60*(hours%1);
    double seconds = 60*(minutes%1);
    
    System.out.println("Answer: " + userin + " days is equal to " + df.format(days) + " days, " + df.format(hours) + " hour(s), " + df.format(minutes) + " minutes, " + df1.format(seconds) + " seconds.");
    } while (userin != 0);
  }
  
  public static void quadratic()
  {
    System.out.println("Q2: A program which asks the user for values of A, B, and C from a quadratic equation, and then uses the \ngeneral quadratic formula to solve for the roots of the quadratic equation.");
    
    double A; double B; double C; double dis;
    double root1; double root2;
    
    while (true)
    {
    A = 0; B = 0; C = 0;
    System.out.println("Enter A = 0, B = 0, C = 0 to quit");
    System.out.println("Enter the A value: ");
    A = input.nextDouble();
    
    System.out.println("Enter the B value: ");
    B = input.nextDouble();
    
    System.out.println("Enter the C value: ");
    C = input.nextDouble();
     if (A == 0 && B == 0 && C == 0)
     {
      break; 
     }
     if (A == 0)
     {
      root1 =  ((C)*(-1))/B;
      System.out.println("Since you entered 0 for A, the expression " + B + "x + " + C + " is not a quadratic.\nAlthough it does intercept the x-axis at (" + df1.format(root1) + ",0).\n");
     }
     dis = Math.pow(B,2) - 4*A*C;
    if (A != 0)
    {
     if (dis == 0)
     {
       root1 = ((B)*(-1))/(2*A);
       System.out.println(" The quadratic " + A + "x^2 + " + B + "x + " + C + " has one root, (" + df1.format(root1) + ",0).\n");
     }
     if (dis > 0)
     {
      root1 = (((B)*(-1)) + Math.sqrt(dis))/(2*A);
      root2 = (((B)*(-1)) - Math.sqrt(dis))/(2*A);
      System.out.println(" The quadratic " + A + "x^2 + " + B + "x + " + C + " has two roots, (" + df1.format(root1) + ",0) and (" + df1.format(root2) + ",0).\n");
     }
     if (dis < 0)
     {
      System.out.println("The quadratic " + A + "x^2 + " + B + "x + " + C + " has no real roots.\n");
     }
    }
  }
  }
 
  
  
  
  
  }