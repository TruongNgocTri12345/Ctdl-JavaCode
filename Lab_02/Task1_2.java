package Lab_02;

public class Task1_2 {
	// Example: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, …
	// tra ve so tai vi tri n
	public static int getFibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		return getFibonacci(n - 1) + getFibonacci(n - 2);
	}

	// This method is used to display a Fibonaccci series based on
	// the parameter n. Ex. n=10 ==> 0 1 1 2 3 5 8 13 21 34
	public static void printFibonacci(int n) {
		for (int i = 0; i <= n; i++) {
			System.out.print(getFibonacci(i) + " ");
		}
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println(getFibonacci(n));
		System.out.println("------------------");
		printFibonacci(n);
	}

}
