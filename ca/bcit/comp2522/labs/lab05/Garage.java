package ca.bcit.comp2522.labs.lab05;
/*
 * Garage.java

 */

import java.util.*;

/**
 *
 * @author Jim
 */
public class Garage {

    private ArrayList<Vehicle> garage = null;

    /** Creates a new instance of Garage */
    public Garage() {
        garage = new ArrayList<Vehicle>();
    }

    public void add(Vehicle x) {
        garage.add(x);
    }

    public void report() {
        System.out.println("My garage has ...");
        for (Vehicle x:garage) {
            System.out.println(x.toString());
        }

        System.out.print("If I filled them all, I could hold ");
        int count = 0;
        for (Vehicle x:garage) {
            count += x.getNumPassengers();
        }
        System.out.println("" + count + " passengers");
    }

}
