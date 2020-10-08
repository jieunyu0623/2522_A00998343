package ca.bcit.comp2522.assignments.a3;

/**
 * Simulates multiplication operation.
 *
 * @author Jieun Yu
 * @version 2020
 */
public class MultiplicationOperation extends AbstractOperation {

  /** multiplication symbol. */
  private static final char MULTIPLICATION_CODE = '*';

  /**
   * passing multiplication code to abstract operation constructor
   * and assign it to operationType.
   */
  public MultiplicationOperation() {
    super(MULTIPLICATION_CODE);
  }

  /**
   * performs multiplication operation with two operands.
   * @param operandA int first operand
   * @param operandB int second operand
   * @return operandA * operandB
   */
  @Override
  public int perform(final int operandA, final int operandB) {
    return operandA * operandB;
  }

}
