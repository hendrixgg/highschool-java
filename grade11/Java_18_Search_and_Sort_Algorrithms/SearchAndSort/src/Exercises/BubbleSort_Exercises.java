package Exercises;

import java.util.Arrays;
import java.util.Scanner;

import SortAlgs.*;


public class BubbleSort_Exercises {
    
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        int n = 1;
        do{
            System.out.print("\nenter (1) (2) (3) (4) | (0) to quit: ");
            n = keyboard.nextInt();
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

    private static void exercise1() {
        System.out.println("1.  What changes would have to be made to the bubbleSort method"); 
        System.out.println("    in order to make it sort values indescending order?");
        System.out.println();
        System.out.println("Testing the written code with an array of random numbers:");

        //generate random array
        int[] array = new int[20];
        //populate array
        for (int i=0; i<array.length; i++) {
            array[i] = (int)(Math.random()*151) + 100;//random number from 100-250
        }

        System.out.println("This is a randomly generated array: " + Arrays.toString(array));
        System.out.println();
        BubbleSort.SortDescending(array);
        System.out.println("Sorted in descending order: " + Arrays.toString(array));
    }

    private static void exercise2() {
        System.out.println("2.  Write a program to input the height (in cm) for 8 people. The");
        System.out.println("    program then calculates and outputs the average height for the");
        System.out.println("    group followed by all of the heights from highest to lowest order.");
        System.out.println();

        double[] heights = new double[8];
        double total = 0;
        int i = 0;
        while (i<heights.length) {
            System.out.print("Enter a height in cm: ");
            if (keyboard.hasNextDouble()) {
                heights[i] = keyboard.nextDouble();
                total+=heights[i];
                i++;
            }
            keyboard.nextLine();
        }
        double average = total/8.00;
        System.out.println();
        System.out.println("The average height was " + average + " cm");
        BubbleSort.SortDescending(heights);
        System.out.println(Arrays.toString(heights));

    }

    private static void exercise3() {
        System.out.println("3.  Write a program that inputs 20 words from the keyboard. The ");
        System.out.println("    program will then sort the words and print them out in ascending");
        System.out.println("    order. To compare words, you can use the compareTo() method.");
        System.out.println();

        String[] words = new String[20];
        System.out.println("Enter 20 words: ");
        for (int i=0; i<words.length; i++) {
            words[i] = keyboard.next();
        }
        System.out.println("The 20 words as entered :            " + Arrays.toString(words));
        BubbleSort.SortAscending(words);
        System.out.println("The 20 words sorted alphabetically : " + Arrays.toString(words));

    }

    private static void exercise4() {
        System.out.println("3.  Write a program that generates 10 UNIQUE(no duplicates) random");
        System.out.println("    numbers between1 and 20 and stores them in an array. The program");
        System.out.println("    then sorts the numbers and displays them in ascending order.");
        System.out.println();

        int[] numbers = new int[10];
        boolean[] num = new boolean[20];
        int rand;
        boolean done;

        //adds a new unique number to the numbers array
        for (int i=0; i<numbers.length; i++) {
            done = false;
            rand = (int)(Math.random()*20 + 1);
            while(!done) {
                //if the specific number has already been inserted then increment by 1 and check again
                //if greater than 20, take the mod 20 of rand
                if(num[(rand)%20] == false) {
                    numbers[i] = (rand)%20;//increase by 1 because we want 1-20 not 0-19
                    num[(rand)%20] = true;
                    done = true;
                }
                rand++;//increment rand because the value was previously inserted
            }
        }

        System.out.println("The array unsorted: " + Arrays.toString(numbers));
        BubbleSort.SortAscending(numbers);
        System.out.println("The array sorted: " + Arrays.toString(numbers));
        System.out.println();
    }

}
