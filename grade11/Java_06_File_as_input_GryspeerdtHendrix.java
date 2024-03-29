/*date: 24/09/2020
 * name: Hendrix Gryspeerdt
 * 
 * Java 06 File as Input
 */

import java.util.Scanner;
import java.io.*;
public class Java_06_File_as_input_GryspeerdtHendrix
{
  
  
  public static void main(String[] args) {
// for processing each token found in each line
    Scanner dataScan = null;
    boolean found = true;
    try {
       //inputData is just a text file
      dataScan = new Scanner(new File("p1.txt"));
    }
    catch (FileNotFoundException exception) {
      System.out.println("The input file was not found.");
      found = false;
    }
    // will run as long as file exists and the exception did not run
    if (found) {
// Checks to see if there are more tokens read
      while (dataScan.hasNext()) {
// read next token into our string variable
        System.out.println(" " + dataScan.nextLine());
      }
    }
  }//end of main method
  
  
}
