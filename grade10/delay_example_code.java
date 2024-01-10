// how to make a delay in a program

public class delay_example_code
{
  
  public static void main(String []args)
  {
    int d = 5000; //the length of the delay in miliseconds
    System.out.println("before delay");
    delay(d); //executes the delay
    System.out.println("After delay of " + d/1000 + " seconds");
  }
  
  public static void delay(int a)
  {
   try
    {
      Thread.sleep(a); // the method for delay
    }
    catch(InterruptedException e)
    {
     System.err.println(e.getMessage()); 
    } 
  }
  
}