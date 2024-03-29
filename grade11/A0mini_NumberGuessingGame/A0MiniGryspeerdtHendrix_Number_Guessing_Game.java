/* Date: sept 17, 2020
 * Assignment: A0 Mini - Number Guessing Game
 * Name: Hendrix Gryspeerdt 
 * 
 * Program description:
 * 
 * You are to create a program where the computer randomly selects a number between 1
   to 1000. The user gets 10 chances to guess what the number is. After each guess, the
   computer displays the message �Higher� or �Lower� to guide the user to a better guess.

   If the user guesses the number correctly within the 10 guesses, display �You Win�.
   Otherwise display �You Lose�. After the game is over, allow for an opportunity to play
   again with a new random number generated.
*/


import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
class A0MiniGryspeerdtHendrix{
  
  public static boolean NumericString(String string){ //method to tell you if a string is composed of digits
    if(string == null || string.length() == 0){
      return false; 
    }
    boolean negative = false;//boolean to know if there was a negative sign
    for (int i = 0; i < string.length(); i++){
      if(string.charAt(i) >= '0' && string.charAt(i) <= '9'){//checks if character is a digit
       //do nothing 
      }else if(string.charAt(i) == '-' && negative == false){//checks if character is a negative sign
          negative = true;
        }else{
          return false;
        }
        negative = true;
    }
    return true;
  }
  
