package Lab_06;

public class TestSinglyLinkedList {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

		// Test addFirst() and addLast()
		linkedList.addFirst(3);
		linkedList.addFirst(2);
		linkedList.addFirst(1);
		linkedList.addLast(4);
		linkedList.addLast(5);

		// Test size() and isEmpty()
		System.out.println("Size: " + linkedList.size()); // Output: Size: 5
		System.out.println("Is Empty: " + linkedList.isEmpty()); // Output: Is Empty: false

		// Test first() and last()
		System.out.println("First: " + linkedList.first()); // Output: First: 1
		System.out.println("Last: " + linkedList.last()); // Output: Last: 5

		// Test removeFirst() and removeLast()
		System.out.println("Removed First: " + linkedList.removeFirst()); // Output: Removed First: 1
		System.out.println("Removed Last: " + linkedList.removeLast()); // Output: Removed Last: 5

		// Test size() after removal
		System.out.println("Size after removal: " + linkedList.size()); // Output: Size after removal: 3

		// Test first() and last() after removal
		System.out.println("First after removal: " + linkedList.first()); // Output: First after removal: 2
		System.out.println("Last after removal: " + linkedList.last()); // Output: Last after removal: 4
	}

}
