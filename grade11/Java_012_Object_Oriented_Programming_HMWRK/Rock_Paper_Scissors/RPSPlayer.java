package Rock_Paper_Scissors;

/**
* models the player in a game of RPS
*/
public class RPSPlayer {
    private int playerThrow; // ROCK=1, PAPER=2, SCISSORS=3
    private String playerName;
    /**
    * constructor
    * pre: none
    * post: RPSPlayer object created. The player is given a
    * default throw.
    */
    public RPSPlayer() {
        playerThrow = 1; // default throw
    }

    /**
     * assigns the variable playerName a new string value
     * pre: none
     * post: playerName has been saved.
     */
    public void assignName(String name){
        playerName = name;
    }

    /**
     * returns the playerName
     * pre: none
     * post: playername has been returned as a string.
     */
    public String getName(){
        return(playerName);
    }

    /**
    * Sets the player's throw.
    * pre: newThrow is the integer 1, 2, or 3.
    * post: Player's throw has been made.
    */
    public void makeThrow(int newThrow) {
        playerThrow = newThrow;
    }
    /**
    * Returns the player's throw.
    * pre: none
    * post: Player's throw has been returned.
    */
    public int getThrow() {
        return (playerThrow);
    }
}