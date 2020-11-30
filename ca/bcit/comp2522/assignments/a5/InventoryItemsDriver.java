package ca.bcit.comp2522.assignments.a5;

import java.util.Date;

/**
 * driver class.
 * @author Jieun Yu
 * @version 2020
 */
public class InventoryItemsDriver {

  /**
   * main class to test sales item class and rental item class work fine.
   * @param args unused.
   */
  public static void main(final String[] args) {

    Date date = new Date();

    //creates a sales item
    SalesItem saleItem = new SalesItem("Lawn mower",
            "60V 5Ah Self-Propelled RWD Cordless Lawn Mower, 21-in",
            650.00, "machine", 36L, date,
            31L, 201L, 700.00,
            true, false);

    //creates five different Rental objects/items
    Rental item1 = new Rental("item1", Condition.EXCELLENT,
            Condition.AVERAGE, date, 103L, 30L);
    Rental item2 = new Rental("item2", Condition.GREAT,
            Condition.POOR, date, 104L, 31L);
    Rental item3 = new Rental("item3", Condition.AVERAGE,
            Condition.DAMANGED, date, 105L, 32L);
    Rental item4 = new Rental("item4", Condition.EXCELLENT,
            Condition.POOR, date, 106L, 33L);
    Rental item5 = new Rental("item5", Condition.GREAT,
            Condition.AVERAGE, date, 107L, 34L);

    //save those five items to Rental[] array.
    Rental[] items = {item1, item2, item3, item4, item5};

    //creates a rental item
    RentalItem rentalItem = new RentalItem("Rental truck 1",
            "rental items", 34146.00,
    "Enterprise Truck", 5L, date,
            10L, items, 475, true, false);

    //print sales item and rental items
    System.out.println(saleItem.toString());
    System.out.println(rentalItem.toString());

    //checks if both items are the same item.
    System.out.println(saleItem.equals(rentalItem));

    //delete inventory items
    saleItem = null;
    rentalItem = null;

  }
}
