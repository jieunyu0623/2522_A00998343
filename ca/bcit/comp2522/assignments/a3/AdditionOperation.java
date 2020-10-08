package ca.bcit.comp2522.assignments.a3;

/**
 * Simulates addition operation.
 *
 * @author Jieun Yu
 * @version 2020
 */
public class AdditionOperation extends AbstractOperation {

  /** addition symbol. */
  private static final char ADDITION_CODE = '+';

  /**
   * passing addition code to abstract operation constructor
   * and assign it to operationType.
   */
  public AdditionOperation() {
    super(ADDITION_CODE);
  }

  /**
   * performs addition operation with two operands.
   * @param operandA int first operand
   * @param operandB int second operand
   * @return operandA + operandB
   */
  @Override
  public final int perform(final int operandA, final int operandB) {
    return operandA + operandB;
  }

}
