package ca.bcit.comp2522.assignments.a3;

/**
 * Simulates division operation.
 *
 * @author Jieun Yu
 * @version 2020
 */
public class DivisionOperation extends AbstractOperation {

  /** division symbol. */
  private static final char DIVISION_CODE = '/';

  /**
   * passing divison code to abstract operation constructor
   * and assign it to operationType.
   */
  public DivisionOperation() {
    super(DIVISION_CODE);
  }

  /**
   * performs division operation with two operands.
   * @param operandA int first operand
   * @param operandB int second operand
   * @return operandA / operandB
   */
  @Override
  public int perform(final int operandA, final int operandB) {
    return operandA / operandB;
  }

}
