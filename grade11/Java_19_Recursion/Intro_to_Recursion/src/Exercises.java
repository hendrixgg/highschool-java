import java.util.HashSet;
import java.util.Set;

public class Exercises {

    public static void main(String[] args) {
        // double answer = LnOf2_Inf_Series();
        // System.out.printf("The infinite series of: 1 - 1/2 + 1/3 - 1/4 + 1/5 -... is
        // equal to the natural log of 2 (ln(2)), or approx. %1.11f%n",answer);
        // System.out.printf("1/2(2 - ln(2)) = %1.11f%n", 0.5*(2-answer));

        // long a = 20, b = 28;
        // long gcdValue = gcdL(a, b); // gcd calculated recursivly
        // System.out.println("The gcd of " + a + " and " + b + " is " + gcdValue);
        // System.out.println();

        // int x = 12;
        // long ans = factorialRecur(x);
        // System.out.println("The result of " + x + "! is: " + ans);

        // long ans = factorialLoop(x);
        // System.out.println("The result of " + x + "! is: " + ans);

        // System.out.println("Climb the stairs.");
        // climbTheStairsLoop(5);
        // System.out.println();
        // System.out.println("Climb the stairs.");
        // climbTheStairsRecur(5);

        // int value = Sequence_A_Loop(3);
        // System.out.println("the third term in the sequence is " + value);

        // int num = Sequence_B_Recur(2);// sequence goes: 1, 2, 3, 3, 3, 3, 3,...
        // System.out.println(num);

        // String s = "Hobble-Gobble-Gobble";
        // System.out.println("Here is our string: " + s);
        // // s = reverseStringV1(s);
        // // s = reverseStringV2(s);
        // // s = reverseStringV3(s);
        // s = reverseStringLoop(s);
        // System.out.println("Here is our string reversed: " + s);

        String a = "10101";
        System.out.println("Here is our string: " + a);
        System.out.println("Now print all permutaions of " + a);
        permuteString(a);

        // long fib = fibLoop(45);
        // System.out.printf("The 45th term of the fibbonaci sequence is %,d%n", fib);
    }

    public static double LnOf2_Inf_Series() {
        double lnOf2 = 1;
        for (long i = 0; i < 10000000000L; i++) {
            if (i % 2 == 0)
                lnOf2 -= 1.00000000 / (i + 2);
            else
                lnOf2 += 1.00000000 / (i + 2);
        }
        return lnOf2;
    }

    public static int sum1ToN(int n) {
        // if n < 1, return 0
        if (n < 1)
            return 0;
        // otherwise return n + sum to 1 from n-1
        else
            return n + sum1ToN(n-1);
    }

    public static long fibLoop(int term) {
        long temp = 0;
        long num1 = 0;
        long num2 = 1;
        for (int i = 0; i < term; i++) {
            num1 = temp;
            temp = num2;
            num2 += num1;
        }
        return num1;
    }
    
    /**
     * Makes absolutely no sense to use the recursive version, as the iterative
     * implementation of this sequence is many times faster for terms higher than 45
     * or so.
     * 
     * @param term the term to calculate
     * @return the value of the term in the fibonacci sequence.
     */
    public static long fibRecur(int term) {
        // if n < 1, return 0
        if (term <= 1)
            return 0;
        // if n = 1 or 0, return 1
        if (term == 2)
            return 1;
        else
            return fibRecur(term-1) + fibRecur(term-2);   
    }

    public static long factorialLoop(long x) {
        // if negative, throw exception
        if (x < 0)
            throw new ArithmeticException("Factorial of " + x + " is undefined");
        // 0! is 1
        if(x == 0)
            return 1;
        // multiplies the input by every integer less than it
        // down to 1
        for (long i = x - 1; i > 0; i--)
            x *= i;
        return x;
    }

    public static long factorialRecur(long x) {
        // if negative, throw exception
        if (x < 0)
            throw new ArithmeticException("Factorial of " + x + " is undefined");
        // base case if x = 0, return 1
        if (x == 0)
            return 1;
        // otherwise return x multiplied by (x-1)!
        return x * factorialRecur(x - 1);
    }

