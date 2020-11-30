package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Date;

/**
 * sales item class.
 * @author Jieun Yu
 * @version 2020
 */
public class SalesItem extends InventoryItem implements Serializable {

  /** sale price. */
  private double salePrice;

  /** sales ID. */
  private long salesID;

  /** if the item is sellable or not. */
  private boolean sellable;

  /** serial version unit ID. */
  private final long serialVersionUID;

  /** if the item is sold or not. */
  private boolean sold;

  /**
   * contructs a sales item.
   * @param name name
   * @param description description
   * @param purchasePrice purchase price
   * @param type type
   * @param sku stock keeping unit
   * @param ipd invoice purchase date
   * @param svuid serial version unit ID
   * @param sid sales ID
   * @param sp selling price
   * @param sell sellable
   * @param s sold
   */
  public SalesItem(final String name, final String description,
                   final double purchasePrice, final String type,
                   final long sku, final Date ipd, final long svuid,
                   final long sid, final double sp,
                   final boolean sell, final boolean s) {

    super(name, description, purchasePrice, type, sku, ipd, sell, svuid);
    this.salesID = sid;
    this.salePrice = sp;
    this.sold = s;
    this.serialVersionUID = svuid;
  }

  /**
   * gets the sale price.
   * @return salePrice
   */
  public double getSalePrice() {

    return salePrice;
  }

  /**
   * gets the sales ID.
   * @return salesID
   */
  public long getSalesID() {

    return salesID;
  }

  /**
   * gets if the item is sellable or not.
   * @return sellable
   */
  public boolean isSellable() {

    return sellable;
  }

  /**
   * sets if the item is sold or not.
   * @return sold
   */
  public boolean isSold() {

    return sold;
  }

  /**
   * sets the sale price of a sales item.
   * @param sp double
   */
  public void setSalePrice(final double sp) {

    this.salePrice = sp;
  }

  /**
   * sets the sales ID of the sales item.
   * @param sid long
   */
  public void setSalesID(final long sid) {

    this.salesID = sid;
  }

  /**
   * sets if the item is sellable or not.
   * @param sell boolean
   */
  public void setSellable(final boolean sell) {

    this.sellable = sell;
  }

  /**
   * sets if the item is sold or not.
   * @param s boolean
   */
  public void setSold(final boolean s) {

    this.sold = s;
  }

  /**
   * shows the string representation of the data of the sales item.
   * @return String
   */
  @Override
  public String toString() {

    return "SalesItem{"
            + "salePrice=" + salePrice
            + ", salesID=" + salesID
            + ", sellable=" + sellable
            + ", serialVersionUID=" + serialVersionUID
            + ", sold=" + sold + '}';
  }
}
