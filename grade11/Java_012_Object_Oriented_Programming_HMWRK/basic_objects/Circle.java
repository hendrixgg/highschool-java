/**
 * Circle class
 */
package basic_objects;
import java.text.DecimalFormat;

public class Circle{
    private static final double PI = Math.PI;
    private double radius;
    private static DecimalFormat df = new DecimalFormat("############.0");

    /**
     * constructor
     * pre: none
     * post: A Circle object created. Radius initialized to 1.
     */
    public Circle(){
        radius = 1;     //default radius 1
    }

    /**
     * constructor
     * pre: none
     * post: A Circle object created with radius r.
     */
    public Circle(double r){
        radius = r;
    }

    /**
     * Changes the radius of the circle.
     * pre: none
     * post: Radius has been changed.
     */
    public void setRadius(double newRadius){
    radius = newRadius;        
    }


    /**
     * Calculates the area of the circle.
     * pre: none
     * post: The area of the circle has been returned.
     */
    public double area(){
        double circleArea;

        circleArea = PI * radius * radius;
        return(circleArea);
    }
    /**
     * Returns the radius of the circle.
     * pre: none
     * post: The radius of the circle has been returned.
     */
    public double getRadius(){
        return(radius);
    }

    /**
     * Calculate the circumfrence of the circle.
     * pre: none
     * post: The circumfrence of the circle has been returned
     */
    public double circumfrence(){
        double circumfrence;

        circumfrence = 2 * PI * radius;
        return(circumfrence);
    }

    /**
    * Displays the formula for the area of a circle.
    * pre: none
    * post: The formula for area of a circle has been displayed.
    */
    public static void displayAreaFormula() {
    System.out.println("The formula for the area of a circle is a=Pi*r*r");
    }

    /**
    * Determines if the object is equal to another
    * Circle object.
    * pre: c is a Circle object.
    * post: true has been returned if the objects have
    * the same radii. false has been returned otherwise.
    */
    public boolean equals(Object c) {
        Circle testObj = (Circle) c;

        if (testObj.getRadius() == radius) {
            return (true);
        } else {
            return (false);
        }
    }

    
    /**
    * Returns a String that represents the Circle object.
    * pre: none
    * post: A string representing the Circle object has
    * been returned.
    */
    public String toString() {
        String circleString;

        circleString = "Circle has radius " + df.format(radius);
        return (circleString);
    }
}