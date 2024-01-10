package Bank;
/**
 * Account class
 */
import java.text.NumberFormat;

public class Account {
    private double balance;
    private Customer cust;

    /**
     * constructor 
     * pre: none 
     * post: An account created. Balance and customer data
     * initialized with parameters.
     */
    public Account(double bal, String firstName, String lastName, String street, String city, String state, String zip) {
        balance = bal;
        cust = new Customer(firstName, lastName, street, city, state, zip);
    }

    /**
     * Returns the current balance. 
     * pre: none 
     * post: The account balance has been
     * returned.
     */
    public double getBalance() {
        return (balance);
    }

    /**
     * A deposit is made to the account. 
     * pre: none 
     * post: The balance has been
     * increased by the amount of the deposit.
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * A withdrawal is made from the account if there is enough money. 
     * pre: none
     * post: The balance has been decreased by the amount withdrawn.
     */
    public void withdrawal(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Not enough money in account.");
        }
    }

    /**
     * Changes the address.
     * pre: none 
     * post: the change methods in the customer class 
     * are called with the corresponding parameters.
     */
    public void changeAddress(String street, String city, String state, String zip){
        if (!street.equals("0"))
        cust.changeStreet(street);
        if (!city.equals("0"))
        cust.changeCity(city);
        if (!state.equals("0"))
        cust.changeState(state);
        if (!zip.equals("0"))
        cust.changeZip(zip);
    }


    /**
    * Returns a String that represents the Account object.
    * pre: none
    * post: A string representing the Account object has
    * been returned.
    */
    public String toString() {
        String accountString;
        NumberFormat money = NumberFormat.getCurrencyInstance();
        accountString = cust.toString();
        accountString += "Current balance is " + money.format(balance);
        return (accountString);
    }
}