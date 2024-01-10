package ExceptionTests;
/*
 * ExceptionTest4.java
 * 
 *   A program that prompts the user for a sequence of numbers
 *   until a negative number is entered and then computes the 
 *   average.
 *   
 *   This version tests for valid user input by explicitly checking
 *   to ensure that the user has actually entered an integer.  This
 *   version avoids try/catch blocks entirely for checking input.
 * 
 * @author Jeremy Morris
 * 
 */

import java.util.Scanner;

public class ExceptionTest4 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        int value=promptForNumber(keyboard);
        int count=0;
        int total=0;
        while (value>=0) {
            count=count+1;
            total=total+value;
            value=promptForNumber(keyboard);
        }
        System.out.println("Average: "+(total/count*1.0));
    }
    
    /**
     * promptForNextInt
     *  
     * @param in a Scanner to read integer values from
     * @return an integer value read from the Scanner
     */
    public static int promptForNumber(Scanner in) {
        int value=0;
        boolean done=false;
        while (!done) {
            System.out.print("Enter an integer: ");
            if (in.hasNextInt()) { 
                value=in.nextInt(); 
                in.nextLine(); // Move to the next line
                done=true;
            }
            else {
                System.out.println("ERROR!  Input not an integer!");
                in.nextLine(); // clear input that is not an integer
            }
        }
        return value;
    }
    
}
