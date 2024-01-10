/* File Name: Sample1
* Purpose: This program shows how to declare variables and
calculate on the variables
* Author: Mr. Hossain
* File date: Sep 25, 2019
*/
public class Sample1
{
// method of main( )
public static void main (String args[])
{
//variable declarations and value assignments
int number1 = 5, number2 = 10, sum1;
double num1 = 2.34, num2 = 3.14, sum2;
char letter1 = '±', letter2 = 's';
String name = "Dave";
//use of a new variable to record the sum
sum1 = number1 + number2;
sum2 = num1 + num2;
int age = 30;
//different ways to display the result
System.out.println("The sum1 is : " + sum1);
System.out.println("The sum2 is :" + sum2);
System.out.println("The result of " + number1 + " * " + number2 + " is :" + number1 * number2);
System.out.println("The result of " + number1 + " / " + number2 + " is :" + number1 / number2);
System.out.println("This is :" + name);
System.out.print("I am " + age); System.out.println( " years old");
System.out.println(letter1);
} // end of main()
} //end of Unit1Sample1