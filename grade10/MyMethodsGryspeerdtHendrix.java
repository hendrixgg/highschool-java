//Complete the following program
//Write the missing code for the methods
import java.util.*;
import java.text.DecimalFormat;

class MyMethodsGryspeerdtHendrix
{
  public static Scanner input = new Scanner(System.in);
  public static DecimalFormat df = new DecimalFormat("###,###.##");
  public static DecimalFormat df1 = new DecimalFormat("##.################");
public static void main(String args[])
{
 int choice = 0;
 double centi;
 double fahr;
 double cm;
 double inches;

 
 //Menu shows 6 choices    1. Convert Fahrenheit to Centigrade  Use C = 5/9(F-32)
 //                        2. Convert Centigrade to Fahrenheit  Use F = 9.0/5 * C + 32
 //                        3. Convert cm to inches              Use cm = 2.54 * inch
 //                        4. Convert inches to centimeters     Use in = cm/2.54
 //                        5. Convert seconds to hrs and min and sec e.g 3800 second = 1 hr 3 min and 20 sec
 //                        6. Quit
 
   
   while (choice != 6)
     {
        choice = show_menu();
      if (choice == 1)
      {
          convert_fahrenheit_to_centigrade();
      
      }
      else if (choice == 2)
      {
          fahr = convert_centigrade_to_fehrenheit();
      
      }    
      else if (choice == 3)
      {
            inches = convert_cm_to_in();
      
      }      
      else if (choice == 4)
      {
           cm = convert_in_to_cm();
      
      }     
      else if (choice == 5)
      {
            convert_seonds_to_HrandMinutes();
      }
     }
}
public static int show_menu()
{
  System.out.println("Main Menu:");
  System.out.println("1. Convert Fahrenheit to Centigrade  Use C = 5/9(F-32)");
  System.out.println("2. Convert Centigrade to Fahrenheit  Use F = 9.0/5 * C + 32");
  System.out.println("3. Convert centimeters to inche      Use cm = 2.54 * inch");
  System.out.println("4. Convert inches to centimeters     Use in = cm/2.54");
  System.out.println("5. Convert seconds to hrs and min and sec e.g 3800 second = 1 hr 3 min and 20 sec");
  System.out.println("6. Quit");
  System.out.println("Choose an option (1, 2, 3, 4, 5, 6)");
  
  int choice = input.nextInt();
  return choice;
}


public static void convert_fahrenheit_to_centigrade()
{
//should ask for Fahrenheit  
 /*
  System.out.println("\n\n\n1. Convert Fahrenheit to Centigrade.");
  System.out.println("Enter a temperature in Farenheit:");
  double temp = input.nextDouble();
  double   centi = 5.000/9*(temp - 32);
  System.out.println(temp + " F is " + centi + " C\n\n\n");
  
  return centi;
  */
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
   //end of q1()
   String[] arr2 = new String[5];
   for ( int i = 0; i < arr2.length; i++)
   {
    System.out.println("Enter a String");
      arr2[i] = input.next();
   }
   for (int i = 0; i < arr2.length; i++)
   {
    System.out.println(arr2[i] + " has length " + arr2[i].length()); 
   }
}

public static double convert_centigrade_to_fehrenheit()
{
  //should ask for centgrade
  System.out.println("\n\n\n2. Convert Centigrade to Fahrenheit.");
  System.out.println("Enter a temperature in Centigrade:");
  double temp = input.nextDouble();
  double  fahr = 9.0*temp/5 + 32;
  System.out.println(temp + " C is " + fahr + " F\n\n\n");
  
  return fahr;
}

public static double convert_in_to_cm()
{
  //should ask for inches
  System.out.println("\n\n\n4. Convert inches to centimeters.");
  System.out.println("Enter a length in inches:");
  double length = input.nextDouble();
  double cm = 2.54*length;
  System.out.println(length + "\"" + " is " + cm + "cm.\n\n\n");
    
  return cm;
    
}
public static double convert_cm_to_in()
{
  //should ask for cm
  System.out.println("\n\n\n3. Convert centimeters to inches.");
  System.out.println("Enter a length in centimeters:");
  double length = input.nextDouble();
  double inches = length/2.54000000000000000000000000000000000000;
  System.out.println(length + "cm" + " is " + inches +"\".\n\n\n");
  
  return inches;
}
public static void convert_seonds_to_HrandMinutes()
{
  //should ask for seconds
  System.out.println("\n\n\n5. Convert seconds to hrs and min and sec e.g 3800 second = 1 hr 3 min and 20 sec.");
  System.out.print("Input seconds: ");
  double time = input.nextDouble(); 
  double sec = time % 60;
  double hr = (time / 60);
  double min = hr % 60; 
  min = min - (min%1);
  hr = (hr / 60) -  ((hr / 60)% 1);
  System.out.print(time + " seconds = " + df.format(hr) + " hr " + df.format(min) + " min and " + df1.format(sec) + " sec\n\n\n");

}
}