package ca.bcit.comp2522.labs.lab05;
/*
 * Car.java
 */

public class Car extends Vehicle {

    private String make;
    private String model;
    private int numPassengers;
    private int topSpeed;
    private int mileage;

    /** Creates a new instance of Car */
    public Car() {
        super();
    }
    public Car(String make, String model, int numPassengers, int topSpeed, int mileage) {
        super(make, model, numPassengers, topSpeed);
        this.mileage = mileage;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return  "make: " + getMake() + "\tmodel: " + getModel() + "\tmileage: " + getMileage();
    }

}
