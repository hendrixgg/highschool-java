//Do while execises
//Nov 5th, 2019
//Hendrix Gryspeerdt
import java.util.*;
import java.text.DecimalFormat;
class DoWhileGryspeerdtHendrix{
  public static int stringCompare(String str1, String str2) 
    { 
  
        int l1 = str1.length(); 
        int l2 = str2.length(); 
        int lmin = Math.min(l1, l2); 
  
        for (int i = 0; i < lmin; i++) { 
            int str1_ch = (int)str1.charAt(i); 
            int str2_ch = (int)str2.charAt(i); 
  
            if (str1_ch != str2_ch) { 
                return str1_ch - str2_ch; 
            } 
        } 
  
        // Edge case for strings like 
        // String 1="Geeks" and String 2="Geeksforgeeks" 
        if (l1 != l2) { 
            return l1 - l2; 
        } 
  
        // If none of the above conditions is true, 
        // it implies both the strings are equal 
        else { 
            return 0; 
        } 
    } 
  public static void main(String args[]){
  Scanner input = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("###,###");
    DecimalFormat df1 = new DecimalFormat("###.00");
    DecimalFormat df2 = new DecimalFormat("###,###,###.######");
    
    //#1
    System.out.println("#1. A program that counts from 0 to 100 by 2's"); int x = 0;
    do{
      System.out.print(x+", ");
      x += 2;
    }while (x <= 100);
    System.out.println("\n");
    
    //#2
    System.out.println("#2. A program that counts down from 100 to 0 by 2's"); x = 100;
    do{
      System.out.print(x+", ");
      x -= 2;
    }while (x >= 0);
    System.out.println("\n");
    
    //#3
    System.out.println("#3. A program that asks the user for a secret password until they guess it");
    String pass = "wow"; double count = 1; String guess = " ";
    do{
      System.out.println("Guess the password: ");
      if (count >= 5) { System.out.println("hint: the password is "+ pass); }
      guess = input.next();
      if (stringCompare(guess, pass) != 0){ System.out.println("INCORRECT!\n"); }
      count++;
      }while (stringCompare(guess, pass) != 0);
      System.out.print("Great! you guessed it");
      System.out.println("\n");
      
      //#4
      System.out.println("#4. A program that reads exam marks (0-100) one at a time until a mark of less than zero is entered");
      count = 0; double mark = 0; double highmark = 0; double lowmark = 100; double totalmark = 0;
      do{ 
        System.out.println("Input exam mark #"+ df.format(count + 1) +": ");
        mark = input.nextDouble();
        if (mark <= 100 && mark >= 0){ count++; totalmark += mark;}
        if (mark > highmark && mark <= 100 && mark >= 0){ highmark = mark; }
        if (mark < lowmark && mark <= 100 && mark >= 0){ lowmark = mark; }
      }while (mark >= 0);
      System.out.println("The number of exam marks entered is "+ df.format(count));
      System.out.println("The average exam mark was "+ df1.format(totalmark/count));
      System.out.println("The highest exam mark was "+ df.format(highmark));
      System.out.println("The lowest exam mark was "+ df.format(lowmark));
      System.out.println("\n");
      
      //#5
      System.out.println("#5. A program that displays all the multiples of <mult> between x and y (inclusive) across the screen with a space in-between them.");
      double mult = 0; count = 0;
      while(mult <= 0){
      System.out.println("Enter the multiple (a positive value):"); 
      mult = input.nextDouble();
      }
      
      double lownum = -1;
      while(lownum < 0){
        System.out.println("Enter the lower bound of the range (0 or a positive value):");
        lownum = input.nextDouble(); 
      }
      
      double highnum = 0;
      while(highnum <= 0){
        System.out.println("Enter the higher bound of the range (a positive value):");
        highnum = input.nextDouble(); 
      }
      System.out.print("output: ");
      do{
        System.out.print(df2.format(lownum + (count*mult)) +" ");
        count++;
      }while((((count-1)*mult)+lownum) <= (highnum-mult));
      System.out.println("\n");
      
      //#6
      System.out.println("#6. A program that first forces the user to supply a positive integer and then prints the number and the sum of its digits");
      do{
      System.out.println("Enter the positive integer:");
      x = input.nextInt();
      }while(x <= 0);
      int num = x;
      int sum = 0;
      while(num > 0){
        sum = sum + num % 10;
        num = num / 10;
      }
      System.out.println("input: "+ x);
      System.out.println("sum of digits: "+ sum);
      /*int num = 321;
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }*/
      
      
      
      
  }}