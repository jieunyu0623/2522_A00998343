package ca.bcit.comp2522.assignments.a2;

import java.util.*;

/**
 * creates a Pool object for guppies in Guppy.
 *
 * @author Jieun Yu
 * @version 2020
 */
public class Pool {

  /** default pool name. */
  public static final String DEFAULT_POOL_NAME = "Unnamed";
  /** default pool temperature in celsius. */
  public static final double DEFAULT_POOL_TEMP_CELSIUS = 40.0;
  /** minimum pool temperature in celsius. */
  public static final double MINIMUM_POOL_TEMP_CELSIUS = 0.0;
  /**  maximum pool temperature in celsius. */
  public static final double MAXIMUM_POOL_TEMP_CELSIUS = 100.0;
  /** neutral ph level. */
  public static final double NEUTRAL_PH = 7.0;
  /** default nutrient coefficient. */
  public static final double DEFAULT_NUTRIENT_COEFFICIENT = 0.50;
  /** minimum nutrient coefficient. */
  public static final double MINIMUM_NUTRIENT_COEFFICIENT = 0.0;
  /** maximum nutrient coefficient. */
  public static final double MAXIMUM_NUTRIENT_COEFFICIENT = 1.0;
  /** minimum ph level. */
  public static final double MINIMUM_PH = 0;
  /** maximum ph level. */
  public static final double MAXIMUM_PH = 14.0;
  /** mili litre to litre. */
  public static final double LITRE = 0.001;


  /** name. */
  private final String name;
  /** volume in liter. */
  private double volumeLitres;
  /** temperature in celsius. */
  private double temperatureCelsius;
  /** ph level. */
  private double pH;
  /** nutrient coefficient. */
  private double nutrientCoefficient;
  /** identification number. */
  private final int identificationNumber;
  /** guppies in pool. */
  private final ArrayList<Guppy> guppiesInPool;
  /** random number generator. */
  private Random randomNumberGenerator;
  /** number of pools. */
  private static int numberOfPools = 0;

  /**
   * constructs guppy objects with default values.
   * when nothing passes to the constructor.
   */
  public Pool() {

    this.volumeLitres = 0.0;
    this.name = DEFAULT_POOL_NAME;
    this.pH = NEUTRAL_PH;
    this.nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
    this.temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;
    this.guppiesInPool = new ArrayList<>();
    this.randomNumberGenerator = new Random();
    this.identificationNumber = ++numberOfPools;

  }

  /**
   * constructs a guppy object with values passed.
   *
   * @param names String
   * @param volumeLitre double
   * @param temperature double
   * @param pHs double
   * @param nutrientCoeff double
   */
  public Pool(final String names, final double volumeLitre,
              final double temperature,
              final double pHs, final double nutrientCoeff) {

    if (names.isEmpty() || names == null || names.isBlank()) {

      throw new IllegalArgumentException("Not Valid");

    } else {

      this.name = names.strip().substring(0, 1).toUpperCase()
              + names.strip().substring(1).toLowerCase();

    }

    if (volumeLitre > 0.0) {

      this.volumeLitres = volumeLitre;

    } else {

      this.volumeLitres = 0.0;

    }

    if (temperatureCelsius <= MINIMUM_POOL_TEMP_CELSIUS
            || temperatureCelsius >= MAXIMUM_POOL_TEMP_CELSIUS) {

      this.temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;

    } else {

      this.temperatureCelsius = temperature;

    }

    if (pHs < MINIMUM_PH || pHs >= MAXIMUM_PH) {

      this.pH = NEUTRAL_PH;

    } else {

      this.pH = pHs;

    }

    if (nutrientCoefficient <= MINIMUM_NUTRIENT_COEFFICIENT
            || nutrientCoefficient >= MAXIMUM_NUTRIENT_COEFFICIENT) {

      this.nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;

    } else {

      this.nutrientCoefficient = nutrientCoeff;

    }

    this.guppiesInPool = new ArrayList<>();
    this.randomNumberGenerator = new Random();
    this.identificationNumber = ++numberOfPools;

  }

