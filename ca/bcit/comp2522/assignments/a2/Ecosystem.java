package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * creates an Ecosystem of multiple Pools.
 *
 * @author Jieun Yu
 * @version 2020
 */
public class Ecosystem {

  /** multiple pools. */
  private final ArrayList<Pool> pools;
  /** current week. */
  private int currentWeek = 1;

  /**
   * constructs the collection of Pools.
   */
  public Ecosystem() {

    this.pools = new ArrayList<>();

  }

  /**
   * adds the Pool passed to the collection of Pools.
   *
   * @param newPool Pool
   */
  public void addPool(final Pool newPool) {

    if (newPool != null) {

      pools.add(newPool);

    }

  }

  /**
   * clears all the pools in Pools.
   */
  public void reset() {

    pools.clear();

  }

  /**
   * gets the total number of guppies in all pools
   * in the Pool collection.
   *
   * @return totalPopulation
   */
  public int getGuppyPopulation() {

    int totalPopulation = 0;
    for (final Pool currentPool : pools) {

      totalPopulation += currentPool.getPopulation();

    }

    return totalPopulation;

  }

  /**
   * adjusts for crowding guppies in each pool.
   * over-populated guppies are killed (crowded guppies).
   *
   * @return crowdedGuppies
   */
  public int adjustForCrowding() {

    int crowdedGuppies = 0;
    for (final Pool currentPool : pools) {

      crowdedGuppies += currentPool.adjustForCrowding();

    }

    return crowdedGuppies;

  }

  /**
   * creates ecosystem with three pools.
   */
  @SuppressWarnings("checkstyle:LocalFinalVariableName")
  public void setupSimulation() {

    final Pool Skookumchuk = new Pool("Skookumchuk", 3000.0,
            42.0, 7.9, 0.9);
    final Pool Squamish = new Pool("Squamish", 15000.0,
            39.0, 7.7, 0.85);
    final Pool Semiahmoo = new Pool("Semiahmoo", 4500.0,
            37.0, 7.5, 1.0);

    guppySimulator(Skookumchuk, 300, 10, 25, 0.5, 0.8, 0.75);
    guppySimulator(Squamish, 100, 10, 15, 0.8, 1.0, 0.75);
    guppySimulator(Semiahmoo, 200, 15, 49, 0.0, 1.0, 0.35);

    addPool(Skookumchuk);
    addPool(Squamish);
    addPool(Semiahmoo);

  }

  private void guppySimulator(final Pool pool, final int guppyCount,
                              final int ageMin, final int ageMax,
                              final double healthCoefficientMin,
                              final double healthCoefficientMax,
                              final double femalePercent) {

    Random random = new Random();
    boolean isFemale = false;

    for (int i = 0; i < guppyCount; i++) {

      int randomAge = random.nextInt(ageMax - ageMin + 1) + ageMin;
      double randomHealthCoefficient = random.nextDouble()
              * (healthCoefficientMax - healthCoefficientMin)
              + healthCoefficientMin;
      double randomFemaleChance = random.nextDouble();

      if (randomFemaleChance <= femalePercent) {

        isFemale = true;

      }

      Guppy guppy = new Guppy("Poecilia", "reticulata",
              randomAge, isFemale, 1, randomHealthCoefficient);
      pool.addGuppy(guppy);
      isFemale = false;

    }

  }

  /**
   * simulates the ecosystem for
   * number of weeks passed as a parameter.
   *
   * @param numberOfWeeks int
   */
  public void simulate(final int numberOfWeeks) {

    setupSimulation();

    for (int i = 0; i < numberOfWeeks; i++) {

      simulateOneWeek();

    }

  }

  /**
   * simulates one week of ecosystem.
   * prints number of guppies died of old age,
   * starvation or overpopulation, number of guppies removed,
   * number of new-born guppies,
   * population in each pool and in total.
   */
  public void simulateOneWeek() {

    int diedOfOldAge = 0;
    int numberRemoved = 0;
    int starvedToDeath = 0;
    int newFry = 0;
    int crowdedOut = 0;
    ArrayList<String> poolNames = new ArrayList<>();
    ArrayList<Integer> poolPopulations = new ArrayList<>();

    for (final Pool pool : pools) {

      diedOfOldAge += pool.incrementAges();
      numberRemoved += pool.removeDeadGuppies();
      starvedToDeath += pool.applyNutrientCoefficient();
      numberRemoved += pool.removeDeadGuppies();
      newFry += pool.spawn();
      crowdedOut += pool.adjustForCrowding();
      numberRemoved += pool.removeDeadGuppies();

      if (!poolNames.contains(pool.getName())) {

        poolNames.add(pool.getName());

      }

      if (!poolPopulations.contains(pool.getPopulation())) {

        poolPopulations.add(pool.getPopulation());

      }

    }

    if (diedOfOldAge + starvedToDeath + crowdedOut != numberRemoved) {

      System.out.println("Logic error");

    } else {

      System.out.println("Week: " + currentWeek
              + "\nNumber of deaths due to old age: " + diedOfOldAge
              + "\nNumber of deaths due to starvation: " + starvedToDeath
              + "\nNumber of deaths due to overcrowding: " + crowdedOut
              + "\nNumber of births: " + newFry
              + "\nPool Names: " + poolNames
              + "\nPopulation for each pool: " + poolPopulations
              + "\nTotal ecosystem population: " + getGuppyPopulation());

      currentWeek++;

    }

  }


  /**
   * returns all instances in String.
   *
   * @return String representation of all instances
   */
    @Override
    public String toString() {

      return "Ecosystem{" + "pools=" + pools
              + ", currentWeek=" + currentWeek
              + '\'' + '}';

    }

  /**
   * checks if the object passed is not null
   * and the same object and same type.
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

      Ecosystem ecosystem = (Ecosystem) o;
      return currentWeek == ecosystem.currentWeek
              && Objects.equals(pools, ecosystem.pools);

    }

  /**
   * creates hashcode for the object.
   *
   * @return hashcode for the object.
   */
  @Override
    public int hashCode() {

      return Objects.hash(pools, currentWeek);

    }

  }

