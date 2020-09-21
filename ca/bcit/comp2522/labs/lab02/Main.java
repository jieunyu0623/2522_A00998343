package ca.bcit.comp2522.labs.lab02;

public final class Main {

    /**
     * 1. because java doesn't allow us to extend more than one class,
     * but java allows us to implement multiple interfaces in a class.
     * In addition, we can securely implement without bothering about the
     * implementation part.
     * 2. because the id inside the robot class is
     * unique for each robot object created.
     * 3. those four classes are all child classes (sub classes)of Animal class.
     */
    private Main() { }

    public static void main(final String[] args) {
        // write your code here

        // no animals were hurt during testing
        Cat c1 = new Cat();
        Cat c2 = new Cat();
        Cat c3 = new Cat();
        Dog d1 = new Dog();
        Dog d2 = new Dog();
        Poodle d3 = new Poodle();

        Aibo r1 = new Aibo();
        Aibo r2 = new Aibo();

        Speakable[] speakingThings = new Speakable[8];

        speakingThings[0] = c1;
        speakingThings[1] = c2;
        speakingThings[2] = c3;
        speakingThings[3] = d1;
        speakingThings[4] = d2;
        speakingThings[5] = d3;
        speakingThings[6] = r1;
        speakingThings[7] = r2;

        for (int i = 0; i < speakingThings.length; i++) {
            speakingThings[i].speak();
            System.out.println(speakingThings[i].getClass());
            System.out.println("is speakable: " + (speakingThings[i]
                    instanceof Speakable));
            System.out.println("is LOUDspeakable: " + (speakingThings[i]
                    instanceof IncessantSpeakable));
        }
    }
}
