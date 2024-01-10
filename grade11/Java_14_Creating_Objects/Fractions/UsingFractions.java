package Fractions;

public class UsingFractions {
    public static void main(String[] args){

        Fraction f1 = new Fraction(65,35); // instantiate a Fraction object of 2/3
        Fraction f2 = new Fraction(24,54); // instantiate a Fraction object of 5/7

        System.out.println("Fraction 1 is " + f1);
        System.out.println("Fraction 2 is " + f2);

        Fraction n = f1.times(f2); // multiply the two fractions together to result in a new fraction object
        System.out.println("\nNew fraction: " + n + ".");
        n.reduce();                // reduces the fraction to lowest terms
        System.out.println("The fraction simplified is " + n);

    }
}
