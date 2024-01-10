import java.util.Scanner;
class Input1{
  public static void main(String[] args){
    // Write a program that asks the user to input three integers and outputs a message displaying the sum and whether it is positive, negative, or zero.
    int value;
    Scanner keyboard = new Scanner(System.in);
      
    System.out.println( "Input three integers ") ;
    value = keyboard.nextInt();
    
    if (value == 2)
    {
         System.out.println("You selected the number " + value + " which is even");
    }
    
  }}