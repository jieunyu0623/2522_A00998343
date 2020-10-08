package ca.bcit.comp2522.assignments.a3;

/**
 * Simulates subtraction operation.
 *
 * @author Jieun Yu
 * @version 2020
 */
public class SubtractionOperation extends AbstractOperation {

  /** subtraction symbol. */
  private static final char SUBTRACTION_CODE = '-';

  /**
   * passing subtraction code to abstract operation constructor
   * and assign it to operationType.
   */
  public SubtractionOperation() {
    super(SUBTRACTION_CODE);
  }

  /**
   * performs subtraction operation with two operands.
   * @param operandA int first operand
   * @param operandB int second operand
   * @return operandA - operandB
   */
  @Override
  public int perform(final int operandA, final int operandB) {
    return operandA - operandB;
  }

}
