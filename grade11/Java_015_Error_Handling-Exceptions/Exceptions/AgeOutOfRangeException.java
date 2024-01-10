package Exceptions;

public class AgeOutOfRangeException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public AgeOutOfRangeException() {
        super("You are older than the requested age (25 years)");   
    }
    
}
