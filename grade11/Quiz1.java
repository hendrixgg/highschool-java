/**
 * Auto Generated Java Class.
 */
public class Quiz1 {
  
  
  public static void main(String[] args) { 
    double[][] values = {{1.2, 9.0, 3.2},
                         {9.2, 0.5, 1.5, -1.2},
                         {7.3, 7.9, 4.8}};
    
    double[][] things = {{1.2, 9.0},
                         {9.2, 0.5, 0.0},
                         {7.3, 7.9, 1.2, 3.9}};
    int[][] items = {{0, 1, 3, 4},
                     {4, 3, 99, 0, 7},
                     {3, 2}};
    //question 1
    System.out.print("Question 1. answer: values[3][0] = ");
    try{
      System.out.print(values[3][0]);
    }catch(Exception e){
      System.out.println("does not exist.");
    }
    //question 2
    System.out.println();
    System.out.println("Question 2. answer: things.length = "+ things.length);
    //question 3
    System.out.println();
    System.out.println("Question 3. answer: things[2].length = "+ things[2].length);
    //question 4
    System.out.println();
    System.out.println("Question 4. answer: \n"+
                           "before you apply: items[1][2] = 77; items[1][2] = "+ items[1][2]);
    items[1][2] = 77;
    System.out.println("after you apply: items[1][2] = 77; items[1][2] = "+ items[1][2]); 
    //question 5
    items[1][2] = 99;//resetting the value to fit the question 5 array
    int[] temp = {8, 12, 6};//new row
    System.out.println();
    System.out.print("Question 5. answer: \n" + 
                           "temp = {8, 12, 6}\n"+
                           "before you apply: items[0] = temp; items[0] = [");
    for(int col = 0; col < items[0].length; col++){//printing items[0]
      System.out.print(items[0][col]);
        if (col != items[0].length-1)
          System.out.print(", ");
    }
    System.out.print("] location of items[0]:"+ items[0] + ", location of temp: "+ temp);
    items[0] = temp;//replacing items[0] with an entirely new row
    System.out.print("\nafter you apply: items[0] = temp; items[0] = [");
    for(int col = 0; col < items[0].length; col++){//printing items[0]
      System.out.print(items[0][col]);
        if (col != items[0].length-1)
          System.out.print(", ");
    }
    System.out.print("] location of items[0]: "+ items[0] +", location of temp: "+ temp);
    //question 6
    System.out.println();
    System.out.println();
    System.out.println("Question 6. Given a 2D Array of int elements with identifier myItems, write a code \n"+
                       "            snippet that print the array elements on the screen in the same layout as\n"+
                       "            the 2D array.");
    int[][] myItems = {{5, 1, 10, 19, 0, 0, 0, 0, 5},
                       {6, 2, 11, 20, 0, 0, 0, 0, 4},
                       {7, 3, 12, 21, 0, 0, 0, 0, 3},
                       {8, 4, 13, 22, 0, 0, 0, 0, 2},
                       {9, 5, 14, 23, 0, 0, 0, 0, 1},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {45, 12, 17, 7, 0, 0, 0, 0, 15}};
    for(int row = 0; row < myItems.length; row++){
      for(int col = 0; col < myItems[row].length; col++){
        System.out.print(myItems[row][col] +"\t");
      }
      System.out.println();
    }
    //question 7
    System.out.println();
    System.out.println("Question 7. Write a code snippet that adds up the sum of each column and display it \n"+
                       "            on the screen. The output should be a single line representing each \n"+
                       "            column sum separated a spaces in between each sum.");
    System.out.println();
    int sum;
      for(int col = 0; col < myItems[col].length; col++){
        sum = 0;
        for(int row = 0; row < myItems.length; row++){
          try{
          sum += myItems[row][col];
          }catch(ArrayIndexOutOfBoundsException e){
           //do nothing if index out of bounds
          }
        }
        System.out.print(sum + " ");
      }
      //question 7
    System.out.println();
    System.out.println("Question 7. State in words (point form) what the following codes does.");
    System.out.println();
    //the code 
    int[][] a = new int[57][57];
    int y=0, x=0;
    
    for(x=0; x < 57; x++){
     y += a[x][56-x];
       System.out.println(a[x][56-x]);
    }
    System.out.println(y);
  }
  
  /* ADD YOUR CODE HERE */
  
}