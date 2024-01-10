package Exceptions;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        double input = PromptForDouble(keyboard);
        try {
            System.out.println("The square root of " + input + " is " + M1(input));
        } catch (NegativeNumberException e) {
            System.out.println(e);
        }
    }

    public static double M1(double discrim) throws NegativeNumberException{
        if(discrim < 0)
            throw new NegativeNumberException();
        return Math.sqrt(discrim);
    }

    /**
     * promptForDouble
     *  
     * @param in a Scanner to read integer values from
     * @return an integer value read from the Scanner
     */
    public static double PromptForDouble(Scanner in) {
        double value=0;
        boolean done=false;
        while(!done) {
            System.out.print("Enter a positive number: ");
            if(in.hasNextDouble()) {
                value=in.nextDouble();
                in.nextLine(); // Move to the next line
                done=true;
            } else {
                System.out.println("ERROR!  Input not a decimal number");
                in.nextLine(); // clear input that is not a double
            }
        }
        return value;
    }
}