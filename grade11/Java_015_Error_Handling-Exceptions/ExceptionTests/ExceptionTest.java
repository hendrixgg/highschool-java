package ExceptionTests;
/*
 * ExceptionTest.java
 * 
 *   A program that prompts the user for a sequence of numbers
 *   until a negative number is entered and then computes the 
 *   average.
 *   
 *   This version does not include any checking to see if the user
 *   is actually entering integer values when prompted.
 * 
 * @author Jeremy Morris
 * 
 */

import java.util.Scanner;

public class ExceptionTest {
    
    
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
        System.out.print("Enter an integer: ");
        int value = keyboard.nextInt();
        return value;
    }
    
}
