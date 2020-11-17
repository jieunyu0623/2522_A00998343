package ca.bcit.comp2522.labs.lab05;
/*
 * Submarine.java
 */

public class Submarine extends Vehicle {

    private String make;
    private String model;
    private int topSpeed;
    private int numPassengers;
    private int maxDepth;

    /** Creates a new instance of Submarine */
    public Submarine() {
        super();
    }
    public Submarine(String make, String model, int topSpeed, int numPassengers, int maxDepth) {
        super(make, model, numPassengers, topSpeed);
        this.maxDepth = maxDepth;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

}
