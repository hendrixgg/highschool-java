package CarExample_Exercise;

class CarTest3 {
    public static void main(String args[]) {
        Car c1 = new Car();

        c1.setLicensePlate("CWJA 123");
        c1.setSpeed(0.0);

        System.out.println("car1 " + c1.getLicensePlate() + " is moving at "
        + c1.getSpeed() + " kilometers per hour.\n");

        for (int i = 0; i < 6; i++) {
            c1.accelerate(25.0);
            System.out.println("car1 " + c1.getLicensePlate() + " is moving at " + 
            c1.getSpeed() + " kilometers per hour.");
        } // end for
    } //end main
}//end class
