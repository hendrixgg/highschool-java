import java.util.Scanner;

public class Recursion_VS_Loop {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        do {
            System.out.println("(1) for Factorial Recursion");
            System.out.println("(2) for Factorial Loop");
            System.out.println("(3) for greatest common divisor Recursion");
            System.out.println("(4) for greatest common divisor Loop");
            System.out.println("(0) to quit");
            System.out.print("Enter your choice: ");
            n = promptForNumber(input);
            System.out.println();
            switch (n) {
                case 1: factorialRecursion();
                    break;
                case 2: factorialLoop();
                    break;
                case 3: gcdRecursion();
                    break;
                case 4: gcdLoop();
                    break;
            }
            System.out.println();
        } while (n != 0);
    }

    public static void factorialRecursion() {
        long startTime, endTime, durationInMillis;
        long sum = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {


            Exercises.factorialRecur(20);
            endTime = System.currentTimeMillis();

            durationInMillis = (endTime - startTime); // Total execution time in milli seconds
            sum = sum + durationInMillis;
            startTime = System.currentTimeMillis();
        }
        System.out.println("A million runs of calculating factorial 20 recursively took " + sum + " milliseconds");
    }

    public static void factorialLoop() {
        long startTime, endTime, durationInMillis;
        long sum = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {


            Exercises.factorialLoop(20);
            endTime = System.currentTimeMillis();

            durationInMillis = (endTime - startTime); // Total execution time in milli seconds
            sum = sum + durationInMillis;
            startTime = System.currentTimeMillis();
        }
        System.out.println("A million runs of calculating factorial 20 with a loop took " + sum + " milliseconds");
    }

    public static void gcdRecursion() {
        long startTime, endTime, durationInMillis;
        long sum = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {


            Exercises.gcd(1890043007, 543219);
            endTime = System.currentTimeMillis();

            durationInMillis = (endTime - startTime); // Total execution time in milli seconds
            sum = sum + durationInMillis;
            startTime = System.currentTimeMillis();
        }
        System.out.printf("A million runs of calculating the gcd of %,d and %,d with Recursion took %d milliseconds.%n", 1890043007, 543219, sum);
    }

    public static void gcdLoop() {
        long startTime, endTime, durationInMillis;
        long sum = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {


            Exercises.gcdL(1890043007, 543219);
            endTime = System.currentTimeMillis();

            durationInMillis = (endTime - startTime); // Total execution time in milli seconds
            sum = sum + durationInMillis;
            startTime = System.currentTimeMillis();
        }
        System.out.printf("A million runs of calculating the gcd of %,d and %,d with a loop took %d milliseconds.%n", 1890043007, 543219, sum);
    }
    /**
     * promptForNumber - int
     * 
     * @param in a Scanner to read integer values from
     * @return an integer value read from the Scanner
     */
    public static int promptForNumber(Scanner in) {
        int value = 0;
        boolean done = false;
        while (!done) {
            if (in.hasNextInt()) {
                value = in.nextInt();
                in.nextLine(); // Move to the next line
                done = true;
            } else {
                System.out.println("ERROR!  Input not an integer!");
                in.nextLine(); // clear input that is not an integer
                System.out.print("Enter an integer: ");
            }
        }
        return value;
    }
}
