
import java.util.Scanner;
class practicefortest{
  public static void main(String args[]){
    Scanner input = new Scanner(System.in);



System.out.println(" ");
    int sentinel = 0;
    double z = 10;
    double y = 0;
    int count = 0;
    while (y >= 0)
    {
    System.out.println("enter an integer (negative to quit):");
    y = input.nextInt();
    if (y > 10){count++;}
    }  
    System.out.println("There are "+ count +" input(s) greater than 10");
    
    
    
    
    
    
  }
}