  /**
   * access the name instance.
   *
   * @return name
   */
  public String getName() {

    return name;

  }

  /**
   * access the volumeLitres instance.
   *
   * @return volumeLitres
   */
  public double getVolumeLitres() {

    return volumeLitres;

  }

  /**
   * access the temperatureCelsius instance.
   *
   * @return temperatureCelsius
   */
  public double getTemperatureCelsius() {

    return temperatureCelsius;

  }

  /**
   * access the pH instance.
   *
   * @return pH
   */
  public double getPH() {

    return pH;

  }

  /**
   * access the nutrientCoefficient instance.
   *
   * @return nutrientCoefficient
   */
  public double getNutrientCoefficient() {

    return nutrientCoefficient;

  }

  /**
   * access the identificationNumber instance.
   *
   * @return identificationNumber
   */
  public int getIdentificationNumber() {

    return identificationNumber;

  }

  /**
   * set the volumeLitres instance.
   *
   * @param volumeLitre double
   */
  public void setVolumeLitres(final double volumeLitre) {

    if (volumeLitre < 0) {

      this.volumeLitres = 0.0;

    } else {

      this.volumeLitres = volumeLitre;

    }

  }

  /**
   * set the temperatureCelsius instance.
   *
   * @param temperature double
   */
  public void setTemperatureCelsius(final double temperature) {

    if (temperature >= MINIMUM_POOL_TEMP_CELSIUS
            && temperature <= MAXIMUM_POOL_TEMP_CELSIUS) {

      this.temperatureCelsius = temperature;

    } else {

      this.temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;

      }
  }

  /**
   * set the pH variable.
   *
   * @param pHs double
   */
  public void setPH(final double pHs) {

    if (MINIMUM_PH <= pHs && pHs <= MAXIMUM_PH) {

      this.pH = pHs;

    } else {

      this.pH = NEUTRAL_PH;

    }

  }

  /**
   * set the nutrientCoefficient variable.
   *
   * @param nutrientCoeff double
   */
  public void setNutrientCoefficient(final double nutrientCoeff) {

    if (MINIMUM_NUTRIENT_COEFFICIENT <= nutrientCoeff
            && nutrientCoeff <= MAXIMUM_NUTRIENT_COEFFICIENT) {

      this.nutrientCoefficient = nutrientCoeff;

    } else {

      this.nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;

    }

  }

  /**
   * adds delta to nutrient coefficient. if the value is less than
   * minimum value or higher than maximum value, then return the
   * closest value.
   *
   * @param delta double
   */
  public void changeNutrientCoefficient(final double delta) {

    this.nutrientCoefficient += delta;
    if (nutrientCoefficient <= MINIMUM_NUTRIENT_COEFFICIENT) {

      this.nutrientCoefficient = MINIMUM_NUTRIENT_COEFFICIENT;

    } else if (nutrientCoefficient >= MAXIMUM_NUTRIENT_COEFFICIENT) {

      this.nutrientCoefficient = MAXIMUM_NUTRIENT_COEFFICIENT;

    }

  }

  /**
   * adds delta to temperature of the Pool.
   * if the value is less than minimum value or higher than
   * maximum value, then return the closest value.
   *
   * @param delta double
   */
  public void changeTemperature(final double delta) {

    this.temperatureCelsius += delta;
    if (temperatureCelsius <= MINIMUM_NUTRIENT_COEFFICIENT) {

      this.temperatureCelsius = MINIMUM_POOL_TEMP_CELSIUS;

    } else if (temperatureCelsius >= MAXIMUM_NUTRIENT_COEFFICIENT) {

      this.temperatureCelsius = MAXIMUM_POOL_TEMP_CELSIUS;

    }

  }

  /**
   * gets the number of pools created.
   *
   * @return numberOfPools int
   */
  public static int getNumberCreated() {

    return numberOfPools;

  }

