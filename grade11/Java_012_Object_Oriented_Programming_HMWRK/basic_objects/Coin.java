package basic_objects;

public class Coin {
    private int faceUp;

    /**
     * constructor pre: none post: A Coin object created. Radius initialized to 1.
     */
    public Coin() {
        faceUp = 0; // coin is heads by default
    }

    /**
     * Returns the state of the coin pre: none post: The value 0 for heads or 1 for
     * tails is returned.
     */
    public int showFace() {
        return (faceUp);
    }

    /**
     * Generates a random state for the coin pre: none post: The value of faceUP is
     * ramdpmly assigned the value of 0 or 1.
     */
    public int flipCoin() {
        faceUp = (int) (Math.random() * 2);
        return (faceUp);
    }

    /**
     * Returns a string representation of the Coin Object
     * pre: none
     * post: A atring representing the Coin object has
     * been returned.
     */
    public String toString(){
        String coinString;

        if (faceUp == 0) {
            coinString = "The coin is heads up!";
        } else {
            coinString = "The coin is tails up!";
        }
        return(coinString);
    }
}
