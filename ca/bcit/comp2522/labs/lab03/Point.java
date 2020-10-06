package ca.bcit.comp2522.labs.lab03;

import java.util.Objects;

/**
 * Point class for the coordinate x and y.
 * @author Jieun Yu
 * @version 2020
 */
public class Point {

  /** x coordinate. */
  private final double x;
  /** y coordinate. */
  private final double y;

  /**
   * constructs a point with x and y coordinates.
   * @param xCoord double
   * @param yCoord double
   */
  public Point(final double xCoord, final double yCoord) {
    this.x = xCoord;
    this.y = yCoord;
  }

  /**
   * gets the x coordinate.
   * @return x
   */
  public double getX() {
    return x;
  }

  /**
   * gets the y coordinate.
   * @return x
   */
  public double getY() {
    return y;
  }

  /**
   * checks if more than three points are collinear.
   * @param point1 Point
   * @param point2 Point
   * @param point3 Point
   * @return true or false
   */
  public boolean isCollinear(final Point point1,
                             final Point point2,
                             final Point point3) {
    return (this.x == point1.x && this.x == point2.x)
            || (this.x == point1.x && this.x == point3.x)
            || (this.x == point2.x && this.x == point3.x)
            || (this.x == point1.x && this.x == point2.x && this.x == point3.x)
            || (this.y == point1.y && this.y == point2.y)
            || (this.y == point1.y && this.y == point3.y)
            || (this.y == point2.y && this.y == point3.y)
            || (this.y == point1.y && this.y == point2.y && this.y == point3.y);
  }

  /**
   * checks if the object and the comparing object
   * are the same objects.
   * @param o Object
   * @return true or false
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Point point = (Point) o;
    return Double.compare(point.x, x) == 0
            && Double.compare(point.y, y) == 0;
  }

  /**
   * provides hashcode.
   * @return Objects.hash(x, y) int
   */
  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

}
