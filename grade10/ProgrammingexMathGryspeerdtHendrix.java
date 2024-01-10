/* Date: dec 13, 2019
 * Assignment: Programming Exercises - Mathematical Functions
 * Name: Hendrix Gryspeerdt 
 */
 import java.util.*;
 import java.text.DecimalFormat;
 import java.util.concurrent.ThreadLocalRandom;
 class ProgrammingexMathGryspeerdtHendrix{
   public static void main(String []args){
     Scanner input = new Scanner(System.in);
     DecimalFormat df = new DecimalFormat("###,###.###");
     DecimalFormat df1 = new DecimalFormat("##############.###");
     
     System.out.println("Q1: a program that reads a time interval in hours, minutes, and seconds, and converts this measurement to hours only.");
     
     System.out.println("Now enter hours, then minutes, then seconds.");
     System.out.print("hours: ");
     double hrs = input.nextDouble();
     System.out.print("minutes: ");
     double min = input.nextDouble();
     System.out.print("seconds: ");
     double sec = input.nextDouble();
     
     double hours = hrs + (min/60.0000) + (sec/3600.0000);
     
     System.out.println(hrs + " hours, " + min + " minutes, " + sec + " seconds is " + df.format(hours) + " hours.");
     
     System.out.println("Q2: a program that reads an angle measurement in degrees and \nconverts it to a measurement using degrees, minutes, and seconds.");          
     
     System.out.println("\nNow input degrees:");
     double deg = input.nextDouble();
     min = (deg%1)*60;
     sec = (min%1)*60;
     min = min - (min%1);
     
     System.out.println(deg + " degrees is " + (deg - deg % 1) + " degrees, " + df.format(min) + " minutes, " + df.format(sec) + " seconds.");
     
     
     System.out.println("\nQ3: a program which asks for an angle in degrees and converts it to radians.");
     System.out.println("\n enter an angle in degrees:");
     deg = input.nextDouble();
     double rad = (deg/180.0000000000)*Math.PI;
       
     System.out.println(deg + " degrees is approximately " + rad + " radians.");
     
     System.out.println("Q4: A program which asks the user for values of A, B, and C from a quadratic equation, and then uses the \ngeneral quadratic formula to solve for the roots of the quadratic equation.");
    
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
     if (A == 0 && B != 0)
     {
      root1 =  ((C)*(-1))/B;
      System.out.println("Since you entered 0 for A, the expression " + df.format(B) + "x + " + df.format(C) + " is not a quadratic.\nAlthough it does intercept the x-axis at (" + df1.format(root1) + ",0).\n");
     }
     dis = Math.pow(B,2) - 4*A*C;
     if (dis < 0 || B == 0)
     {
      System.out.println("The quadratic " + df.format(A) + "x^2 + " + df.format(B) + "x + " + df.format(C) + " has no real roots.\n");
     }
    if (A != 0)
    {
     if (dis == 0)
     {
       root1 = ((B)*(-1))/(2*A);
       System.out.println(" The quadratic " + df.format(A) + "x^2 + " + df.format(B) + "x + " + df.format(C) + " has one root, (" + df1.format(root1) + ",0).\n");
     }
     if (dis > 0)
     {
      root1 = (((B)*(-1)) + Math.sqrt(dis))/(2*A);
      root2 = (((B)*(-1)) - Math.sqrt(dis))/(2*A);
      System.out.println(" The quadratic " + df.format(A) + "x^2 + " + df.format(B) + "x + " + df.format(C) + " has two roots, (" + df1.format(root1) + ",0) and (" + df1.format(root2) + ",0).\n");
     }
    }
    
    }
     
     
     
   }
 }