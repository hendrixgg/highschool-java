package Rock_Paper_Scissors;

/**
* Models a game of Rock Papaer Scissors
*/
import java.util.Random;

public class RPSGame {
    public static final int ROCK = 1, PAPER = 2, SCISSORS = 3;
    private int compThrow;
    private int playerWins = 0, computerWins = 0;

    /**
    * constructor
    * pre: none
    * post: RPSGame object created. Computer throw generated.
    */
    public RPSGame() {
    Random rand = new Random();
    compThrow = rand.nextInt(3) + 1; // random int between 1 and 3
    playerWins = 0;
    computerWins = 0;
    }

    /**
    * Computer's throw is generated (ROCK, PAPER, or SCISSORS)
    * pre: none
    * post: Computer's throw has been made.
    */
    public void makeCompThrow() {
    Random rand = new Random();
    compThrow = rand.nextInt(3) + 1; // random int between 1 and 3
    }

    /**
    * Returns the computer's throw.
    * pre: none
    * post: Computer's throw has been returned.
    */
    public int getCompThrow() {
        return (compThrow);
    }

    /**
    * Determines the winner of the round.
    * pre: playerThrow is the integer 1, 2, or 3.
    * post: Displays a message indicating throws. Compares player's
    * throw to computer's throw and displays a message indicating
    * the winner.
    */
    public void announceWinner(int playerThrow,String name) {
        /* Inform player of throws */
        System.out.print("You throw ");
        switch (playerThrow) {
            case ROCK: System.out.println("ROCK."); break;
            case PAPER: System.out.println("PAPER."); break;
            case SCISSORS: System.out.println("SCISSORS."); break;
        }
        System.out.print("Computer throws ");
        switch (compThrow) {
            case ROCK:
                System.out.println("ROCK.");
                break;
            case PAPER:
                System.out.println("PAPER.");
                break;
            case SCISSORS:
                System.out.println("SCISSORS.");
                break;
        }
        /* Determine and annouce winner */
        if (playerThrow == ROCK && compThrow == ROCK) {
            System.out.println("It's a draw!");
            System.out.println();
        } else if (playerThrow == ROCK && compThrow == PAPER) {
            System.out.println("Computer wins!");
            System.out.println();
            computerWins += 1;
        } else if (playerThrow == ROCK && compThrow == SCISSORS) {
            System.out.println(name + " wins!");
            System.out.println();
            playerWins += 1;
        }
        if (playerThrow == PAPER && compThrow == ROCK) {
            System.out.println(name + " wins!");
            System.out.println();
            playerWins += 1;
        } else if (playerThrow == PAPER && compThrow == PAPER) {
            System.out.println("It's a draw!");
            System.out.println();
        } else if (playerThrow == PAPER && compThrow == SCISSORS) {
            System.out.println("Computer wins!");
            System.out.println();
            computerWins += 1;
        }
        if (playerThrow == SCISSORS && compThrow == ROCK) {
            System.out.println("Computer wins!");
            System.out.println();
            computerWins += 1;
        } else if (playerThrow == SCISSORS && compThrow == PAPER) {
            System.out.println(name + " wins!");
            System.out.println();
            playerWins += 1;
        } else if (playerThrow == SCISSORS && compThrow == SCISSORS) {
            System.out.println("It's a draw!");
            System.out.println();
        }
    }

    /**
    * Displays the overall winner.
    * pre: none
    * post: Computer and player wins compared and
    * an overall winner announced.
    */
    public void bigWinner(String name) {
        if (computerWins > playerWins) {
            System.out.println("Computer wins " + computerWins + ". " + name + " wins " + playerWins + ".");
            System.out.println("Computer is the overall winner!");
        } else if (playerWins > computerWins) {
            System.out.println("Computer wins " + computerWins + ". " + name + " wins " + playerWins + ".");
            System.out.println(name + " is the overall winner!");
        } else {
            System.out.println("Computer wins " + computerWins + ". " + name + " wins " + playerWins + ".");
            System.out.println("It's a draw!");
        }
    }
}