  /**
   * adds a guppy to the pool. if the guppy is
   * successfully added, it returns true. if null,
   * it returns false.
   *
   * @param guppy Guppy
   * @return true false
   */
  public boolean addGuppy(final Guppy guppy) {

    if (guppy == null) {

      return false;

    } else {

      guppiesInPool.add(guppy);
      return true;

    }

  }

  /**
   * gets the number of living guppies in the pool.
   *
   * @return guppiesAlive
   */
  public int getPopulation() {

    int guppiesAlive = 0;
    for (Guppy guppy : guppiesInPool) {

      if (guppy.getIsAlive()) {

        guppiesAlive++;

      }

    }

    return guppiesAlive;

  }

  /**
   * shows the number of guppies dead due to malnutrition
   * after applying the nutrient coefficient.
   *
   * @return dead
   */
  public int applyNutrientCoefficient() {

    int dead = 0;
    final Iterator<Guppy> guppies = guppiesInPool.iterator();

    while (guppies.hasNext()) {

      Guppy guppy = guppies.next();
      randomNumberGenerator = new Random();
      double nutrient = randomNumberGenerator.nextDouble();

      if (nutrient > this.nutrientCoefficient && guppy.getIsAlive()) {

        guppy.setIsAlive(false);
        dead++;

      }

    }

    return dead;

  }

  /**
   * removes dead guppies from the pool.
   *
   * @return dead
   */
  public int removeDeadGuppies() {

    int dead = 0;
    Iterator<Guppy> guppies = guppiesInPool.iterator();

    while (guppies.hasNext()) {

      final Guppy guppy = guppies.next();
      if (!guppy.getIsAlive()) {

        guppies.remove();
        dead++;

      }

    }

    return dead;

  }

  /**
   * gets the amount of water needed for pool in litre.
   * converts mililitre to litre.
   *
   * @return volumeRequired
   */
  public double getGuppyVolumeRequirementInLitres() {

    double volumeRequired = 0.0;
    for (final Guppy guppies: guppiesInPool) {

      if (guppies.getIsAlive()) {

        volumeRequired += guppies.getVolumeNeeded();

      }

    }

    volumeRequired *= LITRE;
    return volumeRequired;

  }

  /**
   * gets the total age of guppies in pool.
   *
   * @return ageInTotal / count
   */
  public double getAverageAgeInWeeks() {

    double ageInTotal = 0.0;
    double count = 0.0;
    for (final Guppy guppy : guppiesInPool) {

        if (guppy.getIsAlive()) {

          ageInTotal += guppy.getAgeInWeeks();
          count++;

        }

      }


    if (ageInTotal == 0.0 || count == 0.0) {

      return 0.0;

    }

    return ageInTotal / count;

  }

  /**
   * gets the average health coefficient of
   * the guppies in the Pool.
   *
   * @return avgCoefficient / count
   */
  public double getAverageHealthCoefficient() {

    double avgCoefficient = 0.0;
    int count = 0;

    for (Guppy guppies : guppiesInPool) {

      if (guppies.getIsAlive()) {

        avgCoefficient += guppies.getHealthCoefficient();
        count++;

      }

      if (count == 0 || avgCoefficient == 0) {

        return 0.0;

      }

    }

    return avgCoefficient / count;

  }

  /**
   * gets the percentage of female guppies out of all guppies.
   *
   * @return femaleTotal / totalCount
   */
  public double getFemalePercentage() {

    double totalCount = 0;
    double femaleTotal = 0;
    for (final Guppy guppies: guppiesInPool) {

      if (guppies.getIsAlive()) {

        totalCount++;

        if (guppies.getIsFemale()) {

          femaleTotal++;

        }

      }

    }

    if (femaleTotal == 0 || totalCount == 0) {

      return 0.0;

    }

    return femaleTotal / totalCount;

  }

