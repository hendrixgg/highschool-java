import java.util.Scanner;
public class DigitExtractorTest {
    public static void main(String[] args){
        Number number;
        String input;
        int numberInt = 0;
        boolean inputValid = true;
        Scanner keyboard = new Scanner(System.in);
        String[] numberData = {"show Whole number (0)", "show Ones place number (1)", 
    "show Tens place number (2).", "show Hundreds place number (3).", "show Thousands place number (4).",
    "show Ten-Thousands place number (5).", "show Hundred-Thousands place number (6).", "show Millions place number (7).", 
    "show Ten-Millions place number (8).", "show Hundred-Millions place number (9).","show Billions place number (10)."};

        do{
            inputValid = true;
            System.out.print("Enter an integer (less than 10 billion): ");
            input = keyboard.next();
            try{
                numberInt = Integer.parseInt(input);
            }catch(Exception e){
                inputValid = false;
            }
            System.out.println();
        }while(!inputValid);

        number = new Number(input);

        do{
            inputValid = true;
            for(int i = 0; i <= number.getlength(); i++)
                System.out.println(numberData[i]);
            
            System.out.println("Quit (Q).");
            System.out.print("Enter your choice: ");
            input = keyboard.next();
            if(!input.equals("q") && !input.equals("Q")){
                try{
                    numberInt = Integer.parseInt(input);
                }catch(Exception e){
                    inputValid = false;
                }
            }else{
                inputValid = true;
            }
            System.out.println();
        }while(!inputValid);

        System.out.println(number.getDigit(numberInt));

        keyboard.close();
    }
}
