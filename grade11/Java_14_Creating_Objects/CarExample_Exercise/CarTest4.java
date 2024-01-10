package CarExample_Exercise;

public class CarTest4 {

    public static void main(String[] args){
        Car car = new Car();

        System.out.println(car.getLicensePlate() + " is moving at "
        + car.getSpeed() + " kilometers per hour.\n");

        car.setLicensePlate("Speedy boi");
        car.setMaxSpeed(7500);
        car.setSpeed(2500);

        System.out.println(car.getLicensePlate() + " is moving at "
        + car.getSpeed() + " kilometers per hour.\n");
        System.out.println();
        System.out.println("INCREASE SPEEEEED!!!!!!");
        System.out.println("  ___");
        System.out.println("    _-_-  _/\\______\\\\__");
        System.out.println(" _-_-__  / ,-. -|-  ,-.`-.");
        System.out.println("    _-_- `( o )----( o )-'");
        System.out.println("           `-'      `-'");
        System.out.println();
        for (int i = 0; i < 11; i++){
            car.accelerate(i*100);
            System.out.println(car.getLicensePlate() + " is moving at "
            + car.getSpeed() + " kilometers per hour.\n");
        }
        if(car.isSpeeding()){
            System.out.println("Homey: Yo Speedy boi, slow dowwwwn, else the copppas gon' get ya.");
            System.out.println("\nSpeedy boi: Aight cus, don't care.");
            System.out.println("\nHomey: Suit ya self.\n");
            System.out.println("     !!!! WEE WOO !!!!                      !!!! WEE WOO !!!!");
            System.out.println("                       _____________________");
            System.out.println("    /  .       .      (<$$$$$$>#####<::::::>)");
            System.out.println("   .      .     .  _/~~~~~~~~~~~~~~~~~~~~~~~~~\\_   .       .   .   \\");
            System.out.println(".(          . .  /~                             ~\\ . .   .");
            System.out.println("  ( . .        .~                                 ~.      .         )");
            System.out.println("           ()\\/_____                           _____\\/()   .    .  ).");
            System.out.println("(         .-''      ~~~~~~~~~~~~~~~~~~~~~~~~~~~     ``-.  ...");
            System.out.println(".  . . .-~              __________________              ~-.  .    /");
            System.out.println(" .   ..`~~/~~~~~~~~~~~~TTTTTTTTTTTTTTTTTTTT~~~~~~~~~~~~\\~~'    . ) .");
            System.out.println("    . .| | | #### #### || | | | [] | | | || #### #### | | | .");
            System.out.println("   (   ;__\\|___________|++++++++++++++++++|___________|/__;.   .");
            System.out.println("     .  (~~====___________________________________====~~~)");
            System.out.println(" ( .  .. \\------____________[ POLICE ]___________-------/ ..  .     )");
            System.out.println("         .  |      ||         ~~~~~~~~       ||      |");
            System.out.println("             \\_____/                          \\_____/");
            System.out.println();
            System.out.println("Cops: Hey, slow down there mothaf****r.");
            System.out.println("Gunshots: bam! pow! pow!");
            System.out.println("\nSpeedy boi: Ah shit, my ride. shoulda gone over 9000, I shoulda.");
            car.stop();
            System.out.println(car.getLicensePlate() + " is moving at "
            + car.getSpeed() + " kilometers per hour.\n");
        }


    }
    
}
