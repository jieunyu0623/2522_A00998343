package ca.bcit.comp2522.assignments.a3;

/**
 * Abstract class for four differnet operations.
 * This class implements the Operation interface.
 *
 * @author Jieun Yu
 * @version 2020
 */
abstract class AbstractOperation implements Operation {

  /** operation type. */
  private final char operationType;

  AbstractOperation(final char operation) {
    operationType = operation;
  }

  public char getSymbol() {
    return operationType;
  }

}
