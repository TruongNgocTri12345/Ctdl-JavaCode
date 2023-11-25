package Lab_10;

import java.util.Stack;

public class Task1 {

	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		Stack<E> stack = new Stack<>();
		for (E element : array) {
			stack.push(element);
		}

		// Now stack contains elements in reverse order
		for (int i = 0; i < array.length; i++) {
			array[i] = stack.pop();
		}
	}

	// This method checks the correctness of the given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==> false
	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<>();

		for (char ch : input.toCharArray()) {
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			} else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			} else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			} else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			} else if (ch == ')' || ch == ']' || ch == '}') {
				return false; // Mismatched closing bracket
			}
		}

		return stack.isEmpty(); // If stack is empty, all brackets are matched
	}

	// This method evaluates the value of an expression
	// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
		Stack<Integer> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();

		for (char ch : expression.toCharArray()) {
			if (Character.isDigit(ch)) {
				operandStack.push(Character.getNumericValue(ch));
			} else if (ch == '+' || ch == '-') {
				processOperators(operandStack, operatorStack, ch);
			} else if (ch == '*' || ch == '/') {
				processOperators(operandStack, operatorStack, ch);
			} else if (ch == '(') {
				operatorStack.push(ch);
			} else if (ch == ')') {
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					processOperators(operandStack, operatorStack);
				}
				operatorStack.pop(); // Pop the '(' symbol
			}
		}

		while (!operatorStack.isEmpty()) {
			processOperators(operandStack, operatorStack);
		}

		return operandStack.pop(); // The final result is on the top of the operand stack
	}

	private static void processOperators(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char operator = operatorStack.pop();
		int operand2 = operandStack.pop();
		int operand1 = operandStack.pop();
		int result = performOperation(operand1, operand2, operator);
		operandStack.push(result);
	}

	private static void processOperators(Stack<Integer> operandStack, Stack<Character> operatorStack,
			char newOperator) {
		while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
			processOperators(operandStack, operatorStack);
		}
		operatorStack.push(newOperator);
	}

	private static int performOperation(int operand1, int operand2, char operator) {
		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			return operand1 / operand2;
		default:
			throw new IllegalArgumentException("Invalid operator: " + operator);
		}
	}

	public static void main(String[] args) {
		// Test reserve method
		Integer[] arrayToReverse = { 1, 2, 3, 4, 5 };
		System.out.println("Mang goc: " + java.util.Arrays.toString(arrayToReverse));
		Task1.reserve(arrayToReverse);
		System.out.println("Mang dao nguoc: " + java.util.Arrays.toString(arrayToReverse));

		// Test isCorrect method
		String correctInput = "()(())[]{(())}";
		String incorrectInput = "){[]}()";
		System.out.println("Is correct: " + Task1.isCorrect(correctInput)); // Should be true
		System.out.println("Is correct: " + Task1.isCorrect(incorrectInput)); // Should be false

		// Test evaluateExpression method
		String expression = "5 + (4 * (3 + 2))";
		System.out.println("KQ bieu thuc: " + Task1.evaluateExpression(expression)); // Should be 25
	}

}
