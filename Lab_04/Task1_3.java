package Lab_04;

import java.util.Arrays;

public class Task1_3 {
	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i - 1;
			int key = array[i];
			while (j >= 0 && array[j] > key) {

				array[j + 1] = array[j];
				j = j - 1;

			}
			array[j + 1] = key;
		}

	}

	public static void main(String[] args) {
		int[] array = { 15, 21, 37, 13, 20 };
		Task1_3.insertionSort(array);
		System.out.println(Arrays.toString(array));
	}

}
