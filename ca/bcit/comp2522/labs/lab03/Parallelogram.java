package ca.bcit.comp2522.labs.lab03;

/**
 * Parallelogram class for finding area of a Parallelogram.
 * Extends the Rectangle class since this class uses
 * the same formula (method) for finding area.
 * @author Jieun Yu
 * @version 2020
 */
public class Parallelogram extends Rectangle {

  /**
   * Constructs x, y coordinates for point1, point2, point3 and point4.
   * @param x1 point1 x coordinate
   * @param y1 point1 y coordinate
   * @param x2 point2 x coordinate
   * @param y2 point2 y coordinate
   * @param x3 point3 x coordinate
   * @param y3 point3 y coordinate
   * @param x4 point4 x coordinate
   * @param y4 point2 y coordinate
   */
  public Parallelogram(final int x1, final int y1, final int x2,
                       final int y2, final int x3, final int y3,
                       final int x4, final int y4) {
    super(x1, y1, x2, y2, x3, y3, x4, y4); //calls the super class constructor.
  }

  /**
   * calculates the area of a Parallelogram.
   * calls the same method area() from the Rectangle class.
   * @return super.area() double
   */
  public double area() {
    return super.area();
  }

}