    /**
     * <p>
     * A function that returns the greatest common divisor between two {@code long}
     * values through the use of the resursive Euclidian algorithim.
     * </p>
     * <p>
     * The gcdL is a function that returns the greates common divisor between two
     * integers through the use of a loop.
     * </p>
     * <p>
     * The below code achieves the same as the code in the method definition, except
     * instead of repeated subtraction the % operator is used: <blockquote>
     * 
     * <pre>
     * if (a == b)
     *     return a;
     * else if (a > b)
     *     return gcdR(b, a - b);
     * else
     *     return gcdR(b, a - b);
     * </pre>
     * 
     * </blockquote>
     * <p>
     * The % also works for swapping a and b when a < b, because (lesser value) %
     * (greater value) = (lesser value).
     * </p>
     * <h4>The algorithim works as follows :</h4>
     * <p>
     * <b>1 -</b> The gcd of two equal values, a and b, is simply a (or b, since
     * they are the same).
     * </p>
     * <p>
     * e.g. The gcd of 7 and 7 is simply 7, which is the largest number that will
     * divide into 7.
     * </p>
     * <p>
     * <b>2 -</b> If two numbers are not equal, then the gcd of the two values will
     * also divide into their difference and will, in fact, be the gcd of this
     * difference. Thus, if a > b, then the gcd of a and b will be equal to the gcd
     * of b and a - b.
     * </p>
     * <p>
     * e.g., The number 15 and 10 have a difference of 5. Therefore, the gcd of 15
     * and 10 must also be the gcd of 10 and 5 (which is, of course, 5).
     * </p>
     * <p>
     * <b>3 -</b> If the numbers are not equal and the first number is smaller than
     * the second, then we can simply switch the numbers and apply rule 2.
     * </p>
     * 
     * @param a a {@code long} value
     * @param b a {@code long} value
     * @return the greatest common divisor between the two parameters
     */
    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        // if b = 0, then return a
        // otherwise calculate gcd of b and a % b
        return (b == 0) ? a : gcd(b, a % b);
    }

    /**
     * <p>
     * The gcdL is a function that returns the greates common divisor between two
     * {@code long} values through the use of a loop.
     * </p>
     * <p>
     * The below code achieves the same as the code in the method definition, except
     * instead of repeated subtraction the % operator is used: <blockquote>
     * 
     * <pre>
     * long temp;
     * while (a != b) {
     *     if (a > b) {
     *         temp = b;
     *         b = a - b;
     *         a = temp;
     *     } else {
     *         temp = b;
     *         b = a;
     *         a = temp;
     *     }
     * }
     * return Math.abs(a);
     * </pre>
     * 
     * </blockquote>
     * <h4>The algorithim works as follows :</h4>
     * <p>
     * <b>1 -</b> The gcd of two equal values, a and b, is simply a (or b, since
     * they are the same).
     * </p>
     * <p>
     * e.g. The gcd of 7 and 7 is simply 7, which is the largest number that will
     * divide into 7.
     * </p>
     * <p>
     * <b>2 -</b> If two numbers are not equal, then the gcd of the two values will
     * also divide into their difference and will, in fact, be the gcd of this
     * difference. Thus, if a > b, then the gcd of a and b will be equal to the gcd
     * of b and a - b.
     * </p>
     * <p>
     * e.g., The number 15 and 10 have a difference of 5. Therefore, the gcd of 15
     * and 10 must also be the gcd of 10 and 5 (which is, of course, 5).
     * </p>
     * <p>
     * <b>3 -</b> If the numbers are not equal and the first number is smaller than
     * the second, then we can simply switch the numbers and apply rule 2.
     * </p>
     * 
     * @param a a {@code long} value
     * @param b a {@code long} value
     * @return the greatest common divisor between the two parameters
     */
    public static long gcdL(long a, long b) {
        // variabe to store remainder
        long remainder;
        /**
         * ------1.2------ The gcd of two multiples (integers that are of the form a =
         * x*m and b = x*n), is the modulus of the greater value to the lesser value.
         * 
         * e.g., 39 % 26 = 13. Therfore the gcd of 39 and 26 is 13, 13 being the largest
         * number that will divide into 39 and 26.
         * 
         * Although, if a and b are equal, the gcd is simply a (or b since a and b are
         * equal).
         */
        while (b != 0) {
            /**
             * ------2------ The modulus of two equal values (or two values where the
             * greater value is a multiple of the other, a = something*x, b = x) will be 0
             * because the lesser value, b, divides the the greater value, a, evenly.
             * 
             * This is why a is set to b and b is set to remainder, because when the
             * remainder is 0, it means that b divided a evenly, so b should be returned.
             * Since the value of b was copied to a, a is returned.
             */
            remainder = a % b;
            /**
             * ------3------ If a was less than b then the values of a and b will be swapped
             * because a % b (% means the remainder of a/b) is set to b. Since the modulus
             * of a lesser value to a greater value is just the lesser value, a % b = a.
             */
            a = b;
            b = remainder;
        }
        return Math.abs(a);
    }

    public static void climbTheStairsRecur(int steps) {
        if (steps == 0) {
            System.out.println("You are at the top");
        } else {
            System.out.println("Take one step up");
            climbTheStairsRecur(steps - 1);
        }
    }

    public static void climbTheStairsLoop(int steps) {
        while (steps > 0) {
            System.out.println("Take one step up");
            steps--;
        }
        System.out.println("You are at the top");
    }

    public static int Sequence_A_Recur(int term) {
        if (term < 1) {
            throw new RuntimeException("Invalid parameter !(term >=1)");
        } else if (term == 1) {
            return 2;
        } else
            return 3 * Sequence_A_Recur(term - 1) - 1;
    }

    public static int Sequence_A_Loop(int term) {
        if (term < 1)
            throw new RuntimeException("Invalid parameter !(term >=1)");
        else {
            int value = 2;
            for (int i = 2; i <= term; i++) {
                value = 3 * value - 1;
            }
            return value;
        }
    }

    public static int Sequence_B_Recur(int term) {
        if (term < 0) {
            System.out.println("Invalid argument to method: 0 returned");
            return 0;
        } else if (term == 0)
            return 1;
        else
            return (int) (2 + 0.5 * Sequence_B_Recur(term - 1));
    }

    /**
     * Returns the input String, {@code s}, in reverse through the use of a loop.
     * 
     * @param s the string input
     * @return the String {@code s} with characters in reverse order.
     */
    public static String reverseStringLoop(String s) {
        if (s == null)
            return "llun";
        String ans = "";
        for (int i = s.length() - 1; i >= 0; i--)
            ans += s.substring(i, i + 1);
        return ans;
    }

    public static String reverseStringV1(String s) {
        if (s == null)
            return "llun";
        if (s.length() > 0)
            return reverseStringV1(s.substring(1)) + s.charAt(0);
        else
            return "";
    }

    public static String reverseStringV2(String s) {
        if (s == null)
            return "llun";
        if (s.length() > 0)
            return s.charAt(s.length() - 1) + reverseStringV2(s.substring(0, s.length() - 1));
        else
            return "";
    }

    public static String reverseStringV3(String s) {
        if (s == null)
            return "llun";
        if (s.length() > 1) {
            // reverse substring from index 0 to end
            String frontHalf = reverseStringV3(s.substring(1, s.length() / 2 + s.length() % 2)) + s.charAt(0);
            String endHalf = reverseStringV3(
                    s.substring(s.length() - (s.length() / 2), s.length() - 1) + s.charAt(s.length() - 1));
            System.out.println(endHalf + " | " + frontHalf);
            return endHalf + frontHalf;
        } else
            return s;
    }

    /**
     * Prints all possible arrangements of the characters of a {@code String}.
     * 
     * @param s the string to be printed
     */
    public static void permuteString(String s) {
        Set<Character> chars = new HashSet<Character>();
        permuteString(s, 0, chars);
    }

    private static void permuteString(String s, int index, Set<Character> chars) {
        String nextString;
        if (index >= s.length()) {
            System.out.println(s);
        } else {
            for (int i = index; i < s.length(); i++) {
                if (!chars.contains(s.charAt(i))) {
                    nextString = s.substring(0, index) 
                    + s.charAt(i)
                    + s.substring(index, i)
                    + s.substring(i + 1);
                    permuteString(nextString, index + 1, new HashSet<Character>());
                    // adds the charachter to the char set because it has already been permuted from
                    chars.add(s.charAt(i));
                }
            }
        }
    }
}