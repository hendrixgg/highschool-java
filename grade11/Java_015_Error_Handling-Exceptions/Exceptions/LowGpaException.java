package Exceptions;

public class LowGpaException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public LowGpaException() {
        super("Your GPA is not sufficient to apply for this job (2.5)");        
    }
    
}
