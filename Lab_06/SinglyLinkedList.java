package Lab_06;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty()) {
			return null;
		}
		return head.getData();
	}

	public E last() {
		if (isEmpty()) {
			return null;
		}
		return tail.getData();
	}

	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
		size++;
	}

	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}

	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		E removedElement = head.getData();
		head = head.getNext();
		size--;
		if (isEmpty()) {
			tail = null;
		}
		return removedElement;
	}

	public E removeLast() {
		if (isEmpty()) {
			return null;
		}
		E removedElement = tail.getData();
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			Node<E> currentNode = head;
			while (currentNode.getNext() != tail) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(null);
			tail = currentNode;
		}
		size--;
		return removedElement;
	}

}
