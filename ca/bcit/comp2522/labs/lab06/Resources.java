package ca.bcit.comp2522.labs.lab06;

/**
 * the Resources class.
 * @author Jieun Yu
 * @version 2020
 */
public class Resources {

  /** level name. */
  private final String levelName;

  /** level. */
  private final int level;

  /** x coordinate. */
  private final int xCoordinate;

  /** y coordinate. */
  private final int yCoordinate;

  /** player health. */
  private final float playerHealth;

  /** number of enemies remaining. */
  private final int enemiesAlive;

  /**
   * constructs an Recources object.
   * @param n String
   * @param lev int
   * @param xCoord int
   * @param yCoord int
   * @param ph float
   * @param ea int
   */
  public Resources(final String n, final int lev, final int xCoord,
                   final int yCoord, final float ph, final int ea) {

    this.levelName = n;
    this.level = lev;
    this.xCoordinate = xCoord;
    this.yCoordinate = yCoord;
    this.playerHealth = ph;
    this.enemiesAlive = ea;
  }

  /**
   * gets the level name.
   * @return levelName
   */
  public String getLevelName() {

    return levelName;
  }

  /**
   * gets the level.
   * @return level
   */
  public int getLevel() {

    return level;
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
   * gets the player health.
   * @return playerHealth
   */
  public float getPlayerHealth() {

    return playerHealth;
  }

  /**
   * gets the number of the enemies alive.
   * @return enemiesAlive
   */
  public int getEnemiesAlive() {

    return enemiesAlive;
  }

}
