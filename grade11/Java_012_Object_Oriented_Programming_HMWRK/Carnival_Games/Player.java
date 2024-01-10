package Carnival_Games;
import java.text.NumberFormat;

public class Player {
    private double spendingMoney;
    private String prizesWon;
    private String name;

    /**
     * constructor 
     * pre: none 
     * post: A Player object created. Spending money given to
     * player. The prizes won set to none.
     */
    public Player(String name, double money) {
        spendingMoney = money;
        prizesWon = "";
        this.name = name;
    }

    /**
     * Player pays for and then plays a game. 
     * pre: none 
     * post: Player's spending money decreased by cost of game. 
     * The player has a new prize added to existing
     * prizes.
     */
    public String play(GameBooth game) {
        String newPrize;
        if (game.getCost() > spendingMoney) {
            return ("Sorry, not enough money to play.");
        } else {
            spendingMoney -= game.getCost(); // pay for game
            newPrize = game.start(); // play game
            prizesWon = newPrize + ", " + prizesWon;
            return ("prize won: " + newPrize);
        }
    }

    /**
     * Returns the list of prizes won. 
     * pre: none 
     * post: The list of prizes has been returned.
     */
    public String showPrizes() {
        return (prizesWon);
    }

    /**
     * Returns a string representation of a Player object
     * pre: none
     * post: Returns how much money the player has left and
     * the prizes won so far.
     */
    public String toString(){
        String output = "";
        NumberFormat money = NumberFormat.getCurrencyInstance();

        output += name + " has " + money.format(spendingMoney) + " left. ";
        output += " Prize(s) won: " + prizesWon;

        return(output);
    }
}
