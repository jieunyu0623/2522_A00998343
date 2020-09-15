package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

/**
 * Hare class with a position and a method called 'move'
 * to modify the position.
 *
 * @author Jieun Yu
 * @version 2020
 */
public class Hare {

    /**
     * this is a position where Hare locates.
     * Initial position is set to 0.
     */
    private int position = 0;

    /**
     * to get a random movements that will be made for Hare.
     *
     * @return position
     */
    public int move() {
        int movement;
        movement = getRandom();
        position += movement;
        return position;
    }

    /**
     * setter (mutator) for position.
     * @param position int
     */
    public void setPosition(int position) {
     this.position = position;
    }

    /**
     * getter (accessor) for position.
     * @return position
     */
    public int getPosition() {
        return position;
    }

    /**
     * to get a random movement that will be made for Hare.
     * An array is given for random moves.
     * @return array[rand]
     */
    public static int getRandom() {
        int[] array = {0, 0, 9, -12, 1, 1, 1, -2, -2, -2}; //20%, 10%, 10%, 30% and 30% for each move made sequentially.
        int rand = new Random().nextInt(array.length);
        return array[rand];
    }

    /**
     * toString method to convert the data type for 'position' from integer into String.
     * @return String
     */
    @Override
    public String toString() {
        return "Hare is now positioned at " + position;
    }

    /**
     * equals method to check if the position inputted and the position Hare actually moved ar the same.
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Hare)) {
            return false;
        }
        Hare hare = (Hare) o;
        return getPosition() == hare.getPosition();
    }
}
