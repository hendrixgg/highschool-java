//Hendrix Gryspeerdt
//date created (dd/mm/yyyy): 10/03/2020

/*A program that will simulate the roll of 3 dice, and keep track of the total of each roll.
 The program will ask the user for the number of rolls, then it will make that many rolls, and your program
 will keep track of the frequency of each total that resulted.
 This type of data is commonly called frequency data, as we are tracking the frequency of each roll.
 
 Program created by Hendrix Gryspeerdt
 */

import java.util.Scanner;// imports the scanner utility so the program can take inputs from the user
import java.text.DecimalFormat;// imports the option to format long decimal numbers befor they are outputted to the user

public class A5MiniGryspeerdtHendrix
{
  public static void main(String []args)
  {
    Scanner input = new Scanner(System.in);//declares a new scanner
    
    int rollstogen = 0;//initializes a variable that will store the user's input for the number of rolls to generate
    int[] numrollfreqArr = new int[16];// initializes an array to store the number frequency of rolls
    double[] percentrollfreqArr = new double[16];// initializes an array to store the percent frequency of rolls
    double median;//declares a double variable to store the median value
    double mean;//declares a double variable to store the mean value
    String mode;//declares a String variable to store the mode of the data
    
    
    System.out.println("This program will simulate the rolls of sets of 3 six sided dice, and keep track of the total of each \n"//prints user instructions
                       +"roll. The program will ask you for the number of rolls to generate, then it will make that many rolls,\n"//prints user instructions 
                       +"and the program will keep track of the frequency of each total that resulted.\n\n");                     //prints user instructions
    do
    {
      System.out.println("Please enter the number of rolls to generate, one roll being 3 six sided dice rolled together. The maximum rolls possible is 10,000 (enter a negative to quit) : ");//prints instructions
      rollstogen = Math.round(input.nextInt());// accepts user input
      
      if (rollstogen < 0)//ensures that the program receives an input in the desired range and if not, the program ends
      {
        System.out.println("\nA negative value was entered - program ends");//prints message just befor program ends
        break;//breaks the do while loop
      }
      
      if(rollstogen > 10000)//an if statement that executes if the user input was greater than 10000
      {
        System.out.println("Error: enter a value 10 000 or less\n\n");//prints error message
      }else{//executes if the user input was between 0 and 10000 inclusively
        
        for (int i = 0; i < rollstogen; i++)//a loop that repeats rollstogen number of times for the number the user inputted
        {
          numrollfreqArr[threediceroll()-3]++; //increments a the index of the roll generated by threediceroll
        }
        
        for (int i = 0; i < percentrollfreqArr.length; i++)//a loop that repeats 16 times for the number of different possible rolls
        {
          percentrollfreqArr[i] = getpercentfreq(numrollfreqArr, i, rollstogen); // sets percentrollfreq[i] to the percentage produced from the getpercentfreq method
        }
        
        median = getMedian(numrollfreqArr, rollstogen); // sets the median to the value obtained from the getMedian method
        mean = getMean(numrollfreqArr, rollstogen);// sets the mean to the value obtained from the getMean method
        mode = getMode(numrollfreqArr);// sets the mode to the string obtained from the getMode method
        
        dice_roll_chart(numrollfreqArr, percentrollfreqArr, mean, median, mode, rollstogen);//prints the organized chart
        
        for (int i = 0; i < numrollfreqArr.length; i++)//a loop that repeats 16 times for the number of different possible rolls
        {
          numrollfreqArr[i] = 0; //resets the value of numrollfreq[i] to 0
        }
      }
    }while(true);// a loop that repeats until break
  }
  
  public static double getpercentfreq(int [] freqdataArr, int i, int total)//a method that takes in the information of a frequency array with the position as well as the total number of rolls and returns the frequency as a percentage
  {
    double rollpercentage = Math.round(1000000.000*(freqdataArr[i]*1.000)/(total*1.000))/1000000.000;//produces a rounded value that goes to 3 decimal places once multiplied by 100
    return 100*rollpercentage;//returns the double value
  }
  
