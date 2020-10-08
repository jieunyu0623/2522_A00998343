package ca.bcit.comp2522.assignments.a3;

/**
 * Interface class that simulates operations for
 * addition (+), subtraction (-), multiplication (*)
 * and division (/).
 *
 * @author Jieun Yu
 * @version 2020
 */
public interface Operation {

  /**
   * gets the symbol of operation.
   * @return Char the symbol.
   */
  char getSymbol();

  /**
   * performs the specified operation with two operands.
   * @param operandA first operand
   * @param operandB second operand
   * @return result of operation depending on the operation symbol.
   */
  int perform(int operandA, int operandB);

}
