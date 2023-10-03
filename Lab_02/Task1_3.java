package Lab_02;

import java.util.Arrays;

public class Task1_3 {

	public static void prinfPascal(int row) {
		for (int i = 1; i <= row; i++) {
			System.out.println(Arrays.toString(getPascal(i)));
		}

	}

	public static int[] getPascal(int n) {
		if (n == 1) {
			return new int[] { 1 };
		} else {
			int[] prevRow = getPascal(n - 1);
			return generateNextRow(prevRow);
		}

	}

	// preRow = 1 => 1,1
	// = 1,1 => 1,2,1
	// =1,2,1 => 1,3,3,1
	public static int[] generateNextRow(int[] prevRow) {
		int[] result = new int[prevRow.length + 1];
		result[0] = 1;
		result[result.length - 1] = 1;

		for (int i = 1; i < result.length - 1; i++) {
			result[i] = prevRow[i - 1] + prevRow[i];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] prevRow = { 1, 1 };
		System.out.println(Arrays.toString(generateNextRow(prevRow)));
		System.out.println("---------------");
		System.out.println(Arrays.toString(getPascal(2)));
		System.out.println("---------------");
		prinfPascal(3);
	}

}
