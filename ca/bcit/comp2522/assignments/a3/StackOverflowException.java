package ca.bcit.comp2522.assignments.a3;

public class StackOverflowException extends Exception {

  /**
   * stackoverflow exception passed to Exception constructor.
   */
  public StackOverflowException() {
    super();
  }

  /**
   * passes the error message.
   * @param s String error message.
   */
  public StackOverflowException(final String s) {
    super(s);
  }
}
