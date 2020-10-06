package ca.bcit.comp2522.labs.lab03;

/**
 * Tests if the Rectangle, Square,
 * Trapezoid and Parallelogram classes work.
 * @author Jieun Yu
 * @version 2020
 */
public final class Driver {
  private Driver() { }

  /**
   * Creates four objects of Recntangle, Square,
   * Parallelogram and Trapezoid
   * and gets the area of those.
   * @param args unused.
   */
  public static void main(final String[] args) {

    Quadrilateral rectangle = new Rectangle(2, 5, 6,
            5, 2, 2,
            6, 2);
    System.out.println("Rectangle: " + rectangle.area());
    Quadrilateral square = new Square(2, 5, 5,
            5, 2, 2,
            5, 2);
    System.out.println("\nSquare: " + square.area());
    Quadrilateral parallelogram = new Parallelogram(3, 4, 7,
            4, 1, 1,
            5, 1);
    System.out.println("\nParallelogram: " + parallelogram.area());

    Quadrilateral trapezoid = new Trapezoid(3, 4, 4,
            4, 1, 1,
            6, 1);
    System.out.println("\nTrapezoid: " + trapezoid.area());

  }
}
