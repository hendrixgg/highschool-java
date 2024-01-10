public class Number {
    private int[] digits;
    private int length;
    private String[] Options = {"The whole number is: ", 
    "The Ones place digit is: ", "The Tens place digit is: ", 
    "The Hundreds place digit is: ", "The Thousands place digit is: ",
    "The Ten-Thousands place digit is: ", "The Hundred-Thousands place digit is: ", 
    "The Millions place digit is: ", "The Ten-Millions place digit is: ", 
    "The Hundred-Millions place digit is: ","The Billions place digit is: "};


    /**
     * constructor
     * pre: none
     * post: a new number object is created
     */
    public Number(String number){
        this.length = number.length();
        digits = new int[this.length+1];
        digits[0] = Integer.parseInt(number);
        storeDigits();
        }

    /**
     * stores all the digits of the Number object
     * pre: none
     * post: the int array digits now has the values for the
     * numbers at each power of 10
     */
    private void storeDigits(){
        int value = digits[0];
        for(int i = 1; i < digits.length; i++){
            digits[i] = value % 10;
            value = value/10;
        }
    }
    /**
     * returns the digit of the correct place value
     * pre: none
     * post: the int value of the digit specified 
     * by the parameter is returned
     */
    public String getDigit(int d){
        return Options[d] + digits[d];
    }

    /**
     * returns the length of the Number object
     * pre: none
     * post: the int value of the number of digits is returned
     */
    public int getlength(){
        return length;
    }

}
