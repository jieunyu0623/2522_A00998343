package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * rental class. Aggregation of rental item class.
 * @author Jieun Yu
 * @version 2020
 */
public class Rental implements Serializable {

  /** comments. */
  private String comments;

  /** condition after rented. */
  private Condition conditionAfter;

  /** condition before rented. */
  private final Condition conditionBefore;

  /** date when rented. */
  private final Date date;

  /** rental ID. */
  private long rentalID;

  /** serial version UID. */
  private final long serialVersionUID;

  /**
   * constructs a rental object.
   * @param comm comments
   * @param ca condition after
   * @param cb condition before
   * @param d date
   * @param rid rental ID
   * @param srvuid serial version UID
   */
  public Rental(final String comm, final Condition ca, final Condition cb,
                 final Date d, final long rid, final long srvuid) {

    this.comments = comm;
    this.conditionAfter = ca;
    this.conditionBefore = cb;
    this.date = d;
    this.rentalID = rid;
    this.serialVersionUID = srvuid;

  }

  /**
   * gets comments of a rental object.
   * @return comments
   */
  public String getComments() {

    return comments;
  }

  /**
   * gets the condition of a rentable object after being rented.
   * @return conditionAfter
   */
  public Condition getConditionAfter() {

    return conditionAfter;
  }

  /**
   * gets the condition of a rentable object before being rented out.
   * @return conditionBefore
   */
  public Condition getConditionBefore() {

    return conditionBefore;
  }

  /**
   * gets the date of the rent.
   * @return date
   */
  public Date getDate() {

    return date;
  }

  /**
   * gets the rental ID.
   * @return rentalID
   */
  public long getRentalID() {

    return rentalID;
  }

  /**
   * gets the serial version UID for the rent.
   * @return serialVersionUID
   */
  public long getSerialVersionUID() {

    return serialVersionUID;
  }

  /**
   * sets the comments of a rental object.
   * @param c String
   */
  public void setComments(final String c) {

    this.comments = c;
  }

  /**
   * sets the condition of a rental item after being rented.
   * @param ca Condition
   */
  public void setConditionAfter(final Condition ca) {

    this.conditionAfter = ca;
  }

  /**
   * sets the condition of a rental item before being rented.
   * @param cb Condition
   */
  public void setConditionBefore(final Condition cb) {

    this.conditionAfter = cb;
  }

  /**
   * sets the rental id of a rental object.
   * @param rid long
   */
  public void setRentalID(final long rid) {

    this.rentalID = rid;
  }

  /**
   * shows the string representation of the data.
   * @return String
   */
  @Override
  public String toString() {

    return "Rental{"
            + "comments='" + comments + '\''
            + ", conditionAfter=" + conditionAfter
            + ", conditionBefore=" + conditionBefore
            + ", date=" + date
            + ", rentalID=" + rentalID
            + ", serialVersionUID=" + serialVersionUID
            + '}';
  }

  /**
   * checks if this object is the same as the object passing.
   * @param o Object
   * @return true or false
   */
  @Override
  public boolean equals(final Object o) {

    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Rental rental = (Rental) o;
    return rentalID == rental.rentalID
            && serialVersionUID == rental.serialVersionUID
            && Objects.equals(comments, rental.comments)
            && Objects.equals(conditionAfter, rental.conditionAfter)
            && Objects.equals(conditionBefore, rental.conditionBefore)
            && Objects.equals(date, rental.date);
  }

  /**
   * returns hashcode for an object.
   * @return int
   */
  @Override
  public int hashCode() {

    return Objects.hash(comments, conditionAfter,
            conditionBefore, date, rentalID, serialVersionUID);
  }

}
