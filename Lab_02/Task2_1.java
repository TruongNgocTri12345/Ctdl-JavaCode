package Lab_02;

public class Task2_1 {
	public static void printPyramid(int n) {
		for (int i = 1; i <= n; i++) {
			// In ra dau cach de can chinh ben trai
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}

			// In ra dau 'X'
			for (int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("X");
			}

			// Xuong dong sau khi in xong moi hang
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int n = 5; // So hang cua hinh kim tu thap
		printPyramid(n);
	}
}
