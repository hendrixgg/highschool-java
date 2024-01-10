import java.util.Scanner;
class Input {
    public static void main(String[] args) {
     
     Scanner input = new Scanner(System.in);
     
     // Getting float input
     System.out.print("Enter float: ");
     float myFloat = input.nextFloat();
     System.out.println("Float entered = " + myFloat);
     
     // Getting double input
     System.out.print("Enter double: ");
     double myDouble = input.nextDouble();
     System.out.println("Double entered = " + myDouble);
     
     // Getting String input
     System.out.print("Enter text: ");
     String myString = input.next();
     System.out.println("Text entered = " + myString);
     
     
     
 
        Scanner in = new Scanner(System.in);
        System.out.print("Input seconds: ");
  int seconds = in.nextInt(); 
        int p1 = seconds % 60;
        int p2 = seconds / 60;
        int p3 = p2 % 60;
        p2 = p2 / 60;
        System.out.print( p2 + ":" + p3 + ":" + p1);
  System.out.print("\n");
    }    
 }
