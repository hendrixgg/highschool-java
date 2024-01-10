package basic_objects;
import java.text.DecimalFormat;

public class TestCircle {
    static DecimalFormat df = new DecimalFormat("############.0");
    public static void main(String[] args){
        Circle spot = new Circle();

        spot.setRadius(3);

        System.out.println();
        Circle.displayAreaFormula();
        System.out.println();

        System.out.println("Circle radius " + df.format(spot.getRadius()));
        System.out.println("Circle circumfrence " + df.format(spot.circumfrence()));

        spot.setRadius(5);
        
        System.out.println("Circle radius " + df.format(spot.getRadius()));
        System.out.println("Circle area " + df.format(spot.area()));
        System.out.println();
        System.out.println();

        Circle spot1 = new Circle(3);
        Circle spot2 = new Circle(4);

        if (spot1.equals(spot2)){
            System.out.println("Objects are equal.");
        } else {
            System.out.println("Objects are not equal.");
        }
        System.out.println(spot1);
        System.out.println(spot2);

    }
}
