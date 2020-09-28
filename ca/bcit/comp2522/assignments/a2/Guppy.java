package ca.bcit.comp2522.assignments.a2;

import java.util.Objects;
import java.util.ArrayList;
import java.util.Random;

/**
 * creates guppy objects with instance variables, constructors, and methods.
 *
 * @author Jieun Yu
 * @version 2020
 */
public class Guppy {

  /**
   * young fish age in weeks.
   */
  public static final int YOUNG_FISH_AGE_IN_WEEKS = 10;
  /**
   * mature fish age in weeks.
   */
  public static final int MATURE_FISH_AGE_IN_WEEKS = 30;
  /**
   * maximum age in weeks.
   */
  public static final int MAXIMUM_AGE_IN_WEEKS = 50;
  /**
   * minimum water volume in ml.
   */
  public static final double MINIMUM_WATER_VOLUME_ML = 250.0;
  /**
   * default genus name.
   */
  public static final String DEFAULT_GENUS = "Poecilia";
  /**
   * default species.
   */
  public static final String DEFAULT_SPECIES = "reticulata";
  /**
   * default health coefficient.
   */
  public static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;
  /**
   * minimum health coefficient.
   */
  public static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;
  /**
   * maximum health coefficient.
   */
  public static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;

  /** genus. */
  private final String genus;
  /** species. */
  private final String species;
  /** age in weeks. */
  private int ageInWeeks;
  /** if Guppy is female. */
  private final boolean isFemale;
  /** generation number. */
  private final int generationNumber;
  /** if guppy is alive. */
  private boolean isAlive;
  /** health coefficient. */
  private double healthCoefficient;
  /** identification number. */
  private final int identificationNumber;
  /** number of guppies born. */
  private static int numberOfGuppiesBorn = 0;

  /**
   * to construct initial information for a new Guppy born
   * if no information is given (nothing has passed),
   * default value will be given.
   */
  public Guppy() {

    ageInWeeks = 0;
    generationNumber = 0;
    genus = DEFAULT_GENUS;
    species = DEFAULT_SPECIES;
    isFemale = true;
    isAlive = true;
    healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
    numberOfGuppiesBorn++;
    identificationNumber = numberOfGuppiesBorn;

  }

