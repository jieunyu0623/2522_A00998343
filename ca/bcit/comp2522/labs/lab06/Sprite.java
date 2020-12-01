package ca.bcit.comp2522.labs.lab06;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * the Sprite class.
 * @author Jieun Yu
 * @version 2020
 */
public class Sprite implements Serializable {

  /** x coordinate. */
  private final int xCoordinate;

  /** y coordinate. */
  private final int yCoordinate;

  /** health. */
  private final int health;

  /** gravity. */
  private final float gravity;

  /** weapons. */
  private final List<String> weapons;

  /** image. */
  private final byte[] pixelData;

  /**
   * constructs a Sprite object.
   * @param xCoord int
   * @param yCoord int
   * @param h int
   * @param grav int
   * @param w List<String>
   * @param img BufferedImage
   */
  public Sprite(final int xCoord, final int yCoord, final int h,
                final float grav,
                final List<String> w,
                final BufferedImage img) {

    this.xCoordinate = xCoord;
    this.yCoordinate = yCoord;

    if (h > 0 && h < 100) {
      this.health = h;
    } else {
      throw new IllegalArgumentException("health can be set between 0 and 100");
    }

    this.gravity = grav;
    this.weapons = w;
    this.pixelData = ((DataBufferByte) img.getRaster()
            .getDataBuffer()).getData();
  }

  /**
   * gets the x coordinate.
   * @return xCoordinate
   */
  public int getxCoordinate() {

    return xCoordinate;
  }

  /**
   * gets the y coordinate.
   * @return yCoordinate
   */
  public int getyCoordinate() {

    return yCoordinate;
  }

  /**
   * gets the health.
   * @return health
   */
  public int getHealth() {

    return health;
  }

  /**
   * gets the gravity.
   * @return gravity
   */
  public float getGravity() {

    return gravity;
  }

  /**
   * gets the weapons.
   * @return weapons
   */
  public List<String> getWeapons() {

    return weapons;
  }

  /**
   * gets the image.
   * @return pixelData
   */
  public byte[] getPixelData() {

    return pixelData;
  }

  /**
   * shows the string representation of the data of the Sprite object.
   * @return String representation
   */
  @Override
  public String toString() {
    return "Sprite{" + "xCoordinate="
            + xCoordinate + ", yCoordinate="
            + yCoordinate + ", health="
            + health + ", gravity="
            + gravity + ", weapons="
            + weapons + ", pixelData="
            + Arrays.toString(pixelData) + '}';
  }
}
