package Lab_10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Task2 {

	// Method stutter that accepts a queue of integers and replaces every element
	// with two copies of that element
	public static <E> void stutter(Queue<E> input) {
		int originalSize = input.size();
		for (int i = 0; i < originalSize; i++) {
			E element = input.poll();
			input.offer(element);
			input.offer(element);
		}
	}

	// Method mirror that accepts a queue of strings and appends the queue's
	// contents to itself in reverse order
	public static <E> void mirror(Queue<E> input) {
		int originalSize = input.size();
		Stack<E> stack = new Stack<>();

		// Push elements onto the stack
		for (int i = 0; i < originalSize; i++) {
			E element = input.poll();
			input.offer(element);
			stack.push(element);
		}

		// Add the mirrored order of elements
		for (int i = 0; i < originalSize; i++) {
			E element = stack.pop();
			input.offer(element);
		}
	}

	// Example usage
	public static void main(String[] args) {
		// Test stutter method
		Queue<Integer> intQueue = new LinkedList<>();
		intQueue.offer(1);
		intQueue.offer(2);
		intQueue.offer(3);
		System.out.println("Input: " + intQueue);
		stutter(intQueue);
		System.out.println("Output: " + intQueue);
		System.out.println("-----------------------");

		// Test mirror method
		Queue<String> strQueue = new LinkedList<>();
		strQueue.offer("a");
		strQueue.offer("b");
		strQueue.offer("c");
		System.out.println("Input: " + strQueue);
		mirror(strQueue);
		System.out.println("Output: " + strQueue);
	}
}
