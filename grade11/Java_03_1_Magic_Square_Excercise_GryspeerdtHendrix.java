/*date: 23/09/2020
 * name: Hendrix Gryspeerdt
 * Java 03.1 - Magic Square Exercise
 */
import java.util.*;
class Java_03_1_Magic_Square_Excercise_GryspeerdtHendrix 
{
  public static void BlankSquare(int order)
  {
    for(int row = 0; row < order + 1; row++)
    {
      for(int col = 0; col < order + 1; col++)
      {
        if(row == 0)
        {
          System.out.print(" _");
        }else{
          System.out.print("|_");
        }
      }
      if(row != 0)
        {
      System.out.print("|\n");
      }else{
       System.out.println(); 
      }
    }
  }
  
  public static void main(String[] args) 
  {//Variables
    int order = 4;
    String inputString = "";
    Scanner input = new Scanner(System.in);
    int[][] MagicSquare;
    boolean inputvalid = true;
    //title block
    System.out.println("A magic square of order n is a square array containing the integers");
    System.out.println("\t1, 2, 3, . . ., n, n+1, n+2, . . ., n^(2-2), n^(2-1), n^2");
    System.out.println("each one used exactly once. ");
    System.out.println("The values in each row, column, and two diagonals must sum to the same value.");
    System.out.println("The number n is called the order of the magic square. For an example, see the square below (of order 4):");
    BlankSquare(order); order = 0;
    System.out.println("Each column row and diagonal must be equal. This is known as the magic constant. It is unique to each");
    System.out.println("magic square.");
    System.out.println();
    do
    {
      System.out.println("--enter q at any time to quit--");
      System.out.println("Now enter the order of the magic square (this must be a positive integer): ");
      inputString = input.nextLine();
      
      try{
        order = Integer.parseInt(inputString);
        if(order < 0)
          System.out.println("\nInvalid input\n");
      }catch(Exception e)
      {
        if(!inputString.equals("q")&&!inputString.equals("Q"))
          System.out.println("\nInvalid input\n");
      }
    }while(!(order > 0) && !inputString.equals("q") && !inputString.equals("Q"));
      
    if(!inputString.equals("q")&&!inputString.equals("Q"))
    {
      MagicSquare = new int[order][order];
      while(true)
      {
        inputvalid = true;
        System.out.println("--enter q at any time to quit--");
        System.out.println("Now enter the numbers of the magic square seperated by spaces: ");
        for(int row = 0; row < MagicSquare.length; row++)
        {
          for(int col = 0; col < MagicSquare[row].length; col++)
          {
            inputString = input.next();
            if(inputString.equals("q")||inputString.equals("Q"))
              break;
            try
            {
              MagicSquare[row][col] = Integer.parseInt(inputString);
            }catch(Exception e)
            {
              inputvalid = false;
              System.out.println("Invalid input(s) \n");
            }//end of try, catch
          }//input column loop ends
          if(inputString.equals("q")||inputString.equals("Q"))
            break;
        }//input row loop ends
        if(inputString.equals("q")||inputString.equals("Q"))
          break;
        if(MagicSquare[order-1][order-1] != 0 && inputvalid)
          break;
      }//while loop ends
      
    }//if(!inputString.equals("q")&&!inputString.equals("Q")) statement
    
  }//main method
}//class