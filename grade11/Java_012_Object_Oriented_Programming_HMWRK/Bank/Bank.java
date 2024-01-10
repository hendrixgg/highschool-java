package Bank;
import java.util.Scanner;
import java.text.NumberFormat;

public class Bank {
    public static void main(String[] args) {
        Account munozAccount = new Account(250, "Maria", "Munoz", "110 Glades Road", "Mytown", "FL", "33445");
        
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        double data;
        NumberFormat money = NumberFormat.getCurrencyInstance();

        System.out.println(munozAccount);

        System.out.print("Enter deposit amount: ");
        data = input1.nextDouble();
        munozAccount.deposit(data);
        System.out.println("Balance is: " + money.format(munozAccount.getBalance()));
       
        System.out.print("Enter withdrawal amount: ");
        data = input1.nextDouble();
        munozAccount.withdrawal(data);
        System.out.println("Balance is: " + money.format(munozAccount.getBalance()));

        String userIn;
        do{
        System.out.println();
        System.out.println("Would you like to change your address? y/n");
        userIn = input2.nextLine();
        }while(!userIn.equals("n") && !userIn.equals("N") && !userIn.equals("y") && !userIn.equals("Y"));

        if( userIn.equals("y") || userIn.equals("Y")){
            String[] address = new String[4];
            System.out.println("Now you can change your new address information. Entering a \"0\" will leave the info unchanged.");
            System.out.print("Enter your updated street address: "); 
            address[0] = input2.nextLine();

            System.out.println();
            System.out.print("Enter your updated city: ");
            address[1] = input2.nextLine();

            System.out.println();
            System.out.print("Enter your updated State: ");
            address[2] = input2.nextLine();

            System.out.println();
            System.out.print("Enter your updated Zip code: ");
            address[3] = input2.nextLine();
            munozAccount.changeAddress(address[0], address[1], address[2], address[3]);
            System.out.println();
            System.out.println("Address updated successfully.");
            System.out.println(munozAccount);
        }
        
        //end of program
        input1.close();
        input2.close();
    }
}