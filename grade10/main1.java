import java.io.*;

public class main1 {
  public static void main(String[] args) {
    int array[] = {1, 2, 3, 4, 5, 12, 2343, 23423, 315, 321, 124, 525, 125};
    //System.out.println(array[0]);
    printArr(array);
  }
  
  static void printArr(int array[]) {
    System.out.print("[ ");
    for (int i = 0; i < array.length-1; ++i){
      System.out.print(array[i] + ", ");
    }
    System.out.print(array[array.length-1] + " ]");
  }
}