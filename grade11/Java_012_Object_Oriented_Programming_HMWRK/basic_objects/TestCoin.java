package basic_objects;

public class TestCoin {
    public static void main(String[] args) {
        Coin nickel = new Coin();
        nickel.flipCoin();
        System.out.println("Coin flip 1: " + nickel);
        nickel.flipCoin();
        System.out.println("Coin flip 2: " + nickel);
    }

}
