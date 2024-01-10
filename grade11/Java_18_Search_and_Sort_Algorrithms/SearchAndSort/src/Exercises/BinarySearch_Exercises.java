package Exercises;

import java.util.Arrays;
import java.util.Scanner;
import SeachAlgs.*;
import SortAlgs.*;

public class BinarySearch_Exercises {

    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        int n;
        do{
            System.out.print("\nEnter (1) (2) (3) (4) || (0) to quit: ");
            n = promptForNumber(keyboard);
                System.out.println();
                switch (n) {
                    case 1 : exercise1(); break;
                    case 2 : exercise2(); break;
                    case 3 : exercise3(); break;
                    case 4 : exercise4(); break;
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

    private static void exercise1() {
        System.out.println("1. Suppose that an array contains the following elements.");
        System.out.println("   [23, 27, 30, 34, 41, 49, 51, 55, 57, 60, 67, 72, 78, 83, 96]");
        System.out.println();
        System.out.println("   Trace the execution of the method binSearch shown in this");
        System.out.println("   section as it searches for the following values of item.");
        System.out.println("   In each trace, show the progress of the search ");
        System.out.println();
        System.out.println("Search for:       (a)72       (b)41       (c)62 ");
        System.out.println();

        int[] array = { 23, 27, 30, 34, 41, 49, 51, 55, 57, 60, 67, 72, 78, 83, 96 };

        System.out.println();
        int locationA = BinarySearch.search(array, 72);
        System.out.println("(a)72 was found at index " + locationA);

        System.out.println();
        int locationB = BinarySearch.search(array, 41);
        System.out.println("(b)41 was found at index " + locationB);

        System.out.println();
        int locationC = BinarySearch.search(array, 62);
        System.out.println("(c)62 was found at index " + locationC);

    }

    private static void exercise2() {
        System.out.println("2.  What changes would have to be made to binarySearch so that");
        System.out.println("    it will search an array in descending order?");
        System.out.println();
        System.out.println("Answer: enable the method to check if the first element is greater");
        System.out.println("        or less than the last element and then run the appropriate");
        System.out.println("        algorithim.");
        System.out.println();

        // generate random array
        int[] array = new int[20];
        // populate array
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100) + 1;// random number from 1-100
        }
        int rand = array[(int) (Math.random() * 20)];
        BubbleSort.SortAscending(array);
        System.out.println("Here is an array sorted in ascending order: ");
        System.out.println(Arrays.toString(array));
        System.out
                .println("\nNow search for " + rand + " ... it was found at index " + BinarySearch.search(array, rand));
        
        // populate array again
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100) + 1;// random number from 1-100
        }
        rand = array[(int) (Math.random() * 20)];
        BubbleSort.SortDescending(array);
        System.out.println("Here is an array sorted in descending order: ");
        System.out.println(Arrays.toString(array));
        System.out
                .println("\nNow search for " + rand + " ... it was found at index " + BinarySearch.search(array, rand));

    }

    private static void exercise3() {
        System.out.println("3.  Rewrite binSearch so that, if a search is unsuccessful,");
        System.out.println("    the method will return the index of the value nearest to");
        System.out.println("    item, instead of returning -1. If there is a tie, return");
        System.out.println("    the smaller index.");
        System.out.println();

        // generate random array
        int[] numbers = new int[10];
        boolean[] num = new boolean[100];
        boolean done = false;
        int rand=0;
        // populate array
        for (int i=0; i<numbers.length; i++) {
            rand = (int)(Math.random()*100 - 50);
            while(true) {
                //if the specific number has already been inserted then increment by 1 and check again
                //if greater than 99, take the mod 100 of rand
                if(num[rand%100 + 50] == false) {
                    numbers[i] = (rand)%100;
                    num[rand%100 + 50] = true;
                    break;
                }
                rand++;//increment rand because the value was previously inserted
            }
        }
        rand = (int)(Math.random()*100 - 50);//getting a number that is not in the array
        while(!done) {
            if(num[rand%100 + 50] == false) {
                break;
            }
            if(rand < 0) rand--; else rand++;
        }
        BubbleSort.SortAscending(numbers);
        System.out.println("Here is an array sorted in ascending order: ");
        System.out.println(Arrays.toString(numbers));
        System.out
                .println("\nNow search for " + rand + " ... the value closest was found at index " + BinarySearch.searchNearest(numbers, rand));
        
    }

    private static void exercise4() {
        System.out.println("4.  What is the maximum number of comparisons that might be");
        System.out.println("    necessary to perform a binary search on a list containing");
        System.out.println("    the following numbers of elements?");
        System.out.println();
        System.out.println("    (a) 7       (b) 3       (c) 15");
        System.out.println("    (d) 1000    (e) 10000   (f) 31 ");
        System.out.println("    (g) 63      (h) 100     (i) 500");
        System.out.println();

        int[] nums = {7, 3, 15, 1000, 10000, 31, 63, 100, 500};
        String[] letters = {"(a)", "(b)", "(c)", "(d)", "(e)", "(f)", "(g)", "(h)", "(i)"};

        for(int i = 0; i<nums.length; i++) {
            int comps = (int)Math.ceil(Math.log(nums[i])/Math.log(2));
            System.out.printf("%3s %-5d %s %-2d %s%n",letters[i], nums[i], ":", comps, " comparisons.");
        }
    }
}
