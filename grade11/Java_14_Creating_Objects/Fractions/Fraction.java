package Fractions;

class Fraction{
    private int num; //numerator
    private int den; //denominator

    /**
     * constructor
     * pre: none
     * post: a new fraction object is created
     */
    public Fraction() {
        num = 0; //numerator
        den = 0; //denominator
    }

    /**
     * constructor
     * pre: none
     * post: a new fraction object is created
     */
    public Fraction(int a, int b) {
        num = a; //numerator
        den = b; //denominator
    }

    /**
     * calculates the value of a freaction object
     * pre: none
     * post: the value of the fraction has been returned as a double
     */
    public double size(){
        return Math.abs((double)this.num/this.den);
    }

    /**
     * Compares two fraction objects
     * pre: none
     * post: The reference to the larger object is returned
     */
    public Fraction larger(Fraction other) {
        if (this.size() >= other.size())
            return this;
        else
            return other;
    }

    /**
     * Multiplies the current fraction by the given fraction, p
     * pre: none
     * post: the result is stored in the fraction, not p
     */
    public void timesEquals(Fraction p) {
        this.num *= p.num;
        this.den *= p.den;
    }

    /**
     * Multiplies two fractions and returns the 
     * reference to the new result
     * pre: none
     * post: the new fraction object is returned
     * as the prduct of two fractions 
     */
    public Fraction times(Fraction other) {
        Fraction result = new Fraction();
        result.num = this.num * other.num;
        result.den = this.den * other.den;
        return result;
    }

    /**
     * adds the current fraction to the given fraction, other 
     * pre: none
     * post: the result is stored in "this" fraction
     */
    public void plusEquals(Fraction other){
        this.num += other.num;
        this.den += other.den;
    }

    /**
     * adds two fractions and returns the 
     * reference to the new result
     * pre: none
     * post: the new fraction object is returned
     * as a sum of the two fractions
     */
    public Fraction plus(Fraction other) {
        Fraction result = new Fraction();
        result.num = this.num + other.num;
        result.den = this.den + other.den;
        return result;
    }

    /**
     * reduces the numerator and denominator to lowest terms
     * pre: none
     * post: the fraction is reduced to lowest terms
     */
    public void reduce(){
        int gcd = gcd(num, den);

        this.num /= gcd;
        this.den /= gcd;
    }

    /**
     * returns a string representation of the fraction object
     * pre: none
     * post: a string representing the fraction object has been returned
     */
    public String toString() {
        String str = this.num + "/" + this.den;
        return str;
    }

    /**
     * A function that returns the greates common divisor between two integers
     * through the use of a loop;
     * 
     * @param m an integer
     * @param n an integer
     * @return the greatest common divisor between the two parameters
     */
    public static int gcd(int m, int n) {
        // a variable to hold a temp value when swapping m and n
        int temp;
        /**
         * ------1------ The gcd of two equal values, m and n, is simply m (or n, since
         * they are the same).
         * 
         * e.g., The gcd of 7 and 7 is simply 7, which is the largest number that will
         * divide into 7.
         */
        while (m != n) {
            /**
             * ------2------ If two numbers are not equal, then the gcd of the two values
             * will also divide into their difference and will, in fact, be the gcd of this
             * difference. Thus, if m > n, then the gcd of m and n will be equal to the gcd
             * of n and m - n.
             * 
             * e.g., The number 15 and 10 have a difference of 5. Therefore, the gcd of 15
             * and 10 must also be the gcd of 10 and 5 (which is, of course, 5).
             */
            if (m > n) {
                temp = n;
                n = m - n;
                m = temp;
            }
            /**
             * ------3------ If the numbers are not equal and the first number is smaller
             * than the second, then we can simply switch the numbers and apply rule 2.
             */
            else {
                temp = n;
                n = m;
                m = temp;
            }
        }
        return m;
        // recursive variant:
        //  if(m == n) 
        //     return m;
        //  else if (m > n) 
        //     return gcd(n, m-n);
        //  else 
        //     return gcd(n, m);
        // It is cleaner looking code, although, it is around 2 times slower to compute
    }

}