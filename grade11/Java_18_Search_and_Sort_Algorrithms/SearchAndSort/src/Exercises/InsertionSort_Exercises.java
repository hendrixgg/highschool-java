package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort_Exercises {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        do{
            System.out.print("\nEnter (1) || (0) to quit: ");
            n = promptForNumber(input);
                System.out.println();
                switch (n) {
                    case 1 : exercise1(); break;
                }
                System.out.println();
            }while(n!=0);
    }

    private static void exercise1() {
        System.out.println("1.  Use insertion sort to put the values 6, 2, 8, 3, 1, 7, 4 in");
        System.out.println("    ascending (lowest to highest) order.");
        System.out.println();
        // generate random array
        int[] array = new int[20];
        // populate array
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100) + 1;// random number from 1-100
        }
        System.out.println("this is the array" + Arrays.toString(array));
        Sortascending(array);
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

    public static void Sortascending(int[] list) {
        int curr, temp;

        // start from the second item in the array
        for (int front = 1; front < list.length; front++) {
            // copy the unsorted item to a temporary location
            temp = list[front];
            curr = front;
            // shift items to the right if temp item is smaller
            // than previous item
            while (curr > 0 && list[curr - 1] > temp) {
                    list[curr] = list[curr - 1];
                    curr--;
            }
            list[curr] = temp;
            System.out.printf("pass %2d: %s%n", front, Arrays.toString(list));
        }
    }
    
}
