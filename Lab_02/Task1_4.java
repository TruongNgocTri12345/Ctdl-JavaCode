package Lab_02;

public class Task1_4 {
	public static void moveTower(int disk, char source, char dest, char spare) {
		if (disk == 1) {
			System.out.println("Di chuyen dia 1 tu " + source + " den " + dest);
		} else {
			// Di chuyen n-1 dia tu nguon den bo du phong banh cach su dung dich lam bo du phong.
			moveTower(disk - 1, source, spare, dest);

			// Di chuyen dia cuoi cung tu nguon den dich.
			System.out.println("Di chuyen dia " + disk + " tu " + source + " den " + dest);

			// Di chuyen n-1 dia tu bo du phong den dich banh cach su dung nguon lam bo du phong
			moveTower(disk - 1, spare, dest, source);
		}
	}

	public static void main(String[] args) {
		int disk = 3; // So luong dia
		char source = 'A'; // nguon
		char dest = 'C'; // dich
		char spare = 'B'; // du phong

		moveTower(disk, source, dest, spare);
	}
}
