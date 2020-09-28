package ca.bcit.comp2522.assignments.a2;

import java.util.Scanner;

/**
 * Simulates the Guppy, Pool, and Ecosystem classes.
 *
 * @author Jieun Yu
 * @version 2020
 */
public final class Driver {

  private Driver() { }

  /**
   * Runs the simulation by asking the user how many weeks they want simulated.
   *
   * @param args not used.
   */
  public static void main(final String[] args) {

    final Ecosystem ecosystem = new Ecosystem();

    System.out.println("How many weeks would you like to simulate for?");
    final Scanner scan = new Scanner(System.in);
    final int weeks = scan.nextInt();

    ecosystem.simulate(weeks);
    scan.close();

  }


}
