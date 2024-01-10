/* Date: nov 18, 2019
 * Assignment: A0 Mini - Number Guessing Game
 * Name: Hendrix Gryspeerdt 
 * 
 * Program description:
 * 
 * You are to create a program where the computer randomly selects a number between 1
   to 1000. The user gets 10 chances to guess what the number is. After each guess, the
   computer displays the message "Higher" or "Lower" to guide the user to a better guess.

   If the user guesses the number correctly within the 10 guesses, display "You Win".
   Otherwise display "You Lose". After the game is over, allow for an opportunity to play
   again with a new random number generated.
*/

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class A3MajorGryspeerdtHendrix {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int min = 1; // minimum random number
      int max = 1000; // maximum random number
      int RandomNum; // declares the random number
      int x = 0; // declares the user input (guess)
      String end; // declares the variable that stores the user's choice to play again or not
      int turns = 0; // a variable that counts which turn the user is on
      int i; // declaration of variable to be used in a loop
      int a[] = new int[10]; // declaration of the array that stores the previous tries
      int temp; // a variable that stores temporary user input

      System.out.println("____Number Guessing Game____" + "\n" + "Created by: Hendrix Gryspeerdt");

      System.out.println(
            "\nInstructions: The computer randomly picks a number from 1 to 1000 and you have 10 tries to guess it. \n              If your number is out of this range your turn will be wasted.\n");

       // game starts here
      do {
         temp = 0; // resets the temporary user input to 0
         end = ""; // resets the user's choice to play again
         turns = 0; // resets the turn count

         RandomNum = ThreadLocalRandom.current().nextInt(min, max + 1); // number randomizer

         System.out.println("Number Guessing Game -- START");

         for (int k = 10; k > 0; --k) {// the loop that takes the user's 10 guesses and ends if the number is guessed
                                      // in less than 10 tries
            System.out.println("\n------------------------------------------\n");
            if (k == 10) {
               System.out.println("Guess the number, you have " + k + " tries. "); // asking the user to guess a number
                                                                                   // on their first guess
               x = input.nextInt(); // taking user input

               if (x <= 1000 && x >= 1) {
                  temp = x; // assigning the user input to temp if input was valid
               }

               if (x <= 1000 && x >= 1) {
                  a[turns] = x; // storing user input into array only if in valid range
               } else {
                  System.out.print("input out of range");
               }
            }

            if (k == 1) {
               System.out.print("Guess the number, you have " + k + " try remaining. "); // asking the user to guess a
                                                                                         // number when they have only 1
                                                                                         // try left
               System.out.print("Previous guesses are : ");
               for (i = 0; i < turns; i++) {
                  System.out.print(a[i] + "  "); // printing previous guesses
               }
               if (temp > RandomNum && temp < 1000) {
                  System.out.println("  And try lower"); // tells the user to guess a lower number
               }
               if (temp < RandomNum && temp > 0) {
                  System.out.println("  And try higher"); // tells the user to guess a higher number
               }
               x = input.nextInt(); // taking user input

               if (x <= 1000 && x >= 1) {
                  temp = x; // assigning the user input to temp if input was valid
               }

               if (x < 1 || x > 1000) {
                  System.out.println("Input out of range");
               }
            }

            if (k > 1 && k != 10) {
               System.out.print("Guess the number, you have " + k + " tries remaining. "); // asking the user to guess a
                                                                                           // number when they have more
                                                                                           // than 1 try left but not
                                                                                           // their first try
               System.out.print("Previous guesses : ");
               for (i = 0; i < turns; i++) {
                  System.out.print(a[i] + "  "); // printing previous guesses
               }
               if (temp > RandomNum && temp < 1000) // tells the user to guess a higher number
               {
                  System.out.println("  And try lower");
               }
               if (temp < RandomNum && temp > 0) // tells the user to guess a lower number
               {
                  System.out.println("  And try higher");
               }
               x = input.nextInt(); // taking user input

               if (x <= 1000 && x >= 1) {
                  temp = x; // assigning the user input to temp if input was valid
               }

               if (x <= 1000 && x >= 1) {
                  a[turns] = x; // storing user input into array only if in valid range
               } else {
                  System.out.print("input out of range");
               }
            }

            if (x == RandomNum) {
               k = 0;
               System.out.println("\nGreat You Guessed it!");
            }
            if (x <= 1000 && x >= 1) // increments the number of turns by one if the user input was valid
            {
               turns++;
            }
         }
         
         for (i = 0; i < turns; i++) {
            a[i] = 0;
         }

         if (x != RandomNum) {
            System.out.println("\n YOU LOSE! You didn't guess the number, it was " + RandomNum);
         }

         while (!(end.equals("y") || end.equals("n") || end.equals("Y") || end.equals("N"))) {
            System.out.println("\nWould you like to play again? y(yes), n(no)");
            end = input.next();
         }
      } while(!end.equals("n") && !end.equals("N"));
      for (i = 0; i < 100; i++) {
         System.out.print("\n");
      }
      System.out.println("RANDOM NUMBER GAME -- END");
   }
}