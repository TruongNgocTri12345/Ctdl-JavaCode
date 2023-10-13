package Lab_04;

import java.util.Arrays;

public class Task1_2 {
	public static void bubbleSort(int[] arrray) {
		for (int i = 0; i < arrray.length - 1; i++) {
			boolean stop = true;
			for (int j = 0; j < arrray.length - i - 1; j++) {
				if (arrray[j] > arrray[j + 1]) {
					int temp = arrray[j];
					arrray[j] = arrray[j + 1];
					arrray[j + 1] = temp;
					stop = false;
				}

			}
			if (stop)
				break;

		}
	}

	public static void main(String[] args) {
		int[] array = { 15, 21, 37, 13, 20 };
		Task1_2.bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}

}
