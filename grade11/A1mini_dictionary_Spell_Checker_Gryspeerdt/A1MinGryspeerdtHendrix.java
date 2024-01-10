/*Date; 24/09/2020
 * Name: Hendrix Gryspeerdt
 * 
 * Program Description:
 * This program is designed to function as a simple spell checker. This implementation of a spell checker uses a 
 * "dictionary" that the user adds words to that the program assumes are spelled correctly. The user can choose to: 
 * 1. Add words to the dictionary
 * 2. Search for a word in the dictionary
 * 3. Insert a word in the dictionary.
 * 4. Delete a word from the dictionary
 * 5. List the contents of the dictionary alphabetically
 * 6. Count the number of words in the dictionary
 * 7. Go back to main menu
 * Then, when they choose to spell check a file, the program flags words that are not in the dictionary and
 * asks the user if they want to ignore the flagged word or add it to the dictionary.
 * 
 */

import java.io.*;
import java.util.*;

public class A1MinGryspeerdtHendrix 
{
  static Scanner keyboard1 = new Scanner(System.in);
  static Scanner keyboard2 = new Scanner(System.in);
  static Scanner keyboard3 = new Scanner(System.in);
  static Scanner keyboard4 = new Scanner(System.in);
  static ArrayList<String> dictionary = new ArrayList<String>();
  
