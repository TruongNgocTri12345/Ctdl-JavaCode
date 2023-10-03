package Lab_02;

public class Task1_1 {
	// S(n)=1-2+3-4+ .... +((-1)^(n+1) ).n , n>0
	public static int getSn1(int n) {
		if (n == 1) {
			return 1;
		}
		return (int) (getSn1(n - 1) + Math.pow(-1, n + 1) * n);
	}

	// S(n)=1+1.2+1.2.3+ .... +1.2.3....n, n>0
	// tinh giai thua
	public static int giaiThua(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * giaiThua(n - 1);
	}

	// tinh tong cac giai thua
	public static int getSn2(int n) {
		if (n == 1) {
			return 1;
		}
		return giaiThua(n) + getSn2(n - 1);
	}

	// S(n)=1^2+2^2+3^2+....+n^2 , n>0
	public static int getSn3(int n) {
		if (n == 1) {
			return 1;
		}
		return (int) (Math.pow(n, 2) + getSn3(n - 1));
	}

	// S(n)=1+1/2+1/(2.4)+1/(2.4.6)+....+1/(2.4.6.2n), n>=0
	// tinh mau
	public static double mauSo(int n) {
		if (n == 0) {
			return 1.0;
		}
		return 2 * n * mauSo(n - 1);

	}

	// tinh tong
	public static double getSn4(int n) {
		if (n == 0) {
			return 1.0;
		}
		return 1 / mauSo(n) + getSn4(n - 1);
	}

	public static void main(String[] args) {
		int n = 3;
		System.out.println("getSn1: " + getSn1(n));
		System.out.println("getSn2: " + getSn2(n));
		System.out.println("getSn3: " + getSn3(n));
		System.out.println("getSn4: " + getSn4(n));
	}

}
