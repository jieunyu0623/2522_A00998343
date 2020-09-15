package ca.bcit.comp2522.labs.lab01;

/**
 * test driver to test out the races between Hare and Tortoise in the main method.
 * Tortoise wins more than Hare.
 *
 * @author Jieun Yu
 * @version 2020
 */
public class Driver {

    /**
     * number of races.
     */
    private static final int NUM_RACE100 = 100;

    /**
     * race length 100.
     */
    private static final int RACE_LENGTH100 = 100;

    /**
     * race length 1000.
     */
    private static final int RACE_LENGTH1000 = 1000;

    /**
     * to simulate multiple races between Hare and Tortoise objects.
     * @param numOfRace int
     * @param lengthOfRace int
     * @return how many wins Hare and Tortoise have in String format.
     */
    public static String simulateRaces(int numOfRace, int lengthOfRace) {
        Race race = new Race(lengthOfRace);
        for (int i = 0; i < numOfRace; i++) {
            race.simulateRace();
            race.clockTicks++;
        }
        return "Hare won " + race.getHareWins() + "times and Tortoise won "
                + race.getTortoiseWins() + "times.\nclock ticks: " + race.getClockTicks()
                + "\nfinal position(Hare): " + race.getTortoise().getPosition()
                + "\nfinal position(Tortoise): " + race.getHare().getPosition();
    }

    /**
     * to simulate the races between Hare and Tortoise.
     * @param args not used.
     */
    public static void main(String[] args) {

        //using race class method
        Race race = new Race(NUM_RACE100); // for each race record
        String result = race.simulateRace(); //result or each race
        if (result.equals("Tortoise")) {
            result = result + " wins in " + race.getClockTicks()
                    + " clock ticks at position " + race.getTortoise().getPosition()
                    + "\nHare was at position: " + race.getHare().getPosition();
        } else {
            result = result + " wins in " + race.getClockTicks()
                    + " clock ticks at position " + race.getHare().getPosition()
                    + "\nTortoise was at position: " + race.getTortoise().getPosition();
        }

        //using static method
        String races100 = simulateRaces(RACE_LENGTH100, NUM_RACE100);
        String races1000 = simulateRaces(RACE_LENGTH1000, NUM_RACE100);

        System.out.println(result);
        System.out.println(races100);
        System.out.println(races1000);
    }

}
