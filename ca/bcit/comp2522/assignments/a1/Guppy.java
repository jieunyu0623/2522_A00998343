package ca.bcit.comp2522.assignments.a1;

import java.util.Objects;

public class Guppy {

  public static final int YOUNG_FISH_AGE_IN_WEEKS = 10;
  public static final int MATURE_FISH_AGE_IN_WEEKS = 30;
  public static final int MAXIMUM_AGE_IN_WEEKS = 50;
  public static final double MINIMUM_WATER_VOLUME_ML = 250.0;
  public static final String DEFAULT_GENUS = "Poecilia";
  public static final String DEFAULT_SPECIES = "reticulata";
  public static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;
  public static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;
  public static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;

  private final String genus;
  private final String species;
  private int ageInWeeks;
  private final boolean isFemale;
  private final int generationNumber;
  private boolean isAlive;
  private double healthCoefficient;
  private final int identificationNumber;
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
   * @param newGenus genus of Guppy
   * @param newSpecies species of Guppy
   * @param newAgeInWeeks age of Guppy in the measurement of weeks
   * @param newIsFemale returns true by default
   * @param newGenerationNumber int unique identification number for each Guppy born
   * @param newHealthCoefficient double health coefficient number
   */
  public Guppy(String newGenus, String newSpecies, int newAgeInWeeks,
               boolean newIsFemale, int newGenerationNumber, double newHealthCoefficient) {

    newGenus = newGenus.substring(0, 1).toUpperCase()
            + newGenus.substring(1, newGenus.length() - 1).toLowerCase();

    genus = newGenus;
    newSpecies = newSpecies.toLowerCase();
    species = newSpecies;

    if (newAgeInWeeks < 0) {

      newAgeInWeeks = 0;

    }

    ageInWeeks = newAgeInWeeks;
    isFemale = newIsFemale;

    if (newGenerationNumber < 0) {

      newGenerationNumber = 1;

    }

    generationNumber = newGenerationNumber;

    if (newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT) {

      newHealthCoefficient = MINIMUM_HEALTH_COEFFICIENT;

    } else if (newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {

      newHealthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;

    }

    healthCoefficient = newHealthCoefficient;
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

    return generationNumber;

  }

  /**
   * accessor for isAlive.
   *
   * @return isAlive boolean
   */
  public boolean getIsAlive() {

    return isAlive;

  }

  /**
   * accessor for health coefficient.
   *
   * @return healthCoefficient double
   */
  public double getHealthCoefficient() {

    return healthCoefficient;

  }

  /**
   * accessor for identification number.
   *
   * @return identificationNumber int
   */
  public int getIdentificationNumber() {

    return identificationNumber;

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
  public void setAgeInWeeks(int age) {

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
  public void setIsAlive(boolean status) {

    isAlive = status;

  }

  /**
   * to set health coefficient.
   * if the value passed exceeds the bounds, the value will be ignored.
   *
   * @param healthCoefficient double
   */
  public void setHealthCoefficient(double healthCoefficient) {

    if (healthCoefficient < MINIMUM_HEALTH_COEFFICIENT
            || healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
      return;
    }

    this.healthCoefficient = healthCoefficient;

  }

  /**
   * accessor for volume of water needed depending on
   * the age of guppy.
   *
   * @return double
   */
  public double getVolumeNeeded() {

    if (ageInWeeks < 10) {

      return MINIMUM_WATER_VOLUME_ML;

    } else if (ageInWeeks <= 30) {

      return MINIMUM_WATER_VOLUME_ML * ageInWeeks / YOUNG_FISH_AGE_IN_WEEKS;

    } else if (31 < ageInWeeks && ageInWeeks <= 50) {

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
  public void changeHealthCoefficient(double delta) {

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

    return "Genus: " + genus + "\tSpecies: " + species + "\tage(weeks): " + ageInWeeks
            + "\tfemale?: " + isFemale + "\tgeneration number: " + generationNumber
            + "\talive?: " + isAlive + "\thealth coefficient: " + healthCoefficient
            + "\tidentification number: " + identificationNumber;

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
  public boolean equals(Object o) {

    if (this == o) {

      return true;

    }

    if (o == null) {

      return false;

    }

    if (!(o.getClass() == this.getClass())) {

      return false;

    }

    return false;

  }

}
