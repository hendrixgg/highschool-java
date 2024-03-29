
import java.util.*;
import java.text.DecimalFormat;
class QuadraticpracticeGryspeerdtHendrix{
  public static void main(String args[]){
    Scanner input = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("###,###");
    DecimalFormat df1 = new DecimalFormat("##############.###");
    
    System.out.println("Q1: a java program that asks for number of days as a decimal and then converts this value into \nDays, Hours, Minutes, Seconds (round to the nearest second). The program keeps asking until the \nuser enters 0 at the prompt.");
    double userin = 0;
    do{
    System.out.println("Enter the amount of days, decimal values are accepted (enter 0 to quit):");
    userin = input.nextDouble();
    //System.out.println(Days);
    
    double days = userin - (userin%1);
    double hours = 24r*(userin%1);
    double minutes = 60*(hours%1);
    double seconds = 60*(minutes%1);
    
    System.out.println("Answer: " + userin + " days is equal to " + df.format(days) + " days, " + df.format(hours) + " hour(s), " + df.format(minutes) + " minutes, " + df1.format(seconds) + " seconds.\n\n");
    } while (userin != 0);
    
    
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