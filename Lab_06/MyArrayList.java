package Lab_06;

	import java.util.Arrays;
import java.util.Comparator;

	public class MyArrayList<E> {
	    public static final int DEFAULT_CAPACITY = 10;
	    private E[] elements;
	    private int size;

	    public MyArrayList() {
	        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	    }

	    public MyArrayList(int capacity) {
	        this.elements = (E[]) new Object[capacity];
	    }

	    public void growSize() {
	        int newCapacity = elements.length * 2;
	        E[] newElements = (E[]) new Object[newCapacity];
	        System.arraycopy(elements, 0, newElements, 0, size);
	        elements = newElements;
	    }

	    public int size() {
	        return size;
	    }

	    public boolean isEmpty() {
	        return size == 0;
	    }

	    public E get(int i) throws IndexOutOfBoundsException {
	        if (i < 0 || i >= size) {
	            throw new IndexOutOfBoundsException();
	        }
	        return elements[i];
	    }

	    public E set(int i, E e) throws IndexOutOfBoundsException {
	        if (i < 0 || i >= size) {
	            throw new IndexOutOfBoundsException();
	        }
	        E replacedElement = elements[i];
	        elements[i] = e;
	        return replacedElement;
	    }

	    public boolean add(E e) {
	        if (size == elements.length) {
	            growSize();
	        }
	        elements[size] = e;
	        size++;
	        return true;
	    }

	    public void add(int i, E e) throws IndexOutOfBoundsException {
	        if (i < 0 || i > size) {
	            throw new IndexOutOfBoundsException();
	        }
	        if (size == elements.length) {
	            growSize();
	        }
	        System.arraycopy(elements, i, elements, i + 1, size - i);
	        elements[i] = e;
	        size++;
	    }

	    public E remove(int i) throws IndexOutOfBoundsException {
	        if (i < 0 || i >= size) {
	            throw new IndexOutOfBoundsException();
	        }
	        E removedElement = elements[i];
	        System.arraycopy(elements, i + 1, elements, i, size - i - 1);
	        elements[size - 1] = null;
	        size--;
	        return removedElement;
	    }

	    public void clear() {
	        for (int i = 0; i < size; i++) {
	            elements[i] = null;
	        }
	        size = 0;
	    }

	    public int lastIndexOf(Object o) {
	        if (o == null) {
	            for (int i = size - 1; i >= 0; i--) {
	                if (elements[i] == null) {
	                    return i;
	                }
	            }
	        } else {
	            for (int i = size - 1; i >= 0; i--) {
	                if (o.equals(elements[i])) {
	                    return i;
	                }
	            }
	        }
	        return -1;
	    }

	    public E[] toArray() {
	        E[] array = (E[]) new Object[size];
	        System.arraycopy(elements, 0, array, 0, size);
	        return array;
	    }

	    public MyArrayList<E> clone() {
	        MyArrayList<E> cloneList = new MyArrayList<>(elements.length);
	        System.arraycopy(elements, 0, cloneList.elements, 0, size);
	        cloneList.size = size;
	        return cloneList;
	    }
	    
	    public boolean contains(E o) {
	        return indexOf(o) != -1;
	    }

	    public int indexOf(E o) {
	        if (o == null) {
	            for (int i = 0; i < size; i++) {
	               if (elements[i] == null) {
	                        return i;
	                    }
	                }
	            } else {
	                for (int i = 0; i < size; i++) {
	                    if (o.equals(elements[i])) {
	                        return i;
	                    }
	                }
	            }
	            return -1;
	        }

	        public boolean remove(E e) {
	            int index = indexOf(e);
	            if (index != -1) {
	                remove(index);
	                return true;
	            }
	            return false;
	        }

	        public void sort(Comparator<E> c) {
	            for (int i = 0; i < size - 1; i++) {
	                for (int j = 0; j < size - i - 1; j++) {
	                    if (c.compare(elements[j], elements[j + 1]) > 0) {
	                        E temp = elements[j];
	                        elements[j] = elements[j + 1];
	                        elements[j + 1] = temp;
	                    }
	                }
	            }
	        }
	            public static void main(String[] args) {
	                MyArrayList<Integer> list = new MyArrayList<>();
	                System.out.println("Size: " + list.size()); // Expected output: 0
	                System.out.println("IsEmpty: " + list.isEmpty()); // Expected output: true

	                // Test the add() method
	                list.add(10);
	                list.add(20);
	                list.add(30);
	                System.out.println("Size: " + list.size()); // Expected output: 3
	                System.out.println("IsEmpty: " + list.isEmpty()); // Expected output: false

	                // Test the get() method
	                System.out.println("Element at index 1: " + list.get(1)); // Expected output: 20

	                // Test the set() method
	                list.set(2, 40);
	                System.out.println("Modified list: " + Arrays.toString(list.toArray())); // Expected output: [10, 20, 40]

	                // Test the add(int, E) method
	                list.add(1, 15);
	                System.out.println("Modified list: " + Arrays.toString(list.toArray())); // Expected output: [10, 15, 20, 40]

	                // Test the remove() method
	                list.remove(0);
	                System.out.println("Modified list: " + Arrays.toString(list.toArray())); // Expected output: [15, 20, 40]

	                // Test other methods
	                System.out.println("Index of 20: " + list.indexOf(20)); // Expected output: 1
	                System.out.println("Last index of 20: " + list.lastIndexOf(20)); // Expected output: 1
	                System.out.println("Contains 30: " + list.contains(30)); // Expected output: false

	                // Test the clear() method
	                list.clear();
	                System.out.println("Size after clearing: " + list.size()); // Expected output: 0
	                System.out.println("IsEmpty after clearing: " + list.isEmpty()); // Expected output: true
	            }
	        }