  public static void main(String[] args) 
  {
    dictionary = new ArrayList<String>();
    
    String input; 
    
    do // Main menu
    {
      System.out.println("\nWelcome to Spell Checker \nWhat would you like to do?\n" +
                           "[1] Administrative Dictionary Options\n" +
                           "[2] Run Spell Checker on a text file\n" +
                           "[3] Quit");
      input = keyboard1.nextLine();
      if(input.equals("1"))
      {
        do 
        {
          System.out.println("\nYou have chosen Administrative Dictionary Options, select what you wish to do:\n" +
                             "[1] Add words to the dictionary from a text file\n[2] Search for a word in the dictionary\n[3] Insert a word into the dictionary\n[4] Delete a word from the dictionary\n" +
                             "[5] List the contents of the dictionary alphabetically\n[6] Count the number of words in the dictionary\n[7] Go back to main menu");
          input = keyboard2.nextLine();//takes user input
          
          if(input.equals("1")) 
          { 
            System.out.println("\nYou have chosen to ADD to the dictionary.\nType the name of the file to get your words from.");
            input = keyboard3.next();//takes user input
            addWords(input);
          }
          if(input.equals("2")) 
          {
            System.out.println("\nYou have chosen to SEARCH the dictionary.\nEnter your search.");
            keyboard3.useDelimiter("[^a-zA-Z0-9]+");
            input = keyboard3.next();//takes user input
            if (search(input)){
              System.out.println(input +" exists in dictionary");
            }
            else if(dictionary.size() > 0){
              System.out.println(input +" does not exist in dictionary");
            }else{
              System.out.println(input +" does not exist");
            }
          }
          if(input.equals("3")) 
          {
            System.out.println("\nYou have chosen to INSERT a word into the dictionary. Type the word");
            keyboard3.useDelimiter("[^a-zA-Z0-9]+");
            input = keyboard3.next();//takes user input
            if (insert(input)){
              System.out.println(input +" was inserted to the dictionary");
            }
            else{
              System.out.println(input +" was not inserted to the dictionary. It was not a new word.");
            }
          }
          if(input.equals("4")) 
          {
            System.out.println("\nYou have chosen to DELETE a word from the dictionary. Type the word");
            keyboard3.useDelimiter("[^a-zA-Z0-9]+");//uses any non alphanumeric characters as a delimiter
            input = keyboard3.next();//takes user input
            if (delete(input)){
              System.out.println(input +" was deleted from the dictionary");
            }
            else{
              System.out.println("Did not delete "+input +" since it does not exist in the dictionary.");
            }
          }
          if(input.equals("5")) 
          {
            list();
          }
          if(input.equals("6")) 
          {
            count();
          }
        } while(!input.equals("7"));
        System.out.println("Returning to main menu");
      }
      if(input.equals("2")) {
        System.out.println("\nYou have chosen to spell check a file. Type the file's name");
        input = keyboard2.next();
        spellCheck(input);
      }
    } while(!input.equals("3"));
    System.out.println("Program Terminated");
  }
  /*takes a string as an input and returns it with all 
   * lower case letters 
   */
  public static String lowerCase(String word)
  {
    for(int i = 0; i < word.length(); i++){//replaces lower case letters with upper case letters
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
              word = word.replace((char)word.charAt(i),(char)(word.charAt(i) + 32));
            }
          }
    return word;
  }
  
  /* Reads a file, adding each new word to the dictionary.
   * fileName is the name of the file
   */
  public static void addWords(String fileName) 
  {
    Scanner dataScan1 = null;
    Scanner dataScan2 = null;
    boolean found = true;
    String temp = "";
    ArrayList<String> addedwords = new ArrayList<String>();
    
    try {
      //inputData is just a text file
      dataScan1 = new Scanner(new File(fileName));//scanner to import all the words from the text file
      dataScan2 = new Scanner(new File(fileName));//scanner to print all the words from the text file
    }
    catch (FileNotFoundException exception) {//catches FileNotFoundException
      System.out.println("The input file was not found.");//give the user an error message because the file they wanted to inport was not found
      found = false;//stores the fact that the file was not found as false
    }
    
    // will run as long as file exists and the exception did not run
    if (found) {
      // Checks to see if there are more tokens read
      while (dataScan1.hasNext())   {
        // initialize the string delimiter
        dataScan1.useDelimiter("[^a-zA-Z0-9]+");
        temp = lowerCase(dataScan1.next());
        if(dictionary.contains(temp) == false){//Adds a word to the dictionary if it was new. 
          addedwords.add(temp);
          dictionary.add(temp);      //Also adds it to the new word list so the user knows what words were added.
        }
      }
        System.out.println("The imported text file: ");//shows the user the text they imported
        while (dataScan2.hasNext()){
          System.out.println(dataScan2.nextLine()); //prints the text file line by line 
        }
        System.out.println("\nThe words added to dictionary: \n");
        if(!addedwords.isEmpty()){//code executes only if words were added to the dictionary
          Collections.sort(addedwords);//sorts the list ofwords that were added to the dictionary
          System.out.println(addedwords);//prints the words added to the dictionary
        }else{
          System.out.println("No words were added to the dictionary. All words were already included.");
        }
        Collections.sort(dictionary);//sorts the dictionary
      }
  }
  
  /* Searches for a word in the dictionary. 
   * Returns true if found, false otherwise
   */    
  public static boolean search(String word) 
  {
    return dictionary.contains(lowerCase(word));
  }
  
  /* Adds a word to the dictionary if it's not in the dictionary already
   * Returns true if successfull, false otherwise
   */    
  public static boolean insert(String word) 
  {
      if(dictionary.contains(lowerCase(word)) == false){//adds the word to the dictionary if it was not already
        dictionary.add(lowerCase(word));
        return true;//returns true if word was added
      }
    return false;//returns false if word was not added
  }
  
  /* Removes a word from the dictionary
   * Returns true if word was deleted, false otherwise
   */    
  public static boolean delete(String word) 
  {
      if(dictionary.contains(lowerCase(word)) == true){
        dictionary.remove(lowerCase(word));
        return true;
      }
    return false;       
  }
  
  // Lists the words of the dictionary in alphabetical order
  public static void list() 
  {
    if(dictionary.isEmpty()){
      System.out.println("The dictionary is empty, no words to list.");
    }else{
      System.out.println("The dictionary contains the following:");
      Collections.sort(dictionary);
      for(int index = 0; index < dictionary.size(); index++){
        System.out.println((index + 1)+". "+ dictionary.get(index));
      }
    }
  }
  
  // Outputs the number of words in the dictionary
  public static void count() 
  {
    System.out.println("The dictionary contains "+ dictionary.size() +" words.");
  }
  
  // Spell Check method
  public static void spellCheck(String fileName) 
  {
    String input = "";//user input
    Scanner dataScan = null;
    boolean found = true;
    String temp = "";
    ArrayList<String> notFound = new ArrayList<String>();
    
    try {
      //input data is just a text file
      dataScan = new Scanner(new File(fileName));
    }
    catch (FileNotFoundException exception) {
      System.out.println("The input file was not found.");
      found = false;
    }
    // will run as long as file exists and the exception did not run
    if (found) {
      while(dataScan.hasNext()){
        // initialize the string delimiter
        dataScan.useDelimiter("[^a-zA-Z0-9]+");
        temp = lowerCase(dataScan.next());
        if(!dictionary.contains(temp) && !notFound.contains(temp))//adds the word to the flagged words list (notFound array list) 
          notFound.add(temp);                                     //only if it was not in the dictionay and not already flagged
      }
      Collections.sort(notFound);//sorts the notFound array list in alphabetical order
      //a loop that traverses the list of flagged words and give the user the option 
      //to ignore the word, add the word to the dictionary or end the spell check
      for(int i = 0; i < notFound.size(); i++){
        System.out.println("The following word was not found in the dictionary: ");
        System.out.println();
        System.out.println(notFound.get(i));//prints the new word
        System.out.println();
        do{
          System.out.println("What would you like to do?\n[1] Ignore the word\n[2] Add the word to the dictionary \n[3] Cancel the spell check");
          input = keyboard4.nextLine(); //takes user input
        }while(!input.equals("1") && !input.equals("2") && !input.equals("3"));
        if(input.equals("3"))//exits spell check loop if input was 3
          break;
        if(input.equals("2"))//inserts the word if input was 2
          insert(notFound.get(i));
      }
    }
    System.out.println("Spell check over");
  }
  
  
}

