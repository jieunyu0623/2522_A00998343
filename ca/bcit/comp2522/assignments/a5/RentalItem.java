package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * rental item class.
 * @author Jieun Yu
 * @version 2020
 */
public class RentalItem extends InventoryItem implements Serializable {

  /** current condition of a rental item. */
  private Condition currentCondition;

  /** multiple Rental objects in Rental type array. */
  private static Rental[] items;

  /** rental ID. */
  private long rentalID;

  /** rental price. */
  private double rentalPrice;

  /** sellable or not. */
  private boolean sellable;

  /** serial version UID. */
  private long serialVersionUID;

  /** sold or not. */
  private boolean sold;

  /**
   * constructs an rental item.
   * @param name String
   * @param description String
   * @param purchasePrice double
   * @param type String
   * @param sku long
   * @param ipd Date
   * @param svuid long
   * @param item Rental[]
   * @param rp double
   * @param sell boolean
   * @param s boolean
   */
  public RentalItem(final String name, final String description,
                    final double purchasePrice,
                    final String type, final long sku,
                    final Date ipd, final long svuid, final Rental[] item,
                    final double rp, final boolean sell,
                    final boolean s) {

    super(name, description, purchasePrice, type, sku, ipd, sell, svuid);

    items = new Rental[item.length];

    for (int i = 0; i < item.length; i++) {
      items[i] = item[i];
      this.rentalID = item[i].getRentalID();
      this.serialVersionUID = item[i].getSerialVersionUID();
    }
    this.rentalPrice = rp;
    this.sellable = sell;
    this.sold = s;
  }

  /**
   * gets the current condition of the rental item.
   * @return Condition
   */
  public Condition getCurrentCondition() {

    return currentCondition;
  }

  /**
   * gets the Rental objects (items).
   * @return items
   */
  public static Rental[] getItems() {

    return items;
  }

  /**
   * gets the rental ID.
   * @return rentalID
   */
  public long getRentalID() {

    return rentalID;
  }

  /**
   * gets the rental price.
   * @return rentalPrice
   */
  public double getRentalPrice() {

    return rentalPrice;
  }

  /**
   * shows if the rented object is sellable or not.
   * @return sellable
   */
  public boolean isSellable() {

    return sellable;
  }

  /**
   * shows if the item after rented is sold or not.
   * @return sold
   */
  public boolean isSold() {

    return sold;
  }

  /**
   * sets the current condition of a rental object.
   * @param cc Condition
   */
  public void setCurrentCondition(final Condition cc) {

    this.currentCondition = cc;
  }

  /**
   * sets the rental items.
   * @param i Rental[]
   */
  public void setItems(final Rental[] i) {

    RentalItem.items = new Rental[i.length];
    System.arraycopy(i, 0, RentalItem.items, 0, i.length);
  }

  /**
   * sets the rental ID of a rental item.
   * @param rid long
   */
  public void setRentalID(final long rid) {

    this.rentalID = rid;
  }

  /**
   * sets the rental price.
   * @param rp double
   */
  public void setRentalPrice(final double rp) {

    this.rentalPrice = rp;
  }

  /**
   * sets if the rental object is sellable after being rented.
   * @param sell boolean
   */
  public void setSellable(final boolean sell) {

    this.sellable = sell;
  }

  /**
   * sets if the rental object is sold or not after being rented.
   * @param s boolean
   */
  public void setSold(final boolean s) {

    this.sold = s;
  }

  /**
   * shows the string representation of the data of the rental object.
   * @return String
   */
  @Override
  public String toString() {

    return "RentalItem{"
            + "currentCondition=" + currentCondition
            + ", items=" + Arrays.toString(items)
            + ", rentalID=" + rentalID
            + ", rentalPrice=" + rentalPrice
            + ", sellable=" + sellable
            + ", serialVersionUID=" + serialVersionUID
            + ", sold=" + sold + '}';
  }

}
