import java.util.Scanner;
/* Gryspeerdt, Hendrix
* October 10th, 2019
*/
class A6MiniGryspeerdtHendrix 
{
  public static void main(String args[])
  {
       
    Scanner input = new Scanner(System.in);
    
    System.out.println("This is Hendrix Gryspeerdt's Java assignnment. Type 0 to continue. \n");
      int e = input.nextInt();
    
    for ( int a = 0; a == e; a++){
      
      System.out.println("\n \n \n \n");
      System.out.println("Input 1 for question 1, 2 for question 2, 3 for question 3 and 4 for question 4");
      int t = input.nextInt();

      if ( t == 1 ){
        
//q1: A program that accepts 3 numbers and displays the sum and whether it's povitive, negative, or zero. 
    
        int x, y, z, sum;
        System.out.println("Question 1:");
        System.out.println("Input three integers \n");
        System.out.print("Input first number: ");
        x = input.nextInt();
        System.out.print("Input second number:");
        y = input.nextInt();
        System.out.print("Input third number: ");
        z = input.nextInt();
        sum = x + y + z;
        int b, c;
        b = y; c = z;
        char sign1, sign2;
        if (y < 0){ sign1 = '-'; b = y*(-1);}else { sign1 = '+'; }
        if (z < 0){ sign2 = '-'; c = z*(-1);}else { sign2 = '+'; }
        
    System.out.print("The sum of the three integers is " + x +" "+ sign1 +" "+ b +" "+ sign2 +" "+ c + " = " + sum);
    
    if ( sum < 0){ System.out.print(", which is negative"); }
    if ( sum == 0){ System.out.print(", which is equal to zero");}
    if ( sum > 0){ System.out.print(", which is positive\n\n"); }
      
      }else if ( t == 2 ){
        
//q2: A program asking for a student's EQAO mark that responds differently based on their mark.
   
    System.out.println("Question 2:");
    System.out.println("What mark did you get on your EQAO math test in Grade 9?");
    System.out.println("Your mark: ");
    double mark = input.nextDouble();
    double need = 50 - mark;
    if ( mark < 0 || mark > 100 ){ System.out.println("please enter a mark between 0 and 100");
      System.out.println("\n");
      System.out.println("Your mark: ");
      mark = input.nextDouble();
      need = 50 - mark;
      if ( mark >= 80 && mark <= 100){ System.out.println("Congratulations, you had an honors mark"); }
      if ( mark >= 60 && mark < 80){ System.out.println("You did well"); }
      if ( mark >= 50 && mark < 60){ System.out.println("You must work harder in math"); }
      if ( mark >= 0 && mark <= 50){ System.out.print("You failed the test, you needed " + need); System.out.print( " more marks to pass"); }
    }
    else{
      if ( mark >= 80 && mark <= 100){ System.out.println("Congratulations, you had an honors mark"); }
      if ( mark >= 60 && mark < 80){ System.out.println("You did well"); }
      if ( mark >= 50 && mark < 60){ System.out.println("You must work harder in math"); }
      if ( mark >= 0 && mark <= 50){ System.out.print("You failed the test, you needed " + need); System.out.print( " more marks to pass"); }
    }
    
      }else if ( t == 3){
    
//q3: A program to classify athletes into three weight classes.
    
    System.out.println( "\n");
    System.out.println( "Question 3:");
    System.out.println( "I am classifying athletes by their weight.");
    System.out.println( "The weight catagories are: => Less than 60 kg - lightweight \n" 
                       +"                           => Between 60 and 80 kg - medium weight \n"
                       +"                           => Over 80 kg - heavyweight");
    System.out.println("\n");
    System.out.println("Enter the number of althetes you want to classify: ");
    int numathletes = input.nextInt();
    System.out.println("Enter their weights in kg \n");
    
      for ( int i = 0; i < numathletes; i++){
      System.out.print("Athlete " + (i + 1));
      double weight = input.nextDouble();
      if (weight < 60) { System.out.print("Athlete " + (i + 1)); System.out.println(" is a lightweight");} 
      if (weight > 60 && weight < 80) { System.out.print("Athlete " + (i + 1)); System.out.println( " is a medium weight"); }
      if (weight > 80) { System.out.print("Athlete " + (i + 1)); System.out.println( " is a heavyweight");}
      }
    
      }else if ( t == 4 ){
      
//q4: A program that takes three side lengths and indicates wether or not those side lengths can form a triangle
    
    System.out.println( "\n");
    System.out.println( "Question 4:");
    System.out.println( "A property of a triangle is that the sum of any two of the sides MUST be larger than the third side. Otherwise it is an impossible triangle.");
    System.out.println( "input three side lengths and I will tell you wether or not those side lengths can form a triangle.");
    System.out.println( "First side length: ");
    double q = input.nextDouble();
    System.out.println( "Second side length: ");
    double r = input.nextDouble();
    System.out.println( "Third side length: ");
    double s = input.nextDouble();
    
    if ( q + r > s && r + s > q && q + s > r) { 
      System.out.println("Those side lengths can form a triangle");
    }
    else{ 
      System.out.println("Those side lengths can't form a triangle"); 
    }
      }
    
      System.out.println("\nType 0 if you wish to end the program, type "+ (a+1) +" to continue.");
      e = input.nextInt();
      if (e == 0) {
    System.out.print("\n \n----- End of Program -----");
    
      }    
      
      }
      
      
      
    
    }
}