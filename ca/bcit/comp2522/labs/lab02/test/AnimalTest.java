package ca.bcit.comp2522.labs.lab02.test;

import ca.bcit.comp2522.labs.lab02.Cat;
import ca.bcit.comp2522.labs.lab02.Dog;
import ca.bcit.comp2522.labs.lab02.Aibo;
import ca.bcit.comp2522.labs.lab02.IncessantSpeakable;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class AnimalTest {

  /**
   * test if Cat is an instance of IncessantSpeakable.
   */
  @Test
  public void testIncessantSpeakableOfCat() {

    Cat c = new Cat();
    assertEquals(false, (c instanceof IncessantSpeakable));

  }

  /**
   * test if Dog is an instance of IncessantSpeakable.
   */
  @Test
  public void testIncessantSpeakableOfDog() {

    Dog d = new Dog();
    assertEquals(false, (d instanceof IncessantSpeakable));

  }

  /**
   * test if Ai bot is an instance of IncessantSpeakable.
   */
  @Test
  public void testIncessantSpeakableOfAibo() {

    Aibo ai = new Aibo();
    assertEquals(false, (ai instanceof IncessantSpeakable));

  }

  /**
   * test if Dog speaks "Woof woof!".
   */
  @Test
  public void testDogWoof() {
    Dog d = new Dog();
    assertEquals("Woof woof!", d.getSpeak());
  }

}


