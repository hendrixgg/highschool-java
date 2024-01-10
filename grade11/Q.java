/**
 * Auto Generated Java Class.
 */
public class Q {
  
  
  public static void main(String[] args) { 
    int[][] a = new int[57][57];
    int y=0; int x=0; int count = 0;    
    for(int row = 0; row < a.length; row++){
      for(int col = 0; col < a[row].length; col++){
        System.out.print(a[row][col] +"  ");
      }
      System.out.println();
    }
    
    for(x=0; x < 57; x++){
     y += a[x][56-x];
       System.out.println(a[x][56-x]);
       count++;
    }
    System.out.println(y); count++;
    System.out.println(count + " zeros were printed");
    
  }
  
  /* ADD YOUR CODE HERE */
  
}
