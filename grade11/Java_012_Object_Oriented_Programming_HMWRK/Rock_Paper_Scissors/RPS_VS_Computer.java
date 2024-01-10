package Rock_Paper_Scissors;

/*
* RPS2.java
*/
import java.util.Scanner;
/**
* Computer plays Rock Paper Scissors against one player.
*/
public class RPS_VS_Computer {
    public static void main(String[] args) {
    RPSGame rps = new RPSGame();
    RPSPlayer rpsOpponent = new RPSPlayer();
    int rounds;
    String SplayerThrow;
    int IntplayerThrow = 1;
    String name;
    Scanner input = new Scanner(System.in);

    /* play RPS */
    System.out.print("Enter your name: ");
    name = input.next();
    rpsOpponent.assignName(name);
    System.out.print("How many rounds? ");
    rounds = input.nextInt();
    for (int i = 0; i < rounds; i++) {
        do{
        System.out.print("Enter your throw (ROCK=1, PAPER=2, SCISSORS=3): ");
        SplayerThrow = input.next();
        try{
            IntplayerThrow = (Integer.parseInt(SplayerThrow));
        }catch(NumberFormatException e){}
        }while(!SplayerThrow.equals("1") && !SplayerThrow.equals("2") && !SplayerThrow.equals("3"));
        rpsOpponent.makeThrow(IntplayerThrow);

        rps.makeCompThrow();
        rps.announceWinner(rpsOpponent.getThrow(), rpsOpponent.getName());
    }
    rps.bigWinner(rpsOpponent.getName());
    input.close();
    }
}
