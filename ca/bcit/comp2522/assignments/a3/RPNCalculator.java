package ca.bcit.comp2522.assignments.a3;

import java.util.Scanner;

/**
 * simulates RPN calculator.
 *
 * @author Jieun Yu
 * @version 2020
 */
public class RPNCalculator {

  /** minimum stack size required. */
  public static final int MIN_STACK_SIZE = 2;
  /** stack. */
  private final Stack stack;

  /**
   * constructs an RPN object with stack size passed.
   * @param stackSize the size of the stack.
   */
  public RPNCalculator(final int stackSize) {
    if (stackSize < MIN_STACK_SIZE) {
      throw new IllegalArgumentException("stack size must be bigger than 2!");
    }
    this.stack = new Stack(stackSize);
  }

  /**
   * processes calculation with numbers and operation symbols passed.
   * @param formula will be passed as the command line argument in main.
   * @return result of the calculation. the result will be
   * stored in stack at the end of the calculation.
   * @throws StackOverflowException StackOverflowException
   * @throws InvalidOperationTypeException InvalidOperationTypeException
   * @throws StackUnderflowException StackUnderflowException
   */
  public int processFormula(final String formula) throws StackOverflowException,
          InvalidOperationTypeException, StackUnderflowException {
    if (formula.isEmpty() || formula.isBlank()) {
      throw new IllegalArgumentException("Formula cannot be empty!");
    }
    Scanner scan = new Scanner(formula);

    while (scan.hasNext()) {
      if (scan.hasNextInt()) {
        this.push(scan.nextInt());
      } else {
        Operation operation = getOperation(scan.next().charAt(0));
        this.perform(operation);
      }
    }
    scan.close();
    return this.getResult();
  }

  /**
   * pushes the operands into the stack. Helper method for processing formula.
   * throws StackOverflowException if the stack is already full.
   * @param operand the interger value
   * @throws StackOverflowException StackOverflowException
   */
  public void push(final int operand) throws StackOverflowException {
    if (stack.unused() == 0) {
      throw new StackOverflowException("the stack is already full!");
    }
    stack.push(operand);
  }

  private Operation getOperation(final char symbol) throws
          InvalidOperationTypeException {
    return switch (symbol) {
      case '+' -> new AdditionOperation();
      case '-' -> new SubtractionOperation();
      case '*' -> new MultiplicationOperation();
      case '/' -> new DivisionOperation();
      default -> throw new
              InvalidOperationTypeException("Invalid operation symbol.");
    };
  }

  private void perform(final Operation operation)
          throws StackUnderflowException,
          StackOverflowException {
    if (operation == null) {
      throw new IllegalArgumentException("Operation cannot be null!");
    }
    int operandTwo = stack.pop();
    int operandOne = stack.pop();
    int result = operation.perform(operandOne, operandTwo);
    this.push(result);
  }

  /**
   * gets the operation result.
   * @return the result (last element in stack) by using stack.peek() method
   * @throws StackUnderflowException StackUnderflowException
   */
  public int getResult() throws StackUnderflowException {
    if (stack.size() == 0) {
      throw new StackUnderflowException("There are no operands!");
    }
    return stack.peek();
  }

  /**
   * Drives the program by evaluating the
   * RPN calculation provided as * a command line argument.
   *
   * Example usage: RPNCalculator 10 "1 2 +"
   *
   * Note that the formula MUST be placed inside of double quotes.
   *
   * @param argv - the command line arguments are the size of the Stack
   *               to be created followed by the expression to evaluate.
   *
   */
  public static void main(final String[] argv) {
    // Checks for correct number of command line arguments.
    if (argv.length != 2) {
      System.err.println("Usage: Main <stack size> <formula>"); System.exit(1);
    }
    // Initializes stack and RPNCalculator.
    final int stackSize = Integer.parseInt(argv[0]);
    final RPNCalculator calculator = new RPNCalculator(stackSize);
    try {
      System.out.println("[" + argv[1] + "] = "
              + calculator.processFormula(argv[1]));
    } catch (final InvalidOperationTypeException ex) {
      System.err.println("formula can only contain integers, +, -, *, and /");
    } catch (final StackOverflowException ex) {
      System.err.println("too many operands in the formula,"
              + "increase the stack size");
    } catch (final StackUnderflowException ex) {
      System.err.println("too few operands in the formula");
    }
  }
}
