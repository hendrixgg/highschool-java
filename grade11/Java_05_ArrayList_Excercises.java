/*Date: 20/09/2020
 * name:hendrix
 * Java 05 - ArrayList Excercises
 */
import java.util.*;
class Java_05_ArrayList_Excercises {
  public static Scanner sc = new Scanner(System.in);
  
  public static String getAlphaNumericString(int n) 
  { 
    
    // chose a Character random from this String 
    String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
      + "0123456789"
      + "abcdefghijklmnopqrstuvxyz"; 
    
    // create StringBuffer size of AlphaNumericString 
    StringBuilder sb = new StringBuilder(n); 
    
    for (int i = 0; i < n; i++) 
    { 
      
      // generate a random number between 
      // Alphanumeric variable length 
      int index = (int)(AlphaNumericString.length() * Math.random()); 
      
      // add Character one by one in end of sb 
      sb.append(AlphaNumericString.charAt(index)); 
    } 
    
    return sb.toString(); 
  } 
  public static void Ex1()
  { 
    System.out.println();
    System.out.println();
    System.out.println("1. Write a Java program to search an element in an ArrayList of strings. State true if it is found,");
    System.out.println("   false otherwise."); 
    System.out.println();
    //variables
    int maxlength = 25;
    int minlength = 5; 
    String search = "";
    boolean found = false;
    int stringLength = 0;
    ArrayList<String> stringList = new ArrayList<String>();//arraylist to store strings
    int listlength = (int)(Math.random()*(maxlength - minlength) + minlength);//length of list
    //code
    for (int index = 0; index < listlength; index++)
    { 
      stringLength = (int)(Math.random()*(4) + 1);//random Alphanumeric string length from length 1 to 10 
      stringList.add(getAlphaNumericString(stringLength));//get a random Alphanumeric string of stringLength
    }
    System.out.println("A list of "+ stringList.size() +" Alphanumeric strings was created");
    System.out.println("Enter an Alphanumeric string of length 1-4 to see if it is in the list");
    search = sc.nextLine();
    System.out.println("is "+ search +" in the list? " + stringList.contains(search));
    System.out.println("All the elements in the list are: "+ stringList);
    System.out.println(stringList.toString());
    System.out.println();
    System.out.println();   
  }
  public static void Ex2() 
  {//title block
    System.out.println();
    System.out.println();
    System.out.println("2. Write a Java program to remove the third element from an ArrayList.");
    System.out.println();
    //Variables
    ArrayList<Double> doubleList = new ArrayList<Double>();//arraylist to store double values
    int maxlength = 10;
    int minlength = 5;
    int listlength = (int)(Math.random()*(maxlength - minlength) + minlength);//length of list
    //code
    for (int index = 0; index < listlength; index++)
    {
      doubleList.add(((int)(100*Math.random()))/100.00);
    }
    
    System.out.println("Elements of the list: "+ doubleList);
    System.out.println("The third element of the list is: "+ doubleList.get(2));
    System.out.println("Now as you can see "+ doubleList.get(2) +" has been removed: ");
    doubleList.remove(2);//remove 3rd element
    System.out.print(doubleList);//prints list again
    System.out.println();
    System.out.println();
  }
  public static void Ex3()
  {//title block
    System.out.println();
    System.out.println();
    System.out.println("3. Write a Java program to join two ArrayLists.");
    System.out.println();
    //variables
    int maxlength = 10;
    int minlength = 5;
    ArrayList<Double> doubleList1 = new ArrayList<Double>();
    ArrayList<Double> doubleList2 = new ArrayList<Double>();
    int listlength1 = (int)(Math.random()*(maxlength - minlength) + minlength);//length of list1
    int listlength2 = (int)(Math.random()*(maxlength - minlength) + minlength);//length of list
    //code
    for (int index = 0; index < listlength1; index++)
    {
      doubleList1.add(((int)(100*Math.random()))/100.00);
    }
    for (int index = 0; index < listlength2; index++)
    {
      doubleList2.add(((int)(100*Math.random()))/100.00);
    }
    System.out.println("List 1: "+ doubleList1);
    System.out.println("List 2: "+ doubleList2);
    doubleList1.addAll(doubleList2);
    System.out.println("list 1 and 2 combined: "+ doubleList1);
    System.out.println();
    System.out.println();
  }
  public static void Ex4()
  {//title block
    System.out.println();
    System.out.println();
    System.out.println("4. Write a Java program to empty an ArrayList.");
    System.out.println();
    //variables
    int maxlength = 10;
    int minlength = 5;
    ArrayList<Integer> IntegerList = new ArrayList<Integer>();
    int listlength = (int)(Math.random()*(maxlength - minlength) + minlength);//gets random length of list
    //code
    for (int index = 0; index < listlength; index++)
    {
      IntegerList.add((int)(100*Math.random()));
    }
    System.out.println("Here is the list: "+ IntegerList);
    IntegerList.clear();
    System.out.println("Now all elements are removed: "+ IntegerList);
    System.out.println();
    System.out.println();
  }
  public static void Ex5()
  {//title block
    System.out.println();
    System.out.println();
    System.out.println("5. Write a Java program to test an ArrayList is empty or not.");
    System.out.println();
    //variables
    int maxlength = 2;
    int minlength = 0;
    ArrayList<Integer> IntegerList = new ArrayList<Integer>();
    int listlength = 3*((int)(Math.random()*2));//gets random length of list
    //code
    for (int index = 0; index < listlength; index++)
    {
      IntegerList.add((int)(100*Math.random()));
    }
    System.out.println("Here is the list: "+ IntegerList);
    System.out.println("Is the list empty? "+ IntegerList.isEmpty());
    System.out.println();
    System.out.println();
  }
  public static void Ex6()
  {//title block
    System.out.println();
    System.out.println();
    System.out.println("6. Write a Java program to convert an array to ArrayList.");
    System.out.println();
    //variables
    // a 2d array with random size and integers from 0-99
    int[][] array = new int[(int)((Math.random()*3)+1)][(int)((Math.random()*3)+1)];
    ArrayList<Integer> IntegerList = new ArrayList<Integer>();//arraylist
    //code
    for (int row = 0; row < array.length; row++)
    {
      for(int col = 0; col < array[row].length; col++)
      {
      array[row][col] = (int)(100*Math.random());//populate array
      }
    }
    /*for (int row = 0; row < array.length; row++)
    {
      for(int col = 0; col < array[row].length; col++)
      {
      IntegerList.add(array[row][col]);//adding array values to the array list
      }
    }*/
    System.out.println("Here is the randomized array: ");
    for (int row = 0; row < array.length; row++)
    {
      for(int col = 0; col < array[row].length; col++)
      {
      System.out.print(array[row][col] +" \t");
      }
      System.out.println();
    }
    System.out.println("Here is the array converted to an Array List: "+ IntegerList);
    System.out.println();
    System.out.println();
  }
  public static void Ex7()
  {//title block
    System.out.println();
    System.out.println();
    System.out.println("7. Write a Java program to shuffle elements in an ArrayList.");
    System.out.println();
    //variables
    int index;
    int temp;
    int maxlength = 25;
    int minlength = 5;
    ArrayList<Integer> IntegerList = new ArrayList<Integer>();
    int listlength = (int)(Math.random()*(maxlength - minlength) + minlength);//gets random length of list
    int firstElement = (int)(25*Math.random());
    //code
    for (index = 0; index < listlength; index++)
    {                                       //populate the list in ascending order from first element
      IntegerList.add(firstElement + index);//to first element + (listlength-1)
    }
    System.out.println("Here is the array list: "+ IntegerList);
    //shuffling
    Collections.shuffle(IntegerList);
    System.out.println("Here is the array list shuffled: "+ IntegerList);
    System.out.println();
    System.out.println();
  }
  public static void Ex8 ()
  {//title block
    System.out.println();
    System.out.println();
    System.out.println("8. Write a Java program to sort a given ArrayList.");
    System.out.println();
    //variables
    int maxlength = 10;
    int minlength = 5;
    ArrayList<Integer> IntegerList = new ArrayList<Integer>();
    int listlength = (int)(Math.random()*(maxlength - minlength) + minlength);//gets random length of list
    //code
    for (int index = 0; index < listlength; index++)//populate the list
    {
      IntegerList.add((int)(100*Math.random()));
    }
    System.out.println("The list before sorting: "+ IntegerList);
    Collections.sort(IntegerList);
    System.out.println("The list after sorting: "+ IntegerList);
    System.out.println();
    System.out.println();
  }
  public static void main(String[] args) 
  { 
  String choice;
  do{
    System.out.println("Enter 1 for question 1, 2 for question 2, etc. Enter 0 to quit.");
    choice = sc.nextLine();
    
    
    if(choice.equals("1"))
    {
      Ex1();
    }
    if(choice.equals("2"))
    {
      Ex2();
    }
    if(choice.equals("3"))
    {
      Ex3();
    }
    if(choice.equals("4"))
    {
      Ex4();
    }
    if(choice.equals("5"))
    {
      Ex5();
    }
    if(choice.equals("6"))
    {
      Ex6();
    }
    if(choice.equals("7"))
    {
      Ex7();
    }
    if(choice.equals("8"))
    {
      Ex8();
    }
    
  }while(!choice.equals("0"));
  }
}