/*Date: sept 18, 2020
 * name: Hendrix Gryspeerdt
 * 
 * Title: Java 02 Multi-dimensional Array Exercises_1
 */

import java.util.*;
class Java_02_Multi_dimensional_ArraysGryspeerdtHendrix
{
  
  public static void question_1()
  {
    int [][] a = new int[3][4];
  }
  public static void question_2()
  {
    System.out.println("question 2:");
    // a)
    double[][] first = new double[25][40];
    int numElements = first.length * first[0].length;
    System.out.println("a) there are "+ numElements +" elementsin the array: first[25][40]");
    //b
    boolean [][][] second = new boolean[3][6][50];
    numElements = second.length * second[0].length * second[0][0].length;
    System.out.println("b) there are "+ numElements +" elements in the array: second[3][6][50]");
    //c
    char [][] third = new char[60][40];
    numElements = third.length * third[0].length;
    System.out.println("c) there are "+ numElements +" elements in the array: third[60][40]");
    
    System.out.println();
  }
  
  public static void question_3()
  {
    int a[][] = {{4,2,7},
      {3,9,1}};
    System.out.println("question 3:");
    //a)
    System.out.println("a)");
    for (int row = 0; row < a.length; row++)
    {
      for (int col = 0; col < a[0].length; col++)
      {
        System.out.print(a[row][col]);
      }
      System.out.println();
    }
    //b
    System.out.println("b)");
    for (int row = 0; row < a[0].length; row++)
    {
      for (int col = 0; col < a.length; col++)
      {
        System.out.print(a[col][row]); 
      }
      System.out.println();
    }
    
    System.out.println();
  }
  public static void question_4()
  {
    System.out.println("question 4:");
    int array[][] = {{4,2,7},
      {3,9,1}};
    for (int row = array[0].length - 1; row >= 0; row--)
    {
      for (int col = array.length - 1; col >= 0; col--)
      {
        System.out.print(array[col][row]); 
      }
      System.out.println();
    }
    
    System.out.println();
  }
  public static void question_5()
  {
    //q5
    System.out.println("question 5:");
    double[][] array = {{6.7,9.1,8.3,5.6},
      {2.4,7.5,4.2,7.4},
      {1.9,8.6,3.1,4.9}};
    System.out.println("the sum of all the elements in the array: \n");
    for (int row = 0; row < array.length; row++)
    {
      for (int col = 0; col < array[row].length; col++)
      {
        System.out.print(array[row][col] +"\t");
      }
      System.out.println();
    }
    System.out.println();
    System.out.println("= "+ sum(array));
    System.out.println(); 
  }
  public static void question_6()
  {
    //q6
    System.out.println("question 6:");
    int[][] array = {{1,7,4,8,5},
      {2,7,9},
      {3},
      {7,4,6,8}};
    System.out.println("the maximum value in this array:");
    for (int row = 0; row < array.length; row++)
    {
      for (int col = 0; col < array[row].length; col++)
      {
        System.out.print(array[row][col] +"\t");
      }
      System.out.println();
    }
    System.out.println();
    System.out.println("is "+ max(array));
    System.out.println(); 
  }
  public static void question_7()
  {
    //q7
    System.out.println("question 7:");
    int[][][] array = {
      {{10, 20, 30},{20, 40, 60}}, 
      { {10, 30,50,70},{50},{80, 90}} 
    };
    
    System.out.println("the number of elements in the 3D array: \n");
    for (int row = 0; row < array.length; row++)
    {
      for (int col = 0; col < array[row].length; col++)
      {
        for(int lvl = 0; lvl < array[row][col].length; lvl++)
        {
            System.out.print(array[row][col][lvl] +"\t"); 
        }
        System.out.println();
      }
      System.out.println();
    }
    
    System.out.println();
    System.out.println("is "+ size(array));
    System.out.println();
    
  }
  public static double sum(double array[][])
  {
    double sum = 0;
    for (int row = 0; row < array.length; row++)
    {
      for(int col = 0; col < array[row].length; col++)
      {
        sum += array[row][col]; 
      }
    }
    return sum;
  }
  public static int max(int array[][])
  {
    int max = array[0][0];;
    int temp;
    for (int row = 0; row < array.length; row++)
    {
      for (int col = 0; col < array[row].length; col++)
      {
        if (array[row][col] > max)
          max = array[row][col]; 
      }
    }
    return max;
  }
  public static int size(int array[][][])
  {
    int numElements = 0;
    for (int row = 0; row < array.length; row++)
    {
      for (int col = 0; col < array[row].length; col++)
      {
        for (int lvl = 0; lvl < array[row][col].length; lvl++)
          numElements++;
      }
    }
    return numElements;
  }
  
  public static int sumArray3D(int array[][][])
  {
    int sum = 0;
    for (int row = 0; row < array.length; row++)
    {
      for (int col = 0; col < array[row].length; col++)
      {
        for (int lvl = 0; lvl < array[row][col].length; lvl++)
          sum += array[row][col][lvl];
      }
    }
    return sum;
  }
  
  public static void main(String[] args){
    question_2();
    question_3();
    question_4();
    question_5();
    question_6();
    question_7();
    
  }
}