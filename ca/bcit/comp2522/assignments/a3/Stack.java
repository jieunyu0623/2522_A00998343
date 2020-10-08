package ca.bcit.comp2522.assignments.a3;

import java.util.Arrays;
import java.util.Objects;

/**
 * Stack class with useful methods for RPN calculation.
 *
 * @author Jieun Yu
 * @version 2020
 */
public class Stack {

  /** interger array for stack values to be stored. */
  private final int[] stackValues;

  /** number of stack values in the array stackValues. */
  private int count;

  /**
   * constructs the stack Object. Throws IllegalArgumentException
   * if the value passed is equal to or less than 0.
   * @param sizeOfArray size of array that holds the values in stackValue.
   */
  public Stack(final int sizeOfArray) {

    if (sizeOfArray < 1) {
      throw new IllegalArgumentException("Please "
              + "enter array size bigger than 0.");
    } else {
      this.stackValues = new int[sizeOfArray];
    }

  }

  /**
   * gets how many values the stackValues can hold.
   * @return length of stackValues.
   */
  public int capacity() {
    return stackValues.length;
  }

  /**
   * gets the current number of the stackValues.
   * @return count int
   */
  public int size() {
    return count;
  }

  /**
   * gets the unused portion of the array stackValues.
   * @return length of stackValues - current number
   * of values held in stackValues
   */
  public int unused() {
    return (capacity() - size());
  }

  /**
   * pushes an integer value to stackValues.
   * throws StackOverFlowException if there is no space available
   * in the stackValues.
   * @param value int
   * @throws StackOverflowException Stackoverflow Exception
   */
  public void push(final int value) throws StackOverflowException {
    if (this.unused() == 0) {
      throw new StackOverflowException("This stack is full!");
    } else {
      stackValues[count] = value;
      count++;
    }
  }

  /**
   * pops the last element of the stackValue.
   * throws StackUnderFlowException if there is no elements in stackValue.
   * @return poppedValue int
   * @throws StackUnderflowException StackUnderflowException
   */
  public int pop() throws StackUnderflowException {
    if (this.size() == 0) {
      throw new StackUnderflowException("Cannot "
              + "call Stack.pop() on an empty stack!");
    }
    int poppedValue;
    poppedValue = stackValues[count - 1];
    count--;
    return poppedValue;
  }

  /**
   * peeks the last element in the stackValue.
   * throws stackunderflow excpetion if there is no elements in the stackValue.
   * @return stackValues[connt] int
   * @throws StackUnderflowException StackUnderFlowException
   */
  public int peek() throws StackUnderflowException {
    if (this.size() == 0) {
      throw new StackUnderflowException("Cannot"
              + "call Stack.peek() on an empty stack!");
    }
    count = 0;
    return stackValues[count];
  }

  /**
   * checks if the object passed is the same as the one comparing.
   * @param o Object
   * @return true or false
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Stack stack = (Stack) o;
    return count == stack.count
            && Arrays.equals(stackValues, stack.stackValues);
  }

  /**
   * creates hashcode for each object.
   * @return result
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(count);
    result = 31 * result + Arrays.hashCode(stackValues);
    return result;
  }

  /**
   * converts the values into string.
   * @return string representation of the attributes in stackValue.
   */
  @Override
  public String toString() {
    return "Stack{"
            + "stackValues=" + Arrays.toString(stackValues)
            + ", count=" + count
            + '}';
  }
}