  /**
   * gets the median age of guppies in Pool.
   *
   * @return median
   */
  public double getMedianAge() {

    int count = 0;
    for (Guppy guppies: guppiesInPool) {

      if (guppies.getIsAlive()) {

        count++;

      }

    }

    int[] ages = new int[count];

    for (int i = 0; i < guppiesInPool.size(); i++) {

      Guppy guppies = new Guppy();
      ages[i] = guppies.getAgeInWeeks();

    }

    double median = 0.0;
    Arrays.sort(ages);
    if (ages.length % 2 == 0) {

      median = (ages[ages.length / 2] + ages[(ages.length / 2) - 1]) / 2;

    } else {

      median = ages[ages.length / 2];

    }

    return median;

  }

  /**
   * shows all the data in the Pool in String.
   *
   * @return String representation of the Pool.
   */
  @Override
  public String toString() {

    return "Pool{" + "name='" + name + '\'' + ", volumeLitres=" + volumeLitres
            + ", temperatureCelsius=" + temperatureCelsius + ", pH=" + pH
            + ", nutrientCoefficient=" + nutrientCoefficient
            + ", identificationNumber=" + identificationNumber
            + ", guppiesInPool=" + guppiesInPool
            + ", randomNumberGenerator=" + randomNumberGenerator + '}';
  }

  /**
   * spawns new guppies born to pool.
   *
   * @return addedBabies
   */
  public int spawn() {

    int addedBabies = 0;
    final ArrayList<Guppy> newBabiesArrayList = new ArrayList<>();

    for (final Guppy currentGuppy : guppiesInPool) {

      final ArrayList<Guppy> newBabies = currentGuppy.spawn();

      if (newBabies != null) {

        newBabiesArrayList.addAll(newBabies);

      }

    }

    addedBabies += newBabiesArrayList.size();
    guppiesInPool.addAll(newBabiesArrayList);

    return addedBabies;

  }

  /**
   * increases age of guppies.
   * remove guppies that died of old age.
   *
   * @return deadGuppies
   */
  public int incrementAges() {

    int deadGuppies = 0;
    for (final Guppy guppies : guppiesInPool) {

      guppies.incrementAge();

      if (!guppies.getIsAlive()) {

        deadGuppies++;

      }

    }

    return deadGuppies;

  }

  /**
   * kills weak guppies if the water volume exceeds the volume needed
   * until the water volume reduces to the volume needed.
   *
   * @return crowded
   */
  public int adjustForCrowding() {

    guppiesInPool.sort(Comparator.comparingDouble(Guppy::getHealthCoefficient));
    int crowded = 0;
    final Iterator<Guppy> guppies = guppiesInPool.iterator();
    double volumeNeeded = this.getGuppyVolumeRequirementInLitres();
    while (volumeNeeded > volumeLitres && guppies.hasNext()) {

      Guppy weakGuppy = guppies.next();
      if (weakGuppy.getIsAlive()) {

        volumeNeeded -= weakGuppy.getVolumeNeeded() * LITRE;
        weakGuppy.setIsAlive(false);
        crowded++;

      }

    }

    return crowded;

  }

  /**
   * checks if the object passed is the same object
   * and the same data type.
   *
   * @param o Object
   * @return true false
   */
  @Override
  public boolean equals(final Object o) {

    if (this == o) {

      return true;

    }

    if (o == null || getClass() != o.getClass()) {

      return false;

    }

    final Pool pool = (Pool) o;
    return Double.compare(pool.volumeLitres, volumeLitres) == 0
            && Double.compare(pool.temperatureCelsius, temperatureCelsius) == 0
            && Double.compare(pool.pH, pH) == 0
            && Double.compare(pool.nutrientCoefficient,
            nutrientCoefficient) == 0
            && identificationNumber == pool.identificationNumber
            && Objects.equals(name, pool.name)
            && Objects.equals(guppiesInPool, pool.guppiesInPool)
            && Objects.equals(randomNumberGenerator,
            pool.randomNumberGenerator);
  }

  /**
   * creates hashcode for object.
   *
   * @return hashcode for object.
   */
  @Override
  public int hashCode() {

    return Objects.hash(name, volumeLitres, temperatureCelsius,
            pH, nutrientCoefficient, identificationNumber,
            guppiesInPool, randomNumberGenerator);

  }

}
