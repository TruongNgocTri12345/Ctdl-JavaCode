package Lab_04;

import java.util.Arrays;

public class Task1_1 {
	public static void selectionSort(int[] arrray) {
		for (int i = 0; i < arrray.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arrray.length; j++) {
				if (arrray[j] < arrray[minIndex]) {
					minIndex = j;
				}

			}
			int temp = arrray[i];
			arrray[i] = arrray[minIndex];
			arrray[minIndex] = temp;

		}
	}

	public static void main(String[] args) {
		int[] array = { 15, 21, 37, 13, 20 };
		Task1_1.selectionSort(array);
		System.out.println(Arrays.toString(array));
	}

}
