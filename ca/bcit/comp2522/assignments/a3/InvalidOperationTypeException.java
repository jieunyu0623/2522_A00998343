package ca.bcit.comp2522.assignments.a3;

public class InvalidOperationTypeException extends Exception {

  /**
   * passes invalid operation type exception to Exception constructor.
   */
  public InvalidOperationTypeException() {
    super();
  }

  /**
   * passes error message.
   * @param s String error message
   */
  public InvalidOperationTypeException(final String s) {
    super(s);
  }
}
