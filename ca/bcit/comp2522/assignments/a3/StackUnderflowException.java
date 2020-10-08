package ca.bcit.comp2522.assignments.a3;

public class StackUnderflowException extends Exception {

  /**
   * stackunderflow exception passed to Exception constructor.
   */
  public StackUnderflowException() {
    super();
  }

  /**
   * passes the error message.
   * @param s String error message
   */
  public StackUnderflowException(final String s) {
    super(s);
  }
}
