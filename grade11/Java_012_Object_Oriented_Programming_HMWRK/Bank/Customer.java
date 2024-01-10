package Bank;
/**
 * Customer class
 */
public class Customer {
    private String firstName, lastName, street, city, state, zip;

    /**
     * constructor 
     * pre: none 
     * post: A Customer object has been created. Customer data
     * has been initialized with parameters.
     */
    public Customer(String firstName, String lastName, 
    String street, String city, String state, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    /**
     * Returns a String that represents the Customer object. 
     * pre: none 
     * post: A string representing the Account object has been returned.
     */
    public String toString() {
        String custString;
        custString = firstName + " " + lastName + "\n";
        custString += street + "\n";
        custString += city + ", " + state + " " + zip + "\n";
        return (custString);
    }


    /**
     * Changes the class string street to the input. 
     * pre: none 
     * post: this.street = input.
     */
    public void changeStreet(String street){
        this.street = street;
    }


    /**
     * Changes the class string city to the input. 
     * pre: none 
     * post: this.city = input.
     */
    public void changeCity(String city){
        this.city = city;
    }

    
    /**
     * Changes the class string state to the input. 
     * pre: none 
     * post: this.state = input.
     */
    public void changeState(String state){
        this.state = state;
    }


    /**
     * Changes the class string zip to the input. 
     * pre: none 
     * post: this.zip = input.
     */
    public void changeZip(String zip){
        this.zip = zip;
    }
}