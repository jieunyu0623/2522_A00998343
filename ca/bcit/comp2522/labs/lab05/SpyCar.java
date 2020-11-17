package ca.bcit.comp2522.labs.lab05;

public class SpyCar extends Car {

  public class MakeSpyCar extends Submarine {

    private int maxDepth;
    private int mileage;

    public MakeSpyCar(final String make, final String model,
                      final int topSpeed,
                      final int numPassengers,
                      final int maxDepth, final int mileage) {
      super(make, model, topSpeed, numPassengers, maxDepth);
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
      return  "make: " + getMake() + "\tmodel: " + getModel() + "\tmileage: " + getMileage()
              + "\tmaxDepth: " + getMaxDepth();
    }

  }

}
