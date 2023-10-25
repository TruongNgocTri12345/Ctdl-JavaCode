package Lab_05;

public class Task1_4 {
	// tranpose a matrix
	public static int[][] transpose(int[][] array) {
		int rows = array.length ;
		int cols = array[0].length ;
		int[][] result = new int[cols][rows] ;
		
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				result[col][row] = array[row][col];
			}
			
		}
	return result;
	}
	//duyet mang 
	public static void printMatrix(int[][] matrix) {
	    for (int[] row : matrix) {
	        for (int value : row) {
	            System.out.print(value + " ");
	        }
	        System.out.println();
	    }
	}
	public static void main(String[] args) {
		int[][] array = {
				        {1,3},
		                {3,4},
		                {5,6}
		            };
		printMatrix(array);
		System.out.println("------------");
		printMatrix(transpose(array));
		
	}
}
