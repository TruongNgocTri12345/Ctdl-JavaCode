package Lab_05;

public class Task1_3 {
	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) {
		int rowsA = a.length;
		int columnsA = a[0].length;
		int columnsB = b[0].length;
		int[][] result = new int[rowsA][columnsB];
		for (int i = 0; i < rowsA; i++) {
			for (int j = 0; j < columnsB; j++) {
				for (int k = 0; k < columnsA; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
				
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
	/*   7 2     2 2 6 3
	 *   5 3     3 3 7 3
	 *   4 1     
	 *           
	 */
	public static void main(String[] args) {
		int[][] a = { { 7, 2 }, { 5, 3 }, { 4, 1 } };
		int[][] b = { { 2, 2, 6, 3 }, { 3, 3, 7, 3 } };
		matrix(multiply(a, b));
	}

}
