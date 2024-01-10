package CarExample_Exercise;

class CarTest2 {
    public static void main(String args[]) {
    Car c1 = new Car("CWJA 123",104.5);
    Car c2 = new Car("AABB 522",104.5);
    System.out.println("car1 " + c1.getLicensePlate() + " is moving at " + 
    c1.getSpeed() + " kilometers per hour.");
    System.out.println("car2 " + c2.getLicensePlate() + " is moving at " + 
    c2.getSpeed() + " kilometers per hour.");
    
    c1.floorIt();
    System.out.println("\ncar1 " + c1.getLicensePlate() + " is moving at " + 
    c1.getSpeed() + " kilometers per hour.\n");
    
        for (int i = 0; i < 6; i++) {
            c2.accelerate(25.0);
            System.out.println("car2 " + c2.getLicensePlate() + " is moving at " + 
            c2. getSpeed() + " kilometers per hour.");
        }
    }
}
