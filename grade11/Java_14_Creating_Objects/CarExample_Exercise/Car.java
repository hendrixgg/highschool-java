package CarExample_Exercise;

public class Car {

    private String licensePlate; // e.g. "CWJA 123"
    private double speed; // in kilometers per hour
    private double maxSpeed; // in kilometers per hour

    /**
     * constructor
     * pre: none
     * post: a new Car object is created
     */
    public Car() {
        this.licensePlate = "\"unknown\"";
        this.speed = 0.0;
        this.maxSpeed = 100;
    }

    /**
     * constructor
     * pre: none
     * post: a new Car object is created with the license plate,
     * the speed and the max speed specified
     */
    public Car(String licensePlate, double speed, double maxSpeed) {
        this.licensePlate = licensePlate;
        this.speed = speed;
        if (maxSpeed > 0)
            this.maxSpeed = maxSpeed;
        else
            this.maxSpeed = 0.0;
        if (speed > this.maxSpeed)
            this.speed = this.maxSpeed;
        if (speed < 0)
            this.speed = 0.0;
        else
            this.speed = speed;
    }

    /**
     * constructor
     * pre: none
     * post: a new Car object is created with the license plate,
     * and the max speed specified while the current speed is 
     * initialized to 0;
     */
    public Car(String licensePlate, double maxSpeed) {
        this.licensePlate = licensePlate;
        this.speed = 0.0;
        if (maxSpeed > 0)
            this.maxSpeed = maxSpeed;
        else
            this.maxSpeed = 0.0;
    }

    /**
     * accessor method returns license plate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * accessor method returns speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * acessor method returns max speed
     */
    public double getMaxSpeed(){
        return maxSpeed;
    }

    /**
     * mutator method sets the license plate
     */
    public void setLicensePlate(String licensePlate){
        this.licensePlate = licensePlate;
    }

    /**
     * mutator method sets the speed
     */
    public void setSpeed(double speed){
        if(speed < 0)
            this.speed = 0;
        else if(speed > this.maxSpeed)
            this.speed = this.maxSpeed;
        else
            this.speed = speed;
    }

    /**
     * mutator method sets the max speed
     */
    public void setMaxSpeed(double maxSpeed){
        this.maxSpeed= maxSpeed;
    }

    /**
     * accelerates the car object to it's maximum speed
     * pre: none
     * post: the speed is now equal to maxSpeed
     */
    public void floorIt() {
        speed = maxSpeed;
    }

    /**
     * accelerates the car object to the desired speed
     * pre: none
     * post: the speed is now increased
     */
    public void accelerate(double deltaV) {
        speed = speed + deltaV;

        if (speed < 0.0)
            speed = 0.0;
    }

     /**
     * returns true if the car is speeding 
     * false if not
     * pre: none
     * post: true or false is returned
     */
    public boolean isSpeeding() {
        double excess;
        excess = maxSpeed - speed;
        if (excess < 0)
            return true;
        else
            return false;
    }

    /**
     * stops the car by setting the speed to 0
     * pre: none
     * post: the car object's speed is now 0
     */
    public void stop(){
        this.speed = 0;
    }
    
}
