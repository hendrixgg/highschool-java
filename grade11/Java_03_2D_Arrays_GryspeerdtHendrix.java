/*Date: sept 20, 2020
 * name: Hendrix Gryspeerdt
 * 
 * Title: Java 02 Multi-dimensional Array Exercises_2
 */

import java.util.*;
public class Java_03_2D_Arrays_GryspeerdtHendrix
{
  public static void title()
  {
   System.out.println("2D Array Traversals");
   System.out.println();
   System.out.println("Traversing a 2D array is valuable to practice when studying 2D arrays.");
   System.out.println();
   System.out.println("int[][] numbers = { {1, 2, 3, 4, 5}, \n"
                     +"                    {6, 7, 8, 9, 10}, \n"
                     +"                    {11, 12, 13, 14, 15}, \n"
                     +"                    {16, 17, 18, 19, 20}, \n"
                     +"                    {21, 22, 23, 24, 25} }");
  }
  public static void Ex1(int[][] array)//Ex.1
  {
    System.out.println("Ex.1");
    System.out.println("Write the code snippet that prints out the array in order. Top row , then across to right, next row, then \n"
                         +"across to the right, next row, etc. Use nested loops. Do not use any methods in the Arrays class.");
    System.out.println();
    System.out.println("Prints the values of row 1, then row 2, then row 3, etc.");
    System.out.println();
    System.out.println("  \tc0\tc1\tc2\tc3\tc4");//printing column labels
    
    for(int row = 0; row < array.length; row++)
    {
      System.out.print("r"+ row +"\t");//printing row labels
      for(int col = 0; col < array[row].length; col++)
      {
        System.out.print(array[row][col] +"\t");
      }
      System.out.println();
    }
    System.out.println();
  }
  public static void Ex2(int[][] array)//Ex.2
  {
    System.out.println("Ex.2");
    System.out.println("Write the code snippet that prints out the array in order starting at the bottom. Bottom row , then \n"
                      +"across to the right previous row, then across to the right, previous row, etc. Use nested loops. Do not use\n"
                      +"any methods in the Arrays class.");
    System.out.println();
    System.out.println("Prints the values of row 5, then row 4, then row 3, etc.");
    System.out.println();
    System.out.println("  \tc0\tc1\tc2\tc3\tc4");//printing column labels
    
    for(int row = array.length-1; row >= 0; row--)
    {
      System.out.print("r"+ row +"\t");//printing row labels
      for(int col = 0; col < array[row].length; col++)
      {
        System.out.print(array[row][col] +"\t");
      }
      System.out.println();
    }
    System.out.println();
  }
  public static void Ex3(int[][] array)//Ex.3
  {
    System.out.println("Ex.3");
    System.out.println("Write the code snippet that prints out the array in reverse order starting at the bottom right. Bottom \n" 
                      +"row , then across to left, previous row, then across to the left, previous row, etc. Use nested loops. Do \n"
                      +"not use any methods in the Arrays class.");
    System.out.println();
    System.out.println("Prints the values of row 5 in reverse order, then row 4 in reverse order, then row 3 in reverse order, etc.");
    System.out.println();
    System.out.println("  \tc4\tc3\tc2\tc1\tc0");//printing column labels
    
    for(int row = array.length-1; row >= 0; row--)
    {
      System.out.print("r"+ row +"\t");//printing row labels
      for(int col = array[row].length-1; col >= 0; col--)
      {
        System.out.print(array[row][col] +"\t");
      }
      System.out.println();
    }
    System.out.println();
  }
  public static void Ex4(int[][] array)//Ex.4
  {
    System.out.println("Ex.4");
    System.out.println("Write the code snippet that prints out the array but displays the columns first and then the rows. Display \n" 
                      +"column 1 on row 1, then column 2 on row 2, then column 3 on row 3, etc. Use nested loops. Do not use \n"
                      +"any methods in the Arrays class.");
    System.out.println();
    System.out.println("  \tr0\tr1\tr2\tr3\tr4");//printing row labels
    
    for(int row = 0; row < array.length; row++)
    {
      System.out.print("c"+ row +"\t");//printing column labels
      for(int col = 0; col < array[row].length; col++)
      {
        System.out.print(array[col][row] +"\t");
      }
      System.out.println();
    }
    System.out.println();
  }
  public static void Ex5(int[][] array)//Ex.5
  {
    System.out.println("Ex.5");
    System.out.println("Write the code snippet that prints out the bottom left triangle of the rectangular array.");
    System.out.println();
    System.out.println("  \tc0\tc1\tc2\tc3\tc4");//printing column labels
    
     for(int row = 0; row < array.length; row++)
    {
      System.out.print("r"+ row +"\t");
      for(int col = 0; col <= row; col++)
      {
        System.out.print(array[row][col] +"\t");
      }
      System.out.println();
    }
     System.out.println();
  }
  public static void Ex6(int[][] array)//Ex.6
  {
    System.out.println("Ex.6");
    System.out.println("Write the code snippet that prints out the top right triangle of the rectangular array.");
    System.out.println();
    System.out.println("  \tc0\tc1\tc2\tc3\tc4");//printing column labels
    
    for(int row = 0; row < array.length; row++)
    {
      System.out.print("r"+ row +"\t");//printing row labels
      for(int spacesToPrint = row; spacesToPrint > 0; spacesToPrint--)
      {
        System.out.print(" \t");
      }
      for(int col = row; col < array[row].length; col++)
      {
        System.out.print(array[row][col] +"\t");
      }
      System.out.println();
    }
     System.out.println();
  }
  public static void Ex7(int[][] array)//Ex.7
  {
    System.out.println("Ex.7");
    System.out.println("Write the code snippet that prints out every other element of the rectangular array.");
    System.out.println();
    System.out.println("  \tc0\tc1\tc2\tc3\tc4");//printing column labels
    
    for(int row = 0; row < array.length; row++)
    {
      System.out.print("r"+ row +"\t");//printing row labels
      for(int col = 0; col < array[row].length; col++)
      {
        if((col+row) % 2 == 0)
        {
        System.out.print(array[row][col] +"\t");
        }else{
          System.out.print(" \t");
        }
      }
      System.out.println();
    }
     System.out.println();
  }
  public static void main(String[] args)
  {
    int[][] numbers = { {1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20},
                        {21, 22, 23, 24, 25}};
    title();
    Ex1(numbers);
    Ex2(numbers);
    Ex3(numbers);
    Ex4(numbers);
    Ex5(numbers);
    Ex6(numbers);
    Ex7(numbers);
  }
  
  
}