package ca.bcit.comp2522.labs.lab03;

/**
 * Rectangle class for finding area of a Rectangle.
 * Extends the Quadrilateral class to use the constructor and
 * abstract method area().
 * @author Jieun Yu
 * @version 2020
 */
public class Rectangle extends Quadrilateral {

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
  public Rectangle(final int x1, final int y1, final int x2,
                   final int y2, final int x3, final int y3,
                   final int x4, final int y4) {
    super(x1, y1, x2, y2, x3, y3, x4, y4); //calls the super class constructor.
  }

  /**
   * calculates the area of a rectangle.
   * @return base * height double.
   */
  @Override
  public double area() {
    double base = Math.sqrt(Math.pow((getP1().getX() - getP2().getX()), 2)
            + Math.pow((getP1().getY() - getP2().getY()), 2));
    double height = Math.sqrt(Math.pow((getP2().getY() - getP4().getY()), 2));

    return base * height;
  }
}
