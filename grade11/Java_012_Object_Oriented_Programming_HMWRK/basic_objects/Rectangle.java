package basic_objects;
import java.text.DecimalFormat;

public class Rectangle {
    private double width;
    private double length;
    private static DecimalFormat df = new DecimalFormat("############.##");
    /**
     * constructor pre: none post: A Rectangle object created. Width and length
     * initialized to 1.
     */
    public Rectangle() {
        width = 1;
        length = 1;
    }

    /**
     * constructor pre: none post: A Rectangle object created. Width and length
     * initialized to W and L.
     */
    public Rectangle(double L, double W) {
        width = W;
        length = L;
    }

    /**
     * Returns the length of the rectangle. pre: none post: The length of the
     * rectangle has been returned.
     */
    public double getLength() {
        return (length);
    }

    /**
     * Returns the width of the rectangle. pre: none post: The width of the
     * rectangle has been returned.
     */
    public double getWidth() {
        return (width);
    }

    /**
     * Calculates the area of the rectangle. pre: none post: The area of the
     * rectangle has been returned.
     */
    public double area() {
        double area = length * width;

        return (area);
    }

    /**
     * Calculates the primeter of the rectangle. pre: none post: The perimeter of
     * the rectangle has been returned.
     */
    public double perimeter() {
        double perimeter = 2 * (length + width);

        return (perimeter);
    }


    /**
     * Displays the formula for the area of a rectangle. pre: none post: The formula
     * for area of a circle has been displayed.
     */
    public static void displayAreaFormula() {
        System.out.println("The formula for the area of a rectanlge is a = L * W");
    }


    /**
    * Determines if the object is equal to another
    * Rectangle object.
    * pre: r is a Rectangle object.
    * post: true has been returned if the objects have
    * the same radii. false has been returned otherwise.
    */
    public boolean equals(Object r) {
        Rectangle testObj = (Rectangle) r;

        if (testObj.getLength() == length && testObj.getWidth() == width) {
            return (true);
        } else {
            return (false);
        }
    }


    /**
    * Returns a String that represents the Rectangle object.
    * pre: none
    * post: A string representing the Rectangle object has
    * been returned.
    */
    public String toString() {
        String rectangleString;

        rectangleString = "Rectangle has length " 
        + df.format(length) + " and has width " + df.format(width);

        return (rectangleString);
    }
}