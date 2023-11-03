package Lab_07;

import java.util.*;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T next = iter.next();
			if (p.test(next))
				iter.remove();
		}

	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T next = iter.next();
			if (!p.test(next))
				iter.remove();
		}
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		// TODO
		Set<T> result = new HashSet<>();
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T next = iter.next();
			if (p.test(next))
				result.add(next);
		}
		return result;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		// TODO
		List<T> arr = new ArrayList<>(coll);
		for (int i = 0; i < arr.size(); i++) {
			if (p.test(arr.get(i)))
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		
		Predicate<Integer> evenPredicate = new Even();
		Predicate<Integer> oddPredicate = i -> i % 2 != 0;
		
		Set<Integer> evenNumbers = MyPredicates.collect(numbers, evenPredicate);
        System.out.println("Collected even numbers: " + evenNumbers);
        
		//Remove even numbers
	        MyPredicates.remove(numbers, evenPredicate);
	        System.out.println("After removing even numbers: " + numbers);
	        
	        MyPredicates.retain(numbers, oddPredicate);
	        System.out.println("After retaining odd numbers: " + numbers);
	    
	        int index = MyPredicates.find(numbers, oddPredicate);
	        System.out.println("Index of the first odd number: " + index);
	}
}