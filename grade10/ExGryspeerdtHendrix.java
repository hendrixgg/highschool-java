//Exercise Java
//Oct 28th 2019
//Repetition using Java – Loops
import java.util.Scanner;
class ExGryspeerdtHendrix{
  public static void main(String args[]){
    Scanner input = new Scanner(System.in);
    
 System.out.println("Exercises\n");
   
   System.out.println("1. The minimum number of times the body of a while statement can be executed is one time.\n");
   System.out.println("2. The maximum number of times the body of a while statement can be executed is infintie as long as it can be cancelled.\n");
   System.out.println("3. This would be printed as: 10 0"+"\n"
                     +"                              9 2"+"\n"
                     +"                              8 4"+"\n"
                     +"                              7 6"+"\n"
                     +"                              6 8"+"\n");
   System.out.println("4. A program that asks the user for a sentinel value. Then ask for integer values until they input"+"\n"
                     +"   something greater than the sentinel value.");
    
    System.out.print("Enter an integer value:");
    int value = input.nextInt();
    int x = value - 1;
    System.out.println("\n");
    while (x <= value)
    {
      System.out.print("Enter another integer value (a value greater than the initial value ends the loop):");
      x = input.nextInt(); System.out.println("\n");
    }
    
    System.out.println("\n");                     
  System.out.println("5. a program that calculates the sum of N positive integers");
    System.out.println("Input and integer:");
    int n = input.nextInt();
    int e = 0;
    int j = 0;
    while (e <= n)
    {
      j += e;
      e++;
    }
    System.out.println("The sum of the first "+ n +" integers is "+ j +"\n");
    
    System.out.println("6. A progrm that calculates the square root of a number input by the user");
    double num = 0;
    double ans = 0;
    while (num >= 0)
    {
     System.out.println("input a number (a negative to quit):");
     num = input.nextDouble();
     ans = Math.sqrt(num);
     if (num >=0){System.out.println("the square root of "+ num +" is "+ ans);}
    }
    System.out.println("\n");
    System.out.println("7. a program that prompts the user for a sequence of integers using zero as a sentinel and counts the number of times that consecutive values are equal.");
    int sentinel = 0;
    double z = 1.1;
    int y;
    int count = 0;
    while (z != sentinel)
    {
    System.out.println("enter an integer (0 to quit):");
    y = input.nextInt();
    if (y == z){count++;}
    z = y;
    }  
    System.out.println("There are "+ count +" case(s) of consecutive equal values");
      
  }
}