  public static double getMean(int [] freqdataArr, int total)// a method that takes in the information of a frequency array and the total number of rolls and returns the mean
  { 
    int sumtotal = 0;// initializes the sumtotal variable to 0
    
    for (int i = 0; i < freqdataArr.length; i++)//a for loop that repeats freqdataArr.length times for each different roll
    {
      sumtotal = sumtotal + freqdataArr[i]*(i+3); //adds the number of rolls multiplied by the value of that roll to the sumtotal
    }
    
    double mean = sumtotal/(total*1.000000);//determines the mean value 
    
    return mean;// returns the mean value and 
  }
  
  public static double getMedian(int[] freqdataArr, int rolls)//a method to determine the medium given a frequency array and the number of rolls
  {
    double median = 0;//declaring the variable that will store the medium value
    int high = 0;//declaring the variable that will store the higher middle number when considering the median with an even number of rolls
    int low = 0;//declaring the variable that will store the lower middle number when considering the median with an even number of rolls
    int sum1 = 0;//declaring variables
    int sum2 = 0;//declaring variables
    if (rolls%2 == 1)//an if statement that executes if the number of rolls is odd
    {
      low = (rolls+1)/2;//finds the position of the median number in the list of all rolls
      for (int i = 0; i < freqdataArr.length; i++)//a loop that repeats freqdataArr.length times
      {
        sum1 = sum1 + freqdataArr[i];//the higher end of the range corresonding to a roll of i+3
        sum2 = sum1 - freqdataArr[i];//the lower end of the range corresponding to a roll of i+3
        if(low > sum2 && low <= sum1)//an if statement that executes if the position of the median number is in the given range
        {
          median = i + 3;// sets the median number to i+3 because freqdataArr[0] corresponds to a 3
          break;//exits the for loop
        }
      }
    }else{// number of rolls is even
      low = rolls/2;//gives the position of the first number to be considered in the median
      high = (rolls/2) + 1;// gives the position of the second number to be considered in the median
      for (int i = 0; i < freqdataArr.length; i++)//a loop that repeats until the lower middle number to be considered in the median is found
      {
        sum1 = sum1 + freqdataArr[i];//the higher end of the range corresonding to a roll of i+3
        sum2 = sum1 - freqdataArr[i];//the lower end of the range corresponding to a roll of i+3
        if(low > sum2 && low <= sum1)//an if statement that executes when the low value is greater than sum2 (which is the lower range in the frequency total) and less than or equal to sum1 (which is the lower range in the frequency total)
        {
          low = i + 3;// sets the lower middle number to i + 3 because freqdataArr[0] corresponds to a 3
          sum1 = rolls;
          break;//ends the for loop once the lower middle number is found
        }
      }
      for (int i = freqdataArr.length-1; i >= 0; i--)//a loop that repeats until the higher middle number to be considered in the median is found
      {
        sum1 = sum1 - freqdataArr[i];//the lower end of the range corresponding to a roll of i+3
        sum2 = sum1 + freqdataArr[i];//the higher end of the range corresponding to a roll of i+3
        if(high <= sum2 && high > sum1)//an if statement that executes when the high value is less than or equal to sum2 (which is the upper range in the frequency total) and greater than sum1 (which is the lower range in the frequency total) 
        {
          high = i + 3;//sets the higher middle number to i+3 because freqdataArr corresponds to a 3
          break;//exits the for loop
        }
      }
      median = (low + high)/2.00;//sets the median to the average of the two middle numbers
    }
    return median;//returns the double value and ends the gedMedian method
  }
  
