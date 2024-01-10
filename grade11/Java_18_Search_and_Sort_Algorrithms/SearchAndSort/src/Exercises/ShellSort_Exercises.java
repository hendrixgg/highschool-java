package Exercises;

import java.util.Scanner;

public class ShellSort_Exercises {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int n;
        do{
            System.out.print("\nEnter (1) (2) (3) (4) (5)|| (0) to quit: ");
            n = promptForNumber(input);
                System.out.println();
                switch (n) {
                    case 1 : exercise1(); break;
                    // case 2 : exercise2(); break;
                    // case 3 : exercise3(); break;
                }
                System.out.println();
            }while(n!=0);
    }

    private static void exercise1() {
    }

    /**
     * promptForNumber - int
     * 
     * @param in a Scanner to read integer values from
     * @return an integer value read from the Scanner
     */
    public static int promptForNumber(Scanner in) {
        int value=0;
        boolean done=false;
        while (!done) {
            if (in.hasNextInt()) { 
                value=in.nextInt(); 
                in.nextLine(); // Move to the next line
                done=true;
            }
            else {
                System.out.println("ERROR!  Input not an integer!");
                in.nextLine(); // clear input that is not an integer
                System.out.print("Enter an integer: ");
            }
        }
        return value;
    }

    public static int[] generateArr (int length, int min, int max)
  {
    int[] result = new int[length];
    for (int i = 0; i < result.length; i++) 
    {
      result[i] = (int)(Math.random()*(max - min + 1))+ min;      
    }
    return result;
  }
}
