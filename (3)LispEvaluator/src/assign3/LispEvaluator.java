/**
 * 
 */
package assign3;

import java.util.Scanner;

/**
 * COSC2010 Data Structures - Assignment 3 - This program evaluates a lisp
 * mathematical expression
 * 
 * @author Peter
 */
public class LispEvaluator {

	private static UnboundedStackInterface<Object> stack = new LinkedStack<Object>();
	private static UnboundedStackInterface<Double> currOpStack = new LinkedStack<Double>();

	/**
	 * Evaluates the expression for operators and operands
	 * 
	 * @param expression
	 *            - Lisp expression from user input
	 * @return result of the operation from 'expression'
	 */
	@SuppressWarnings("resource")
	private static double evaluate(String expression) {
		String operator;
		double result = 0;

		Scanner conIn = new Scanner(expression);
		conIn = conIn.useDelimiter("\\s*");

		while (conIn.hasNext()) {
			if (conIn.hasNextInt()) {
				// Process operand
				String value = conIn.findInLine("\\d+");
				stack.push(Double.parseDouble(value));
				// System.out.println(value);
			} else {
				// Process operation.
				operator = conIn.next();
				switch (operator) {
				case "(":
					break;
				case ")":
					operate();
					break;
				case "*":
					stack.push(operator);
					break;
				case "+":
					stack.push(operator);
					break;
				case "/":
					stack.push(operator);
					break;
				case "-":
					stack.push(operator);
					break;
				default:
					throw new LispException("Illegal symbol: " + operator);
				}
			}
		}
		result = Double.parseDouble(stack.top().toString());
		stack.pop();
		conIn.close();
		return result;
	}

	/**
	 * Method for executing the operation that is set in 'stack'. Processes
	 * operands into 'currOpStack' and operator into 'op'. Stores the result of
	 * the operations into 'stack'.
	 */
	private static void operate() {
		String op;
		boolean numeric = true;

		do {
			op = String.valueOf(stack.top()); // operator on last loop
			stack.pop();
			try {
				Double number = Double.parseDouble(op); // operand if error is
														// not thrown
				currOpStack.push(number);
			} catch (NumberFormatException nfe) {
				numeric = false;
			}
		} while (numeric);

		double result = 0.0;
		switch (op) {
		case "*":
			if (currOpStack.isEmpty()) {
				// handle case of (*)
				result = 1.0;
				break;
			}
			// multiply contents of currOpStack
			result = currOpStack.top();
			currOpStack.pop();
			while (!currOpStack.isEmpty()) {
				result *= currOpStack.top();
				currOpStack.pop();
			}
			break;
		case "+":
			// sum contents of currOpStack
			result = currOpStack.top();
			currOpStack.pop();
			while (!currOpStack.isEmpty()) {
				result += currOpStack.top();
				currOpStack.pop();
			}
			break;
		case "/":
			// divide contents of currOpStack
			result = currOpStack.top();
			currOpStack.pop();
			while (!currOpStack.isEmpty()) {
				result /= currOpStack.top();
				currOpStack.pop();
			}
			break;
		case "-":
			result = currOpStack.top();
			currOpStack.pop();
			if (currOpStack.isEmpty()) {
				// handle case of (- n)
				result *= -1.0;
			}
			while (!currOpStack.isEmpty()) {
				// subtract contents of currOpStack
				result -= currOpStack.top();
				currOpStack.pop();
			}
			break;
		default:
			result = currOpStack.top();
			currOpStack.pop();
			break;
		}
		stack.push(result);
	}

	/**
	 * Main method of the LispEvaluator. Holds the test cases for the program
	 * 
	 * @param args
	 *            - system input, unused in this program
	 */
	public static void main(String[] args) {
		// test case 1 == 15.0
		double result = evaluate("(+ 5 0 10)");
		System.out.println("Input: '(+ 5 0 10)' evaluates to " + result);

		// test case 2 == 20.0
		result = evaluate("(+ 5 0 10 (- 7 2))");
		System.out
				.println("Input: '(+ 5 0 10 (- 7 2))' evaluates to " + result);

		// test case 3 == 16.5
		result = evaluate("(+ (- 6) (* 2 3 4) (/ (+ 3) (*) (- 2 3 1)))");
		System.out
				.println("Input: '(+ (- 6) (* 2 3 4) (/ (+ 3) (*) (- 2 3 1)))' "
						+ "evaluates to " + result);

		// test case 4 == -378.11764705882354
		result = evaluate("(+ (- 632) (* 21 3 4) (/ (+ 32) (*) (- 21 3 1)))");
		System.out
				.println("Input: '(+ (- 632) (* 21 3 4) (/ (+ 32) (*) (- 21 3 1)))' evaluates to "
						+ result);
	}
}
