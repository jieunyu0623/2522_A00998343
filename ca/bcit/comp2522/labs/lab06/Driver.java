package ca.bcit.comp2522.labs.lab06;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * the Driver class to create a file and read
 * the file and write the same content
 * into a new file with current date printed
 * as the title and print the result to
 * the console.
 * @author Jieun Yu
 * @version 2020
 */
public class Driver {

  /**
   * the main class.
   * @param args unused.
   */
  public static void main(final String[] args) {

    try {

      List<String> weapons = new ArrayList<>();
      weapons.add("AUG");
      weapons.add("M416");
      weapons.add("SCAR-L");

      BufferedImage img = ImageIO.read(new File("uzuhama.jpg"));
      Sprite sprite = new Sprite(5, 3,
              50, 9.8f, weapons, img);

      //create ser file
      FileOutputStream f = new FileOutputStream("sprite.ser");
      ObjectOutput out = new ObjectOutputStream(f);
      out.writeObject(sprite);
      out.flush();
      out.close();

      FileInputStream f2 = new FileInputStream("sprite.ser");
      ObjectInputStream in = new ObjectInputStream(f2);
      Sprite s1 = (Sprite) in.readObject();
      in.close();

      //grabbing x coordinate, y coordinate, health from the previous data and
      //add more info such as level name, level and enemies remaining
      Resources resource = new Resources("Uzu Hama", 2,
              s1.getxCoordinate(), s1.getyCoordinate(),
              s1.getHealth(), 5);

      DataOutputStream out2 = null;

      //Get the current time using date time formatter
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern(
              "yyyy-MM-dd-HH:mm:ss");
      LocalDateTime now = LocalDateTime.now();
      String filename = dtf.format(now) + ".dat";

      //write the data from resource into newly created file
      //with current date and time as the file name.
      out2 = new DataOutputStream(new BufferedOutputStream(new
              FileOutputStream(filename)));
      out2.writeUTF(resource.getLevelName());
      out2.writeInt(resource.getLevel());
      out2.writeInt(resource.getxCoordinate());
      out2.writeInt(resource.getyCoordinate());
      out2.writeInt((int) (resource.getPlayerHealth()));
      out2.writeInt(resource.getEnemiesAlive());
      out2.close();

      //read the newly created file (with current time as the title)
      //and write the data out to the console.
      DataInputStream in2 = null;
      in2 = new DataInputStream(new
              BufferedInputStream(new FileInputStream(filename)));
      String levelName = in2.readUTF();
      int level = in2.readInt();
      int xCoord2 = in2.readInt();
      int yCoord2 = in2.readInt();
      int playerHealth2 = in2.readInt();
      int enemiesAlive2 = in2.readInt();

      //print the data to the console.
      System.out.println("File name: " + filename
              + "\nLevel Name: " + levelName
              + "\nLevel: " + level
              + "\nX coordinate: " + xCoord2
              + "\nY coornidate: " + yCoord2
              + "\nplayer health: " + playerHealth2
              + "\nEnemies alive: " + enemiesAlive2);
      in.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
