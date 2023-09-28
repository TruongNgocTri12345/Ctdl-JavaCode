package Lab_01;

import java.util.Arrays;

public class Task1 {
	private int[] array;
	
	public Task1(int[] array) {
	this.array = array;
	}
	// input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
	public int[] mirror() {
		int[] result = new int[array.length * 2];
		int index = result.length - 1;

		for (int i = 0; i < array.length; i++) {
			result[i] = array[i];

			result[index--] = array[i];
		}

		return result;
	}

	// Loai bo cac pt trung
	// Input: 1 3 5 1 3 7 9 8
	// Output: 1 3 5 7 9 8
	public int[] removeDuplicates() {
		// Kiểm tra nếu mảng trống hoặc chỉ có một phần tử
		if (array == null || array.length <= 1) {
			return array;
		}

		// Sắp xếp mảng
		// C1 : Arrays.sort(arr);
		this.sort();

		int index = 1; // Số lượng phần tử duy nhất ban đầu là 1

		// Duyệt qua mảng đã sắp xếp và loại bỏ các phần tử trùng lặp
		for (int i = 1; i < array.length; i++) {
			if (array[i] != array[i - 1]) {
				array[index] = array[i];
				index++;
			}
		}

		int[] result = Arrays.copyOf(array, index);

		return result;
	}

	// Input: 10 11 12 13 14 16 17 19 20
	// Output: 15 18
	// getMissingValues : nhan cac gia tri con thieu
	public int[] getMissingValues() {
		int index = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] - array[i - 1] != 1) {
				array[index] = array[i - 1] + 1;
				index++;
			}

		}

		int[] result = Arrays.copyOf(array, index); 

		return result;
	}

	// method sap xep
	public void sort() {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}

	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		Task1 myArray1 = new Task1(arr1);
		System.out.println(Arrays.toString(myArray1.mirror()));
		System.out.println("------------------");
		int[] arr2 = { 1, 2, 3, 2, 3, 5, 7 };
		Task1 myArray2 = new Task1(arr2);
		System.out.println(Arrays.toString(myArray2.removeDuplicates()));
		System.out.println("------------------");
		int[] arr3 = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		Task1 myArray3 = new Task1(arr3);
		System.out.println(Arrays.toString(myArray3.getMissingValues()));
	}

}
