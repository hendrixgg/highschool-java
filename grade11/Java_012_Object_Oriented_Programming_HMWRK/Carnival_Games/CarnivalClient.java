package Carnival_Games;

public class CarnivalClient {

    public static void main(String[] args){
        GameBooth balloonDartToss = new GameBooth(2, "tiger plush", "sticker");
        GameBooth ringToss = new GameBooth(2, "bear keychain", "pencil");
        GameBooth breakAPlate = new GameBooth(1.5, "pig plush", "plastic dinosaur");
        Player shonda = new Player("shonda",5); // $5 spending money
        Player luis = new Player("luis",3); // $3 spending money

        System.out.print("Shonda goes to Balloon Dart Toss. ");
        System.out.println(shonda.play(balloonDartToss));

        System.out.print("Luis goes to Ring Toss. ");
        System.out.println(luis.play(ringToss));

        System.out.print("Shonda goes to Ring Toss. ");
        System.out.println(shonda.play(ringToss));

        System.out.print("Luis goes to Break A Plate. ");
        System.out.println(luis.play(breakAPlate));

        System.out.println("Shonda won: " + shonda.showPrizes());
        System.out.println("Luis won: " + luis.showPrizes());

        System.out.println();
        System.out.println(shonda);
        System.out.println();
        System.out.println(luis);
        System.out.println();
        System.out.println("Balloon dart toss prizes awarded: "); balloonDartToss.prizesAwarded();
        System.out.println();
        System.out.println("Ring toss prizes awarded: "); ringToss.prizesAwarded();
        System.out.println();
        System.out.println("Break a plate prizes awarded: "); breakAPlate.prizesAwarded();
    }
    
}
