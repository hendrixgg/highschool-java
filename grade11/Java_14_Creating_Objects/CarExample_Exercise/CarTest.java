package CarExample_Exercise;

public class CarTest {
    
    public static void main(String args[]) {
        Car c1 = new Car();
        Car c2 = new Car("CWJA 123",104.5);
        c2.setSpeed(70.0);
        System.out.println("car1 " + c1.getLicensePlate() + " is moving at " + 
        c1.getSpeed() + " kilometers per hour.");
        System.out.println("car2 " + c2.getLicensePlate() + " is moving at " + 
        c2.getSpeed() + " kilometers per hour.");
        
    }
}
