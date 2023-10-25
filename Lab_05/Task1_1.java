package Lab_05;

public class Task1_1 {
	// add 2 matrices
	public static int[][] add(int[][] a, int[][] b) {
		int rows = a.length;
		int columns = a[0].length;
		int[][] result = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}

		}
		return result;
	}

	private static void matrix(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				System.out.print(array[row][col] + " ");

			}
			System.out.println();

		}

	}

	public static void main(String[] args) {
		int[][] a = { { 7, 2 }, { 5, 3 }, { 4, 1 } };
		int[][] b = { { 2, 2 }, { 3, 3 }, { 4, 9 } };
		matrix(add(a, b));
	}

}
