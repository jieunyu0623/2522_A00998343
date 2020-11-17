package ca.bcit.comp2522.labs.lab05;
/*
 * Truck.java

 */
public class Truck extends Vehicle {

    private String make;
    private String model;
    private int numPassengers;
    private int topSpeed;
    private int towingCapacity;
    private int mileage;

    /** Creates a new instance of Truck */
    public Truck() {
        super();
    }
    public Truck(String make, String model, int towingCapacity, int numPassengers, int topSpeed, int mileage) {
        super(make, model, numPassengers, topSpeed);
        this.towingCapacity = towingCapacity;
        this.mileage = mileage;
    }

    public int getTowingCapacity() {
        return towingCapacity;
    }

    public void setTowingCapacity(int towingCapacity) {
        this.towingCapacity = towingCapacity;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

}
