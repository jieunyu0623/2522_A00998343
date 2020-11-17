package ca.bcit.comp2522.labs.lab05;

public class Vehicle {

  private String make;
  private String model;
  private int numPassengers;
  private int topSpeed;

  public Vehicle() {
  }

  public Vehicle(String make, String model, int numPassengers, int topSpeed) {
    this.make = make;
    this.model = model;
    this.numPassengers = numPassengers;
    this.topSpeed = topSpeed;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getNumPassengers() {
    return numPassengers;
  }

  public void setNumPassengers(int numPassengers) {
    this.numPassengers = numPassengers;
  }

  public int getTopSpeed() {
    return topSpeed;
  }

  public void setTopSpeed(int topSpeed) {
    this.topSpeed = topSpeed;
  }

  @Override
  public String toString() {
    return  "make: " + getMake() + "\tmodel: " + getModel();
  }
}
