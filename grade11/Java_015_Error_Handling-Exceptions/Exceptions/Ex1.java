package Exceptions;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        try {
            int Age = PromptForAge(keyboard);
            if(Age > 25)
            throw new AgeOutOfRangeException();

            try {
                double Gpa = PromptForGpa(keyboard);
                if(Gpa < 2.5)
                throw new LowGpaException();

                System.out.println("Your application is accepted and is under study.");
            } catch (Exception e) {
                //do nothing
            }
        } catch (AgeOutOfRangeException e) {
            //do nothing
        }
    }    

    /**
     * promptForGpa
     *  
     * @param in a Scanner to read integer values from
     * @return an double value read from the Scanner
     */
    public static double PromptForGpa(Scanner in) {
        double Gpa=0;
        boolean done=false;
        while(!done) {
            System.out.print("Enter your GPA: ");
            if(in.hasNextDouble()) {
                Gpa=in.nextDouble();
                in.nextLine(); // Move to the next line
                done=true;
            } else {
                System.out.println("ERROR!  Input not a decimal number");
                in.nextLine(); // clear input that is not a double
            }
        }
        return Gpa;
    }

    /**
     * promptForAge
     *  
     * @param in a Scanner to read integer values from
     * @return an integer value read from the Scanner
     */
    public static int PromptForAge(Scanner in) {
        int Age=0;
        boolean done=false;
        while(!done) {
            System.out.print("Enter your age: ");
            if(in.hasNextInt()) {
                Age=in.nextInt();
                in.nextLine(); // Move to the next line
                done=true;
            } else {
                System.out.println("ERROR!  Input not an integer number");
                in.nextLine(); //clear input that is not an int
            }
        }
        return Age;
    }
}