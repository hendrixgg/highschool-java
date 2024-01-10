// this program will cause an Out of Memory Error

class Out_Of_Memory_Error{
    
    
    public static void main(String[] args){ 
        // if no error occurs, delete a zero until an error occurs
      int x = 100000;
      while(true){
        Object[] arr = new Object[Integer.MAX_VALUE/x];
        System.out.println(arr);
        x = x/10;
      }
        
    }
    
   
    
}