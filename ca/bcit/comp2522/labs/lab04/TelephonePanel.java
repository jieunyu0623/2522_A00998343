package ca.bcit.comp2522.labs.lab04;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelephonePanel extends JPanel {

  public TelephonePanel() {

    //JPanel titlePanel = new JPanel(new BorderLayout());

    JLabel title = new JLabel("Your Telephone", JLabel.CENTER); //create a JLabel with "Your Telephone" title

    setLayout(new BorderLayout()); //set BorderLayout for this panel
    add(title, BorderLayout.NORTH);//add title label to north of this panel

    JPanel keypad = new JPanel(new GridLayout(4, 3)); //create panel to hold keypad and give it a 4x3 GridLayout

    JButton numberOne = new JButton("1");
    JButton numberTwo = new JButton("2");
    JButton numberThree = new JButton("3");
    JButton numberFour = new JButton("4");
    JButton numberFive = new JButton("5");
    JButton numberSix = new JButton("6");
    JButton numberSeven = new JButton("7");
    JButton numberEight = new JButton("8");
    JButton numberNine = new JButton("9");
    JButton star = new JButton("*");
    JButton numberZero = new JButton("0");
    JButton pound = new JButton("#");

    keypad.add(numberOne); //add buttons representing keys to key panel
    keypad.add(numberTwo);
    keypad.add(numberThree);
    keypad.add(numberFour);
    keypad.add(numberFive);
    keypad.add(numberSix);
    keypad.add(numberSeven);
    keypad.add(numberEight);
    keypad.add(numberNine);
    keypad.add(star);
    keypad.add(numberZero);
    keypad.add(pound);

    add(keypad, BorderLayout.CENTER); //add key panel to center of this panel

    ButtonListener listener = new ButtonListener();
    numberOne.addActionListener(listener);
    numberTwo.addActionListener(listener);
    numberThree.addActionListener(listener);
    numberFour.addActionListener(listener);
    numberFive.addActionListener(listener);
    numberSix.addActionListener(listener);
    numberSeven.addActionListener(listener);
    numberEight.addActionListener(listener);
    numberNine.addActionListener(listener);
    numberZero.addActionListener(listener);

    star.addActionListener(new ButtonListener() {
      public void actionPerformed(final ActionEvent e) {
        System.out.println("key pressed *");
      }
    });

    pound.addActionListener(new ButtonListener() {
      public void actionPerformed(final ActionEvent e) {
        System.out.println("key pressed #");
      }
    });

  }

  class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

      JButton button = (JButton) e.getSource();
      int number = Integer.parseInt(button.getText()); // for numbers.

      switch(number) {
        case 1:
          System.out.println("key pressed " + 1);
          break;
        case 2:
          System.out.println("key pressed " + 2);
          break;
        case 3:
          System.out.println("key pressed " + 3);
          break;
        case 4:
          System.out.println("key pressed " + 4);
          break;
        case 5:
          System.out.println("key pressed " + 5);
          break;
        case 6:
          System.out.println("key pressed " + 6);
          break;
        case 7:
          System.out.println("key pressed " + 7);
          break;
        case 8:
          System.out.println("key pressed " + 8);
          break;
        case 9:
          System.out.println("key pressed " + 9);
          break;
        case 0:
          System.out.println("key pressed " + 0);
          break;
        default:
          break;
      }
    }
  }
}
