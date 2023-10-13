package Lab_04;

import java.util.Arrays;

public class Task2_1 {
	public static void mergeSort(int[] array) {
		if (array == null || array.length <= 1) {
			return; // Da sep xep hoac khong co gi de sap xep
		}

		int middle = array.length / 2; // o giua
		int[] leftHalf = new int[middle]; // mang nua ben trai
		int[] rightHalf = new int[array.length - middle]; // mang nua ben phai

		// Chia mang thanh 2 nua
		for (int i = 0; i < middle; i++) {
			leftHalf[i] = array[i];
		}
		for (int i = middle; i < array.length; i++) {
			rightHalf[i - middle] = array[i];
		}

		// sap xep de quy 2 nua
		mergeSort(leftHalf);
		mergeSort(rightHalf);

		// Hop nhat cac nua da sap xep
		merge(leftHalf, rightHalf, array);
	}

	public static void merge(int[] left, int[] right, int[] array) {
		int leftIndex = 0;
		int rightIndex = 0;
		int mergedIndex = 0;

		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] <= right[rightIndex]) { // sua doi tang hoac giam
				array[mergedIndex] = left[leftIndex];
				leftIndex++;
			} else {
				array[mergedIndex] = right[rightIndex];
				rightIndex++;
			}
			mergedIndex++;
		}

		// Copy cac phan tu con lai cua left[] neu co
		while (leftIndex < left.length) {
			array[mergedIndex] = left[leftIndex];
			leftIndex++;
			mergedIndex++;
		}

		// Copy cac phan tu con lai cua right[] neu co
		while (rightIndex < right.length) {
			array[mergedIndex] = right[rightIndex];
			rightIndex++;
			mergedIndex++;
		}
	}

	public static void main(String[] args) {
		int[] array = { 5, 2, 9, 1, 7 };
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}
}