package Lab_04;

import java.util.Arrays;
import java.util.Random;

public class Task2_2 {

	public static void quickSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pivot = getPivot_MedianOfThree(array, low, high);
			// Phan vung mang
			int partitionIndex = partition(array, low, high, pivot);
			// Sap xep de quy 2 phan vung
			quickSort(array, low, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, high);
		}
	}

	private static int partition(int[] array, int low, int high, int pivot) {
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (array[j] <= pivot) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, high);
		return i + 1;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static int getPivot_MedianOfThree(int[] array, int low, int high) {
		int mid = (high + low) / 2;
		if (array[low] > array[mid]) {
			swap(array, low, mid);
		}
		if (array[low] > array[high]) {
			swap(array, low, high);
		}
		if (array[mid] > array[high]) {
			swap(array, mid, high);
		}
		return array[mid];
	}

	private static int getPivot_First(int[] array, int low, int high) {
		return low;
	}

	private static int getPivot_Last(int[] array, int low, int high) {
		return high;
	}

	private static int getPivot_Random(int[] array, int low, int high) {
		Random rand = new Random();
		return low + rand.nextInt(high - low + 1);
	}

	public static void main(String[] args) {
		int[] array = { 5, 2, 9, 1, 7, 10 };
		Task2_2.quickSort(array);
		System.out.println(Arrays.toString(array));
	}
}
