package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

/**
 * a Hare class with a position and a method called 'move'
 * to modify the position.
 *
 * @author Jieun Yu
 * @version 2020
 */
public class Race {

    /**
     * length of the race.
     */
    int length;

    /**
     * number of iterations taken until there's a winner.
     */
    int clockTicks = 0;

    /**
     * number of wins Hare has.
     */
    int hareWins;

    /**
     * number of wins Tortoise has.
     */
    int tortoiseWins;

    /**
     * a Hare type object.
     */
    private final Hare hare;

    /**
     * a Tortoise type object.
     */
    private final Tortoise tortoise;

    /**
     * to construct a new race object with a length passed into.
     * @param length int.
     */
    public Race(int length) {
        this.length = length;
        hare = new Hare();
        tortoise = new Tortoise();
    }

    /**
     * to get a new object from the class Hare.
     * @return Hare.
     */
    public Hare getHare() {
        return this.hare;
    }

    /**
     * to get a new object from the class Tortoise.
     * @return Tortoise
     */
    public Tortoise getTortoise() {
        return this.tortoise;
    }

    /**
     * to reset the positions of the hare and Tortoise objects to 0.
     * to reset the clock ticks.
     */
    public void reset() {
        hare.setPosition(0);
        tortoise.setPosition(0);
        clockTicks = 0;
    }

    public int getHareWins() {
        return hareWins;
    }

    public int getTortoiseWins() {
        return tortoiseWins;
    }

    public int getClockTicks() {
        return clockTicks;
    }

    /**
     * to get the result of the race between Hare and Tortoise objects.
     * this method calls the reset method to start fresh so their positions are reset to 0.
     */
    public final String simulateRace() {
        reset();
        return race();
    }

    /**
     * to simulate the race between Hare and Tortoise objects.
     * @return "Hare" or "Tortoise" whoever the winner is printed.
     */
    private String race() {
        do {
            int[] runners = {0, 1};
            int rndPick = new Random().nextInt(runners.length);
            int runFirst = runners[rndPick];
            if(runFirst == 0) {
                hare.move();
                tortoise.move();
            } else {
                tortoise.move();
                hare.move();
            }
            clockTicks++;
        } while (hare.getPosition() < length && tortoise.getPosition() < length);

        if(hare.getPosition() >= length) {
            hareWins++;
            return "Hare";
        } else {
            tortoiseWins++;
            return "Tortoise";
        }
    }

}
