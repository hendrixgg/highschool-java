package basic_objects;

public class TestRectangle {
    public static void main(String[] args) {
        Rectangle Rect1 = new Rectangle();
        Rectangle Rect2 = new Rectangle(4,5);

        Rectangle.displayAreaFormula();
        System.out.println();
        System.out.println("Rectangle 1:");
        System.out.println("Length: " + Rect1.getLength());
        System.out.println("Width: " + Rect1.getWidth());
        System.out.println("Perimeter: " + Rect1.perimeter());
        System.out.println("Area: " + Rect1.area());
        System.out.println();
        System.out.println("Rectangle 2:");
        System.out.println("Length: " + Rect2.getLength());
        System.out.println("Width: " + Rect2.getWidth());
        System.out.println("Perimeter: " + Rect2.perimeter());
        System.out.println("Area: " + Rect2.area());
        System.out.println();
        if (Rect1.equals(Rect2)){
            System.out.println("Objects are equal.");
        } else {
            System.out.println("Objects are not equal.");
        }
        System.out.println(Rect1);
        System.out.println(Rect2);

    }
}