  /**
   * to construct initial information for a new Guppy born.
   * the values passed are stored in a new Guppy object.
   *
   * @param newGenus             genus of Guppy
   * @param newSpecies           species of Guppy
   * @param newAgeInWeeks        age of Guppy in the measurement of weeks
   * @param newIsFemale          returns true by default
   * @param newGenerationNumber  int unique identification number
   *                             for each Guppy born
   * @param newHealthCoefficient double health coefficient number
   */
  public Guppy(final String newGenus, final String newSpecies,
               final int newAgeInWeeks, final boolean newIsFemale,
               final int newGenerationNumber,
               final double newHealthCoefficient) {

    if (newGenus == null || newGenus.isEmpty() || newGenus.isBlank()) {

      throw new IllegalArgumentException("invalid");

    } else {

      this.genus = newGenus.strip().substring(0, 1).toUpperCase()
              + newGenus.strip().substring(1).toLowerCase();

    }

    if (newSpecies == null || newSpecies.isEmpty() || newSpecies.isBlank()) {

      throw new IllegalArgumentException("invalid");

    } else {

      this.species = newSpecies.strip().toLowerCase();

    }

    if (newAgeInWeeks < 0) {

      ageInWeeks = 0;
      throw new IllegalArgumentException("Invalid");

    } else if (newAgeInWeeks >= MAXIMUM_AGE_IN_WEEKS) {

      ageInWeeks = MAXIMUM_AGE_IN_WEEKS;
      throw new IllegalArgumentException("Invalid");

    } else {

      ageInWeeks = newAgeInWeeks;

    }

    isFemale = newIsFemale;

    if (newGenerationNumber < 0) {

      generationNumber = 1;
      throw new IllegalArgumentException("Invalid");

    } else {

      generationNumber = newGenerationNumber;

    }

    if (newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT) {

      healthCoefficient = MINIMUM_HEALTH_COEFFICIENT;
      throw new IllegalArgumentException("Invalid");

    } else if (newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {

      healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;

    } else {

      healthCoefficient = newHealthCoefficient;

    }

    isAlive = true;
    numberOfGuppiesBorn++;
    identificationNumber = numberOfGuppiesBorn;

  }

  /**
   * a method to increase age of Guppy.
   * if Guppy's age is bigger than the maximum age,
   * change the isAlive boolean to false.
   */
  public void incrementAge() {

    ageInWeeks++;

    if (ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {

      isAlive = false;

    }

  }

  /**
   * accessor for genus.
   *
   * @return genus String
   */
  public String getGenus() {

    return genus;

  }

  /**
   * accessor for species.
   *
   * @return species String
   */
  public String getSpecies() {

    return species;

  }

  /**
   * accessor for ageInWeeks.
   *
   * @return ageInWeeks int
   */
  public int getAgeInWeeks() {

    return ageInWeeks;

  }

  /**
   * accessor for isFemale.
   *
   * @return isFemale boolean
   */
  public boolean getIsFemale() {

    return isFemale;

  }

  /**
   * accessor for generation number.
   *
   * @return generationNumber int
   */
  public int getGenerationNumber() {

    return this.generationNumber;

  }

  /**
   * accessor for isAlive.
   *
   * @return isAlive boolean
   */
  public boolean getIsAlive() {

    return this.isAlive;

  }

  /**
   * accessor for health coefficient.
   *
   * @return healthCoefficient double
   */
  public double getHealthCoefficient() {

    return this.healthCoefficient;

  }

  /**
   * accessor for identification number.
   *
   * @return identificationNumber int
   */
  public int getIdentificationNumber() {

    return this.identificationNumber;

  }

  /**
   * accessor for number of guppies born.
   *
   * @return numberOfGuppiesBorn int
   */
  public static int getNumberOfGuppiesBorn() {

    return numberOfGuppiesBorn;

  }

  /**
   * to set the age of Guppy in weeks.
   *
   * @param age int
   */
  public void setAgeInWeeks(final int age) {

    if (age < 0 || age > MAXIMUM_AGE_IN_WEEKS) {
      return;
    }

    ageInWeeks = age;

  }

  /**
   * to set the life status of Guppy.
   *
   * @param status boolean
   */
  public void setIsAlive(final boolean status) {

    isAlive = status;

  }

  /**
   * to set health coefficient.
   * if the value passed exceeds the bounds, the value will be ignored.
   *
   * @param healthCoeff double
   */
  public void setHealthCoefficient(final double healthCoeff) {

    if (healthCoeff < MINIMUM_HEALTH_COEFFICIENT
            || healthCoeff > MAXIMUM_HEALTH_COEFFICIENT) {
      return;
    }

    this.healthCoefficient = healthCoeff;

  }

  /**
   * accessor for volume of water needed depending on
   * the age of guppy.
   *
   * @return double
   */
  public double getVolumeNeeded() {

    if (ageInWeeks < YOUNG_FISH_AGE_IN_WEEKS) {

      return MINIMUM_WATER_VOLUME_ML;

    } else if (ageInWeeks <= MATURE_FISH_AGE_IN_WEEKS) {

      return MINIMUM_WATER_VOLUME_ML * ageInWeeks / YOUNG_FISH_AGE_IN_WEEKS;

    } else if (MATURE_FISH_AGE_IN_WEEKS < ageInWeeks
            && ageInWeeks <= MAXIMUM_AGE_IN_WEEKS) {

      return MINIMUM_WATER_VOLUME_ML * 1.5;

    } else {

      return 0.0;

    }

  }

  /**
   * adds the value passed to health coefficient and
   * change the life status if Guppy's health coefficient
   * is less than or equal to the minimum health coefficient.
   *
   * @param delta double
   */
  public void changeHealthCoefficient(final double delta) {

    healthCoefficient += delta;

    if (healthCoefficient <= MINIMUM_HEALTH_COEFFICIENT) {

      healthCoefficient = 0.0;
      isAlive = false;

    }

    if (healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {

      healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;

    }

  }

  /**
   * toString method to print Guppy's information in String format.
   *
   * @return String value
   */
  @Override
  public String toString() {

    return "Genus: " + genus + "\tSpecies: " + species + "\tage(weeks): "
            + ageInWeeks + "\tfemale?: " + isFemale
            + "\tgeneration number: " + generationNumber
            + "\talive?: " + isAlive + "\thealth coefficient: "
            + healthCoefficient
            + "\tidentification number: "
            + identificationNumber;

  }

  /**
   * hashCode to prevent from grabbing different values.
   *
   * @return all the variables
   */
  @Override
  public int hashCode() {

    return Objects.hash(genus, species, ageInWeeks, isFemale, generationNumber,
            isAlive, healthCoefficient, identificationNumber);

  }

  /**
   * equals method to compare whether or not the Guppy's information matches
   * the object passed.
   *
   * @param o object
   * @return false
   */
  @Override
  public boolean equals(final Object o) {

    if (this == o) {

      return true;

    }

    if (o == null) {

      return false;

    }

    if (!(o instanceof Guppy)) {

      return false;

    }

    Guppy guppy = (Guppy) o;

    return getGenus().equals(guppy.getGenus())
            && getSpecies().equals(guppy.getSpecies())
            && getAgeInWeeks() == guppy.getAgeInWeeks()
            && getIsFemale() == guppy.getIsFemale()
            && getGenerationNumber() == guppy.getGenerationNumber()
            && Double.compare(getHealthCoefficient(),
            guppy.getHealthCoefficient()) == 0
            && getIdentificationNumber()
            == guppy.getIdentificationNumber();

  }

  /**
   * javadoc comments.
   *
   * @return babyGuppies
   */
  public ArrayList<Guppy> spawn() {

    if (!this.isFemale || (this.ageInWeeks > 0 && this.ageInWeeks <= 7)) {

      return null;

    } else {

      ArrayList<Guppy> babyGuppies = new ArrayList<Guppy>();
      Random random = new Random();
      double chance = random.nextDouble();

      if (chance <= 0.50) {

        Guppy femaleGuppy;
        int babies = random.nextInt(101);
        for (int i = 0; i < babies; i++) {

          Guppy baby = new Guppy();
          babyGuppies.add(baby);

        }

      }

      return babyGuppies;

    }

  }

}
