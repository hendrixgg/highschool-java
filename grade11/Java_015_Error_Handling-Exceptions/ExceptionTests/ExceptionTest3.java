package ExceptionTests;
/*
 * ExceptionTest3.java
 * 
 *   A program that prompts the user for a sequence of numbers
 *   until a negative number is entered and then computes the 
 *   average.
 *   
 *   This version tests for valid user input by having the promptForNumber
 *   method throw InputMismatchExceptions to the main method to deal with.
 *   The main method then handles them with a try/catch block.
 * 
 * @author Jeremy Morris
 * 
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest3 {
    
    static Scanner keyboard;
    public static void main(String[] args) {
        keyboard = new Scanner(System.in);
        int value=0, count=0, total=0;
        while (value>=0) {
            try {
                value=promptForNumber();
                if (value>=0) {
                    count=count+1;
                    total=total+value;
                }
            }
            catch(InputMismatchException e) {
                System.out.println("ERROR!  Input not an integer!");
                keyboard.nextLine();
            }
            
        }
        System.out.println("Average: "+(total/count*1.0));
    }
    
    /**
     * promptForNumber
     *  
     * @param in a Scanner to read integer values from
     * @return an integer value read from the Scanner
     * @throws InputMismatchException when the user enters something that is not an integer
     */
    public static int promptForNumber() throws InputMismatchException {
        System.out.print("Enter an integer: ");
        int value = keyboard.nextInt();
        return value;
    }
    
}
