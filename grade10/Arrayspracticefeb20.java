//Hendrix Gryspeerdt
//20/02/2020
//Arrays practice



class Arrayspracticefeb20
{
  
  public static void main (String args[])
  {
  //Array_a_();
  
  //Array_a_reverse();
    
    Palindrome_checker();
    Palindrome_checker();
    Palindrome_checker();
  
  
  }
   
  public static void Array_a_() //a method that creates an array with a length of 10 and elements being 1,2,3,4,5,6,7,8,9,10 and prints each element in ascending order with one element per line
  {
   int [] a = new int[10]; //declaring the array and setting number of elements
   
   for (int i = 0; i < a.length; i++)
   {
    a[i] = i + 1; //a loop to assign values to the array elements
   }
   for (int i = 0; i < a.length; i++)
   {
    System.out.println( a[i] ); //a loop to print each element in ascending order with one element per line
   }
     System.out.println("\n");
  }
  
  public static void Array_a_reverse() //a method that creates an array with a length of 10 and elements being 1,2,3,4,5,6,7,8,9,10 and prints each element in descending order with oen element per line
  {
   int [] a = new int[10]; //declaring the array and setting number of elements
   
   for (int i = 0; i < a.length; i++)
   {
    a[i] = i + 1; //a loop to assign values to the array elements
   }
   for (int i = 9; i >= 0; i--)
   {
    System.out.println( a[i] ); //a loop to print each element in descending order with one element per line
   }
   System.out.println("\n");     
  }
  
  public static void Palindrome_checker() //a method that checks if the elements in an array of char form a palindrome
  {
    char [] b = new char[5]; // declaring array and setting number of elements
    char [] c = new char[5]; // declaring temp array and setting number of elements
    int a = 4;
    int low = 65;
    
    for (int i = 0; i < b.length; i++)
   {
    int num = (int)( 2 * Math.random() ) + low; // a loop assigning either A or B randomly to the 5 elements in the array
    b[i] = (char)num;
   }
    for (int i = 0; i < b.length; i++) //a loop that assigns the elements in b[] to the opposite position in c[]
    {
      c[a] = b[i];
      a -= 1;
    }
    
    if (c[0] == b[0] && c[1] == b[1] && c[2] == b[2] && c[3] == b[3] && c[4] == b[4])
    {
      System.out.println("arrays b and c form a palindrome");
      System.out.println("array b: ");
      for (int i = 0; i < b.length; i++)
     {
        System.out.println( b[i] );
     } 
      System.out.println("array c: ");
      for (int i = 0; i < c.length; i++)
      {
        System.out.println( c[i] );
      }
    } else{
       System.out.println("arrays b and c do not form a palindrome");
      System.out.println("array b: ");
      for (int i = 0; i < b.length; i++)
     {
        System.out.println( b[i] );
     } 
      System.out.println("array c: ");
      for (int i = 0; i < c.length; i++)
      {
        System.out.println( c[i] );
      }
    }
    System.out.println("\n");
  }
  
}