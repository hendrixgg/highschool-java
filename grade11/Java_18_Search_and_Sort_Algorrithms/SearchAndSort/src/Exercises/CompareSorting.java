package Exercises;

import java.util.Arrays;
import java.util.Scanner;
import SortAlgs.*;

public class CompareSorting {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        int[] gaps = new int[10];
        do {
            System.out.print("\nEnter (1) (2) (3) (4) (5) (6)|| (0) to quit: ");
            n = promptForNumber(input);
            System.out.println();
            switch (n) {
                case 1:
                    System.out.println("Shell sort 1:");
                    shellSort1();
                    break;
                case 2:
                    System.out.println("Gap sequence for shell sort 1");
                    // creates the gap pattern 1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524
                    gaps = new int[10];
                    gaps[0] = 1;
                    for (int i = 1; i < 10; i++) {
                        gaps[i] = 3 * gaps[i - 1] + 1;
                    }
                    for (int i = 0; i < gaps.length; i++) {
                        System.out.printf("gap # %2d: %,d%n", i + 1, gaps[i]);
                    }
                    break;
                case 3:
                    System.out.println("Shell sort 2 (best):");
                    shellSortBest();
                    break;
                case 4:
                    System.out.println("Gap sequence for shell sort 2");
                    gaps = new int[15];
                    // creates the gap pattern 1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905...
                    gaps[0] = 1;
                    for (int i = 1; i < gaps.length; i++) {
                        if ((i) % 2 == 0) {
                            gaps[i] = (int) (9 * (Math.pow(2, i) - Math.pow(2, (i) / 2)) + 1);
                        } else {
                            gaps[i] = (int) (8 * Math.pow(2, i) - 6 * Math.pow(2, (i + 1) / 2) + 1);
                        }
                    }
                    for (int i = 0; i < gaps.length; i++) {
                        System.out.printf("gap # %2d: %,d%n", i + 1, gaps[i]);
                    }
                    break;
                case 5:
                    System.out.println("Quickort");
                    quickort();
                    break;
                case 6:
                    System.out.println("Java Arrays.sort"); // this is the fastest way to sort an array
                    regularSort();
                    break;


            }
            System.out.println();
        } while (n != 0);
    }

    /**
     * promptForNumber - int
     * 
     * @param in a Scanner to read integer values from
     * @return an integer value read from the Scanner
     */
    public static int promptForNumber(Scanner in) {
        int value = 0;
        boolean done = false;
        while (!done) {
            if (in.hasNextInt()) {
                value = in.nextInt();
                in.nextLine(); // Move to the next line
                done = true;
            } else {
                System.out.println("ERROR!  Input not an integer!");
                in.nextLine(); // clear input that is not an integer
                System.out.print("Enter an integer: ");
            }
        }
        return value;
    }

    public static void shellSort1() {
        long startTime, endTime, durationInMillis;
        long sum = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {

            int[] arr = generateRandomArr(1000, 0, 10000);

            ShellSort.ascending(arr);
            endTime = System.currentTimeMillis();

            durationInMillis = (endTime - startTime); // Total execution time in milli seconds
            sum = sum + durationInMillis;
            startTime = System.currentTimeMillis();
        }
        System.out.println("The average for 1000 runs of sorting arrays of length 1000 is " + sum / 1000.0);
    }

    public static void shellSortBest() {
        long startTime, endTime, durationInMillis;
        long sum = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {

            int[] arr = generateRandomArr(1000, 0, 10000);

            ShellSort.ascendingBest(arr);
            endTime = System.currentTimeMillis();

            durationInMillis = (endTime - startTime); // Total execution time in milli seconds
            sum = sum + durationInMillis;
            startTime = System.currentTimeMillis();
        }
        System.out.println("The average for 1000 runs of sorting arrays of length 1000 is " + sum / 1000.00);
    }

    public static void quickort() {
        long startTime, endTime, durationInMillis;
        long sum = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {

            int[] arr = generateRandomArr(1000, 0, 10000);

            Quicksort.quicksortAscending(arr, 0, arr.length - 1);
            endTime = System.currentTimeMillis();

            durationInMillis = (endTime - startTime); // Total execution time in milli seconds
            sum = sum + durationInMillis;
            startTime = System.currentTimeMillis();
        }
        System.out.println("The average for 1000 runs of sorting arrays of length 1000 is " + sum / 1000.00);
    }

    public static void regularSort() {
        long startTime, endTime, durationInMillis;
        long sum = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {

            int[] arr = generateRandomArr(1000, 0, 10000);

            Arrays.sort(arr);
            endTime = System.currentTimeMillis();

            durationInMillis = (endTime - startTime); // Total execution time in milli seconds
            sum = sum + durationInMillis;
            startTime = System.currentTimeMillis();
        }
        System.out.println("The average for 1000 runs of sorting arrays of length 1000 is " + sum / 1000.00);
    }

    public static int[] generateRandomArr(int length, int min, int max) {
        int[] result = new int[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (Math.random() * (max - min + 1)) + min;
        }
        return result;
    }
}