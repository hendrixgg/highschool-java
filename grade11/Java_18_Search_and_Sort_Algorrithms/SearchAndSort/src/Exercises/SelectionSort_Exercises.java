package Exercises;

import java.util.Arrays;
import java.util.Scanner;

import SortAlgs.SelectionSort;

public class SelectionSort_Exercises {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        do{
            System.out.print("\nEnter (1) (2) (3) (4) (5)|| (0) to quit: ");
            n = promptForNumber(input);
                System.out.println();
                switch (n) {
                    case 1 : exercise1(); break;
                    case 2 : exercise2(); break;
                    case 3 : exercise3(); break;
                }
                System.out.println();
            }while(n!=0);
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

    public static void exercise1() {
        System.out.println("1.  In the selectiion Sort method, what would happen if the he expression list[i] > list[largeLoc]");
        System.out.println("    were to be changed tolist[i] < list[largeLoc]?");
        System.out.println();
        // generate random array
        int[] array1 = new int[10];
        // populate array
        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int) (Math.random() * 100) + 1;// random number from 1-100
        }
        int[] array2 = new int[10];
        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];
        }
        System.out.println("Test array: " + Arrays.toString(array1));
        SelectionSort.Ascending(array1);
        System.out.println("Sorted with list[i] > list[largeLoc] : " + Arrays.toString(array1));
        System.out.println();
        System.out.println("Test array: " + Arrays.toString(array2));
        SelectionSort.Descending(array2);
        System.out.println("Sorted with tolist[i] < list[largeLoc] : " + Arrays.toString(array1));
    }

    public static void exercise2() {
        System.out.println("4.  Sometimes we are only interested in knowing the values that would occupy one end of the list if the");
        System.out.println("    list were sorted. For example, we may want to know the scores of only the top ten competitors in a ");
        System.out.println("    contest. Overload our selection sort method so that it puts the klargest values in order in the last");
        System.out.println("    k positions of the array.  The value of kshould be a parameter of the method.");
        System.out.println();

        // generate random array
        int[] array = new int[20];
        // populate array
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100) + 1;// random number from 1-100
        }
        int k = (int) (Math.random() * 6 + 5);// random number from 5-10
        
        System.out.println("Test Arraay: " + Arrays.toString(array));
        SelectionSort.kLargest(array, k);
        System.out.println("Sorted the top " + k + ": " + Arrays.toString(array));
    }

    public static void exercise3() {
        System.out.println("5.  Write a program that will sort(using selectionsort) 20random numberswith values between 1 and 70");
        System.out.println("    The program will graphically (with * asterisks) output to the screen the data as it is being sorted");
        System.out.println("    after each pass of the sort.You might have to add a delay between each pass so that the sort is slow");
        System.out.println("    enough to see. Use Thread.sleep(500)to create a delay of 500 milliseconds.");
        System.out.println();
        SelectionSort.graphicalExample();
    }
}