  public static void main(String []args){
    Scanner input = new Scanner(System.in);
    int min = 1; //minimum random number
    int max = 1000; //maximum random number +1
    int RandomNum; //declares the random number
    String guessString; //user input variable
    int guessInt; // variable to store user input if valid
    String end; // declares the variable that stores the user's choice to play again or not
    int turns = 0; //a variable that counts which turn the user is on
    String a[]=new String[10]; // declaration of the array that stores the previous guesses
    int i; // declaration of variable to be used in a loop
    boolean inputvalid; //a vartiable that keeps track of the validity of the user input
    
    
    
    System.out.println("____Number Guessing Game____"+"\n" //title
                      +"Created by: Hendrix Gryspeerdt");
    
    System.out.println("\nInstructions: "
                         + "\n                 The computer randomly picks an integer from 1 to 1000 and you have 10 tries to guess it. "
                         + "\nAfter each valid guess the game will display 'Higher' or 'Lower' meaning the random number is higher or lower than your guess."
                         + "\n                     If your input is out of this range or not an integer your turn will be wasted.\n"
                         + "\n                                  ------Entering 'Q' will quit the game------");
    
    // game starts here
    while (true){ 
      
      guessInt = 0; // variable to store user input if valid
      guessString = ""; //user input variable
      end = ""; // resets the user's choice to play again
      turns = 0; // resets the turn count
      for (i = 0; i < 9; i++)//assigning "_" to each index of the previous guess array
      {
        a[i] = "_"; 
      }
      
      RandomNum = ThreadLocalRandom.current().nextInt(min, max + 1); //number randomizer
      //could also do this: = (int)Math.random()*(max+1 - min+1) + min
      
      
      System.out.println("Number Guessing Game -- START");
      
      for( int k = 10; k > 0; --k){ // the loop that takes the user's 10 guesses and ends after 10 guesses or if the player guesses the number
        
        inputvalid = true;//assumes valid input for next guess

        
        System.out.println("\n------------------------------------------\n");//divider for each turn
        if (k == 10){
          System.out.print("Guess the number, you have "+ k +" guesses. "); // asking the user to guess a number on their first guess
          guessString = input.nextLine(); // taking user input 
          
          if (guessString.equals("Q") || guessString.equals("q")){//Ending the loop if the player inputs Q or q
           break; 
          }
          try{
            guessInt = Integer.parseInt(guessString);//trys to convert the player's guess to and Int
          }
          catch (Exception e){//if user did not input a string convertible to Int the appropriate error message is displayed
            inputvalid = false;
            if (NumericString(guessString) == true){//checks if input was a number that could not be converted to Int
              System.out.println("Input out of range");
            }else {
              System.out.println("Invalid input");
            }
          }
          if (inputvalid){
            if (guessInt > 1000 || guessInt < 1){
              System.out.println("Input out of range");//displays error message if the input was convertible to Int but out of the range
              inputvalid = false;
            }
          }
            if(guessInt != RandomNum && inputvalid){
              guessString = Integer.toString(guessInt);//removes additional zeros in front of guess
              a[turns] = guessString; // storing user input into array only if input was valid
              if (guessInt > RandomNum){
                System.out.println("Lower");//tells the player to guess Lower
              }
              if (guessInt < RandomNum){
                System.out.println("Higher");//tells the player to guess higher
              }
            }
        }
        
        
        if (k > 1 && k != 10){
          System.out.print( k +" guesses remaining. "); // asking the user to guess a number when they have more than 1 try left but not their first try
          System.out.print("Previous guesses : ");
          for(i=0; i<turns; i++){
            System.out.print(a[i] + "  "); // printing previous guesses 
          }
          guessString = input.nextLine(); // taking user input
          
          if (guessString.equals("Q") || guessString.equals("q")){//Ending the loop if the player inputs Q or q.
           break; 
          }
          try{
            guessInt = Integer.parseInt(guessString);//trys to convert the player's guess to and Int
          }
          catch (Exception e){//if user did not input a string convertible to Int the appropriate error message is displayed
            inputvalid = false;
            if (NumericString(guessString) == true){//checks if input was a number that could not be converted to Int
              System.out.println("Input out of range");
            }else {
              System.out.println("Invalid input");
            }
          }
          if (inputvalid){
            if (guessInt > 1000 || guessInt < 1){
              System.out.println("Input out of range");//displays error message if the input was convertible to Int but out of the range
              inputvalid = false;
            }
          }
            if(guessInt != RandomNum && inputvalid){
              guessString = Integer.toString(guessInt);//removes additional zeros in front of guess
              a[turns] = guessString; // storing user input into array only if input was valid
              if (guessInt > RandomNum){
                System.out.println("Lower");//tells the player to guess Lower
              }
              if (guessInt < RandomNum){
                System.out.println("Higher");//tells the player to guess higher
              }
            }
        }
        
        if (k == 1){
          System.out.print(k +" guess remaining. "); // asking the user to guess a number on their last try
          System.out.print("Previous guesses are : ");
          for(i=0; i<turns; i++){
            System.out.print(a[i] + "  "); // printing previous guesses
          }
          guessString = input.nextLine(); // taking user input
          
          if (guessString.equals("Q") || guessString.equals("q")){//Ending the loop if the player inputs Q or q
           break; 
          }
          try{
            guessInt = Integer.parseInt(guessString);//trys to convert the player's guess to and Int
          }
          catch (Exception e){//if user did not input a string convertible to Int the appropriate error message is displayed
            inputvalid = false;
            if (NumericString(guessString) == true){//checks if input was a number that could not be converted to Int
              System.out.println("Input out of range");
            }else {
              System.out.println("Invalid input");
            }
          }
          if (inputvalid){  
            if (guessInt > 1000 || guessInt < 1){
              System.out.println("Input out of range");//displays error message if the input was convertible to Int but out of the range
            }
          }
        }
        if ( guessInt == RandomNum ){
          System.out.println("\nYou Win!");//displaying the message "You Win" if the player guesses the random number
          break;//exits the guessing loop if the player guessed the number
        }
        
        turns++;//incrementing the turns after each guess
      }
      if (guessString.equals("Q") || guessString.equals("q"))//ends the game if q or Q was inputted
           break;
      
      if ( guessInt != RandomNum ){//if the player didn't guess the number they get the message that they lost
        System.out.println("\n You Lose! You didn't guess the number, it was "+ RandomNum);
      }
      System.out.println("\nDo you want to play again to play again? Y/N");//asking if the player wants to play again
      end = input.nextLine();//taking user input
      
      while(!end.equals("y") && !end.equals("Y") && !end.equals("n") && !end.equals("N") && !end.equals("Q") && !end.equals("q")){
        //asking if the player wants to play again if input was invalid
        System.out.println("\nInvalid Input"
                          +"\n\nDo you want to play again to play again? Y/N");
        end = input.nextLine();//taking user input
      }
      
      if(end.equals("n") || end.equals("N") || end.equals("Q") || end.equals("q"))//quits the game if the player inputs n/N or q/Q
      {
        break;//exits the game loop
      }
      
    }
    System.out.println("\nNumber Guessing Game -- END");//game end message
  }
}
