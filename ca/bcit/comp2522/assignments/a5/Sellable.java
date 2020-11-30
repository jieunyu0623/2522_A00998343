package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;

/**
 * sellable interface.
 * @author Jieun Yu
 * @version 2020
 */
public interface Sellable extends Serializable {

  /**
   * if the item is sellable or not.
   * @return true or false boolean
   */
  boolean isSellable();

  /**
   * sets if the item is sellable or not.
   * @param sell boolean
   */
  void setSellable(boolean sell);

}
