import java.util.Scanner;

class input_output 
{
  public static void main(String args[])
  {
    
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println("What's your first name?");
    String name = keyboard.next();
    
    if (name == "Hendrix" || name == "hendrix"){ System.out.println("Wow! we have the same first name");} 
    System.out.println("Nice to meet you " + name); 
    
    
    char lang = 'z';
      System.out.println("Please pick your preferred language, input: M - for Mandarin"
                      +"\n                                            E - for English"
                      +"\n                                            S - for Spanish");
      lang = keyboard.next().charAt(0);
      
      switch (lang) {
        
        case 'M':
          System.out.println("Wènhòu");
          break;
          
        case 'E':
          System.out.println("Greetings");
          break;
          
        case 'S':
          System.out.println("Saludos");
          break;
          
          default:
          System.out.println("Invalid Selection");
      }
    
    
  }
}