  public static String getMode(int [] freqArr)// a method that takes in a frequency array and prints the mode of the array with spaces between
  {
    String mode = "";//a boolean array to store the true or false value of if a number has occured the highest number of times and has the length of the frequency array
    int max = 0;// a variable to store the highest frequency
    for(int i = 0; i < freqArr.length; i++)//a loop to repeat freqArr.length number of times 
    {
      if (freqArr[i] > max)//if statement executes if the frequency of a given number is greater than the max
        max = freqArr[i];//assigns to the variable max the frequency of freqArr[i] if the above if statement was true 
    }
    for(int i = 0; i < freqArr.length; i++)//a loop to repeat freqArr.length number of times
    {
      if(freqArr[i] == max)// if freqArr[i] equals the max frequency, the integer i+3 is added to the mode along with a space
        mode += (i+3) + " ";
    }
    return mode;//returns the string and ends the getMode method
  }
  
  
  public static void dice_roll_chart(int [] freqArr, double [] percentArr, double mean, double median,String mode, int rolls)// a method that takes in numrollfreq[], percentrollfreq[], mean, median, mode and the number of rolls generated to generate an organized chart
  {  
    DecimalFormat df1 = new DecimalFormat("###0.#");//decimal format to be used when printing the mean and medium
    DecimalFormat df2 = new DecimalFormat("#00.000");//decimal format to be used when printing the percentage frequency
    
    System.out.println("Roll | Number of Occurrences | %(.000) frequency");//printing the column title for a chart
    System.out.println("_______________________________________________");//printing a horizontal line
    int x = 3; // a variable that says which roll (prints a 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18)
    for (int i = 0; i < freqArr.length; i++)// a loop that repeats 16 times for the 16 rows in the chart
    {
      System.out.print(x); //prints the roll of the row
      if (x > 9)// prints one less space beside a 2 digit number
      {
        System.out.print("   | ");//printing spaces and dividing line for a two digit number
      }else{
        System.out.print("    | ");//printing spaces and dividing line for a one digit number
      }
      
      System.out.print(freqArr[i]);// prints the frequency of that specific roll (the rolls being :  3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18)
      
      if (freqArr[i] <= 9) // prints one less spaces beside larger numbers
      {
        System.out.print("                     | ");//printing spaces and dividing line for a single digit number
      }else if (freqArr[i] <= 99){
        System.out.print("                    | ");//printing spaces and dividing line for a two digit number
      }else if (freqArr[i] <= 999){
        System.out.print("                   | ");//printing spaces and dividing line for a three digit number
      }else if (freqArr[i] <= 9999){
        System.out.print("                  | ");//printing spaces and dividing line for a four digit number
      }else if (freqArr[i] <= 99999){
        System.out.print("                 | ");//printing spaces and dividing line for a five digit number
      }
      
      if(rolls != 0)//an if statement that executes if the number of rolls is not equal to 0
      {
        System.out.println("%" + df2.format(percentArr[i]));// prints the roll frequency in percentage
      }else{
        System.out.println("%" + 0.000);// prints a %0.000 when # of rolls is 0
      }
      x++;//increments the variable displaying the roll under the roll column
    }
    if(rolls > 0)// an if statement that executes if the number of rolls generated is greater than 0
    {
      System.out.println("\nThe mean of the roll data is (each roll added up then the sum divided by the number of rolls): "+ df1.format(mean));//prints the mean
      System.out.println("The mode is: " + mode);//prints the mode
      System.out.println("The median is : " + df1.format(median));//prints the median
    }
    System.out.println("\n");// prints two blank lines
  }
  
  public static int threediceroll()// a method that generates three random six sided dice rolls, adds them and outputs the sum
  {
    int rolla = (int)(6*Math.random() + 1);//generates roll a
    int rollb = (int)(6*Math.random() + 1);//generates roll b
    int rollc = (int)(6*Math.random() + 1);//generates roll c
    int rollsum = rolla + rollb + rollc;// adds the three rolls
    
    return rollsum;//returns the value
  }
  
}