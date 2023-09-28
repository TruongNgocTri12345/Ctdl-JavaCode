package Lab_01;

public class Task2 {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	private int n; // So buoc dich chuyen( dich chuyen sang phai )

	public Task2(int shiftSteps) {
		this.n = shiftSteps;
	}

	// Ma hoa ki tu theo so buoc dich chuyen da cho
	// Ma hoa: En(x) = (x + n) mod 26.
	public char encryptChar(char c) {
		if (Character.isLetter(c)) { // kt c co phai la mot ki tu chu
			char uppercaseC = Character.toUpperCase(c); // chuyen doi thuong thanh hoa
			int index = (uppercaseC - 'A' + n) % 26; // chi so moi sau khi dich chuyen
			if (index < 0) {
				index += 26;
			}
			return ALPHABET[index];
		} else {
			return c; // Tra ve ki tu ban dau neu khong phai ki tu chu
		}
	}

	// Phuong thuc ma hoa mot chuoi dua tren so buoc dich chuyen n
	public String encrypt(String str) {
		String result = "";
		if (str.trim().equals("")) {
			return result;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			result += encryptChar(ch);
		}
		return result;
	}

	// Giai ma ki tu theo so buoc dich chuyen da cho
	// Giai ma: Dn(x) = (x - n) mod 26.
	public char decryptChar(char c) {
		if (Character.isLetter(c)) {// kt c co phai la mot ki tu chu
			char uppercaseC = Character.toUpperCase(c); // chuyen doi thuong thanh hoa
			int index = (uppercaseC - 'A' - n) % 26;
			return ALPHABET[index];
		} else {
			return c; // Tra ve ki tu ban dau neu khong phai ki tu chu
		}
	}

	// Phương thức giải mã dựa trên số bước dịch n
	public String decrypt(String str) {
		String result = "";
		if (str.trim().equals("")) {
			return result;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			result += decryptChar(ch);
		}
		return result;
	}

	public static void main(String[] args) {
		Task2 caesar = new Task2(3); // dich chuyen 3 buoc
		String str = "HELLO worD";
		String encryptedText = caesar.encrypt(str);
		String decryptedText = caesar.decrypt(encryptedText);

		System.out.println("Original Text: " + str);
		System.out.println("Encrypted Text: " + encryptedText);
		System.out.println("Decrypted Text: " + decryptedText);
	}

}
