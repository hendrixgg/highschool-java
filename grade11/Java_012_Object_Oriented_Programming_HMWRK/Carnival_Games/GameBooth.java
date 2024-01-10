package Carnival_Games;

import java.util.Random;

public class GameBooth {
    private double cost;
    private String firstPrize, consolationPrize;
    private int firstPrizesAwarded = 0, consolationPrizesAwarded = 0;

    /**
     * constructor 
     * pre: none 
     * post: A GameBooth object created. The cost and prizes
     * are set.
     */
    public GameBooth(double charge, String p1, String p2) {
        cost = charge;
        firstPrize = p1;
        consolationPrize = p2;
    }

    /**
     * Game is played and prize awarded. 
     * pre: none 
     * post: Player had three tries. Player successful all 
     * three times received the first prize. A consolation 
     * prize has been awarded otherwise.
     */
    public String start() {
        int toss;
        int successes = 0;
        Random rand = new Random();
        /* play game */
        for (int i = 0; i < 3; i++) { // player gets three tries
            toss = rand.nextInt(2);
            if (toss == 1) {
                successes += 1; // 1 is a successful toss
            }
        }
        /* award prize */
        if (successes == 3) {
            firstPrizesAwarded++;
            return (firstPrize);
        } else {
            consolationPrizesAwarded++;
            return (consolationPrize);
        }
    }

    /**
     * Returns the cost to play the game. 
     * pre: none 
     * post: Cost of the game has been returned.
     */
    public double getCost() {
        return (cost);
    }

    /**
     * Returns the prizes awarded so far. 
     * pre: none 
     * post: The number of prizes is returned as a string.
     */
    public void prizesAwarded(){
        System.out.print("First prizes awarded: " + firstPrizesAwarded +
        ", Consolation prizes awarded: " + consolationPrizesAwarded);
    }
}