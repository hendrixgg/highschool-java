package ExceptionTests;
/*
 * ExceptionTest.java
 * 
 *   A program that prompts the user for a sequence of numbers
 *   until a negative number is entered and then computes the 
 *   average.
 *   
 *   This version tests for valid user input by using a try/catch
 *   block to catch an InputMismatchException in the promptForNumber
 *   method.
 * 
 * @author Jeremy Morris
 * 
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest2 {
    
    static Scanner keyboard;
    public static void main(String[] args) {
        keyboard = new Scanner(System.in);
        
        int value=promptForNumber();
        int count=0;
        int total=0;
        while (value>=0) {
            count=count+1;
            total=total+value;
            value=promptForNumber();
        }
        System.out.println("Average: "+(total/count*1.0));
    }
    
    /**
     * promptForNumber
     *  
     * @param in a Scanner to read integer values from
     * @return an integer value read from the Scanner
     */
    public static int promptForNumber() {
        int value=0;
        boolean done=false;
        while (!done) {
            try {
                System.out.print("Enter an integer: ");
                value = keyboard.nextInt();
                done=true;
            }
            catch(InputMismatchException e) {
                System.out.println("ERROR!  Input not an integer!");
                keyboard.nextLine(); // clear input 
            }
        }
        return value;
    }
    
}
