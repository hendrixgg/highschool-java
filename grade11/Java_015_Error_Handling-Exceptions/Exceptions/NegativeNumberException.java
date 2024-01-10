package Exceptions;

public class NegativeNumberException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public NegativeNumberException() {
        super("You should enter a positive number");        
    }
    
}
