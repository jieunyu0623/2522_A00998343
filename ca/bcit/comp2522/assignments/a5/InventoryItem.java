package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * inventory item class. has two sub classes which are
 * SalesItem and RentalItem.
 *
 * @author Jieun Yu
 * @version 2020
 */
abstract class InventoryItem implements Sellable, Serializable {

  /** invoice purchase date. */
  private Date ipd;

  /** stock keeping unit. */
  private long sku;

  /** description of the item. */
  private String desc;

  /** name of the item. */
  private String name;

  /** purchase price of the item. */
  private double purchasePrice;

  /** serial version UID of the item. */
  private final long serialVersionUID;

  /** item type. */
  private String type;

  /** whether or not the item is sellable. */
  private boolean sellable;

  /**
   * constructs an item object.
   * @param n name
   * @param d description
   * @param pp purchase price
   * @param t type
   * @param skus stock keeping unit
   * @param i invoice purchase date
   * @param sell sellable
   * @param svId serial version ID
   */
  InventoryItem(final String n, final String d, final double pp,
                       final String t, final long skus, final Date i,
                       final boolean sell, final long svId) {

    this.name = n;
    this.desc = d;
    this.purchasePrice = pp;
    this.type = t;
    this.sku = skus;
    this.ipd = i;
    this.sellable = sell;
    this.serialVersionUID = svId;

  }

  public String getDesc() {

    return desc;
  }

  public Date getIPD() {

    return ipd;
  }

  public String getName() {

    return name;
  }

  public double getPurchasePrice() {

    return purchasePrice;
  }

  public long getSKU() {

    return sku;
  }

  public String getType() {

    return type;
  }

  public void setDesc(final String d) {

    this.desc = d;
  }

  public void setIPD(final Date i) {

    this.ipd = i;
  }

  public void setName(final String n) {

    this.name = n;
  }

  public void setPurchasePrice(final double pp) {

    this.purchasePrice = pp;
  }

  public void setSKU(final long s) {

    this.sku = s;
  }

  public void setType(final String t) {

    this.type = t;
  }

  @Override
  public String toString() {

    return "InventoryItem{"
            + "IPD=" + ipd
            + ", SKU=" + sku
            + ", desc='" + desc + '\''
            + ", name='" + name + '\''
            + ", purchasePrice=" + purchasePrice
            + ", serialVersionUID=" + serialVersionUID
            + ", type='" + type + '\''
            + '}';
  }

  @Override
  public boolean equals(final Object o) {

    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;

    }

    InventoryItem that = (InventoryItem) o;
    return sku == that.sku
            && Double.compare(that.purchasePrice, purchasePrice) == 0
            && serialVersionUID == that.serialVersionUID
            && Objects.equals(ipd, that.ipd)
            && Objects.equals(desc, that.desc)
            && Objects.equals(name, that.name)
            && Objects.equals(type, that.type);
  }

  @Override
  public int hashCode() {

    return Objects.hash(ipd, sku, desc, name,
            purchasePrice, serialVersionUID, type);
  }

  @Override
  public boolean isSellable() {

    return sellable;
  }

  @Override
  public void setSellable(final boolean sell) {

    this.sellable = sell;
  }

}
