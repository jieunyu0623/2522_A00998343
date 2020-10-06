package ca.bcit.comp2522.labs.lab03;

/**
 * Quadrilateral abstract class for four points.
 * one abstract method called area is used.
 * @author Jieun Yu
 * @version 2020
 */
abstract class Quadrilateral {

  /** point1. */
  private final Point point1;
  /** point2. */
  private final Point point2;
  /** point3. */
  private final Point point3;
  /** point4. */
  private final Point point4;

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
  Quadrilateral(final int x1, final int y1, final int x2,
                       final int y2, final int x3, final int y3,
                       final int x4, final int y4) {
    point1 = new Point(x1, y1);
    point2 = new Point(x2, y2);
    point3 = new Point(x3, y3);
    point4 = new Point(x4, y4);
    if (point1.equals(point2) || point1.equals(point3)
            || point1.equals(point4)
            || point2.equals(point3)
            || point2.equals(point4)
            || point3.equals(point4)) {
      throw new IllegalArgumentException("INVALID: "
              + "two or more points coincide.");
    }

    if (point1.isCollinear(point2, point3, point4)
            || point2.isCollinear(point1, point3, point4)
            || point3.isCollinear(point1, point2, point4)
            || point4.isCollinear(point1, point2, point3)) {
      throw new IllegalArgumentException("INVALID: "
              + "three or more points are collinear.");
    }
  }

  /**
   * gets point1.
   * @return point1
   */
  public Point getP1() {
    return point1;
  }

  /**
   * gets point2.
   * @return point2
   */
  public Point getP2() {
    return point2;
  }

  /**
   * gets point3.
   * @return point3
   */
  public Point getP3() {
    return point3;
  }

  /**
   * gets point4.
   * @return point4
   */
  public Point getP4() {
    return point4;
  }

  abstract double area();

}
