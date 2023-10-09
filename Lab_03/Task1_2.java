package Lab_03;

public class Task1_2 {
	private int[] array;

	public Task1_2(int[] array) {
		this.array = array;

	}

	// To find the index of the target in the sorted array. If the
	// target is not found in the array, then the method returns -1.
	public int iterativeBinarySearch(int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == array[mid]) {
				return mid;
			} else {
				if (target < array[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}

			}

		}
		return -1;
	}

	// To find the index of the target in the sorted array. If the
	// target is not
	// found in the array, then the method returns -1.
	public int recursiveBinarySearch(int target) {
		return recursiveBinarySearch(target, 0, array.length - 1);
	}

	private int recursiveBinarySearch(int target, int low, int high) {
		if (low > high) {
			return -1;
		} else {
			int mid = (low + high) / 2;
			if (target == array[mid]) {
				return mid;
			} else {
				if (target < array[mid]) {
					return recursiveBinarySearch(target, low, mid - 1);
				} else {
					return recursiveBinarySearch(target, mid + 1, high);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 12, 10, 9, 45, 2, 10, 8, 90, 10, 45, 60 };
		int target1 = 90;
		Task1_1 MyArray = new Task1_1(array);
		System.out.println(MyArray.iterativeLinearSearch(target1));
		System.out.println("------------------");
		int target2 = 80;
		System.out.println(MyArray.recursiveLinearSearch(target2));
	}

}
