//Arrayshandout
import java.util.*;

class Arrayhandout
{
  public static Scanner input = new Scanner(System.in);
  
  public static void main(String args[])
  {
    q1();
    q2();
  //q3();
    q5();
  }
  
  public static void q1()
  {
   int[] arr1 = new int[10]; 
   for (int i = 0; i < arr1.length; i++)
   {
     System.out.println("Enter a number");
       arr1[i] = input.nextInt();
   }
   
   for (int i = 0; i < arr1.length; i++)
   {
    if (arr1[i]%5 == 0)
    {
     System.out.println(arr1[i] + " is divisible by 5");
    }
   }
   System.out.println("\n");
   //end of q1()
  }
  
  public static void q2()
  {
   String[] arr2 = new String[5];
   for ( int i = 0; i < arr2.length; i++)
   {
    System.out.println("Enter a String");
      arr2[i] = input.next();
   }
   for (int i = 0; i < arr2.length; i++)
   {
    System.out.println("Lendgth of String " + i + " : " + arr2[i].length()); 
   }
   System.out.println("\n");
   //end of q2()
  }
  
  /*public static void q3()
  {
   double[] arr3 = new double[8];
   double sum = 0;
   double average = 0;
     
   for (int i = 0; i < arr3.length; i++)
   {
   System.out.println("Enter a decimal number");
   arr3[i] = input.nextDouble();
   sum = sum + arr3[i];
   }
   average = sum/arr3.length;
   System.out.priintln("The Average between the " + arr3.length() + " : " + average);
   
   System.out.println("\n");
   //end of q3()
   
  }
  */
  public static void q5()
  {
   int high = 100;
   int low = 1;
   int[] arr5 = new int[20];
   int max = 1;
   
   System.out.println("The 20 random numbers:");
     for (int i = 0; i < arr5.length; i++)
   {
    arr5[i] = (int)( high * Math.random() ) + low; 
   }
   
   for (int i = 0; i < arr5.length; i++)
   {
    System.out.print(arr5[i] + ", "); 
   }
   
   System.out.println();
   System.out.println("The 20 numbers in reverse order:");
   for (int i = arr5.length - 1; i >= 0; i--)
   {
    System.out.println(arr5[i] + ", ");
   }

   System.out.println();
   System.out.println("maximum number:");
   max = arr5[0];
   for (int i = 0; i < arr5.length; i++)
   {
    if (arr5[i] > max)
    {
     max = arr5[i]; 
    }
   }
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}